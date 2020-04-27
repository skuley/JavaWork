package com.lec.java.crawl07;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * '검색어' 입력받아서
 * 첫페이지의 '국내도서' 첫페이지 20개 아이템 크롤링
 * 		책 이름 / 책가격 / 상세페이지 url / 썸네일 url
 * 
 * yes24.com 검색페이지는 euc-kr로 URL 인코딩 되어 있다.
 * 		한글자당 2byte 지원
 */

public class Crawl07Main {

	private static final String PATH = "books"; // 썸네일 저장할 경로
	
	public static void main(String[] args) throws IOException {

		System.out.println("인터파크 도서 검색결과 페이지");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력하세요");
		String search = sc.nextLine();
		
		// 메소드를 static으로 만들지 않아서 instance를 만들어줬다 
		Crawl07Main app = new Crawl07Main();
		ArrayList<InfoBook> list = app.crawlInterPark(search);
		
		// 썸네일 이미지를 다운로드 할거임~
		// 그리고 thumb001.jpg ~ thum020.jpg ...
		
		int fileIndex = 1;
		
		for(InfoBook e : list) {
			System.out.println(e); // Crawling 정보 출력
			
			// 썸네일 이미지 다운로드 (ImageIO를 사용해서 이미지 다운로드)
			String fileName = String.format(PATH + File.separator + "thumb%03d.jpg", fileIndex);
			
			URL imgUrl = new URL(e.getImgUrl());
			
			BufferedImage imgData = ImageIO.read(imgUrl);
			File file = new File(fileName);
			ImageIO.write(imgData, "jpg", file);
			
			System.out.println(fileName + "이 저장되었습니다");
			
			fileIndex++;
		}
		sc.close();
		
		
		System.out.println("\n프로그램 종료");
		
	} // main
	
	/**
	 * @param search
	 * @return
	 * @throws IOException
	 */
	private ArrayList<InfoBook> crawlInterPark(String search) throws IOException{
		ArrayList<InfoBook> list = new ArrayList<InfoBook>();
		
		// TODO
		// http://book.interpark.com/bookPark/html/book.html
		
		String url = "http://bsearch.interpark.com/dsearch/book.jsp?sch=all&sc.shopNo=&bookblockname=s_main&"
				+ "booklinkname=s_main&bid1=search_auto&bid2=product&bid3=000&bid4=001&query=" + URLEncoder.encode(search, "euc-kr");
		Document doc;
		Response response;
		Elements elements;
		
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("#content > span#bookresult div.list_wrap");
		for(Element e : elements) {
			
			
			String bookTitle = e.selectFirst(".info > p.tit b a").text().trim();
			String imgUrl = e.selectFirst(".bookImg .imgWrap .bimgWrap a img").attr("src").trim();
			System.out.println(imgUrl);
			String linkUrl = "http://book.interpark.com" + e.selectFirst(".info > p.tit b a").attr("href").trim();
			// System.out.println(bookTitle + linkUrl);
			double price = Double.parseDouble(
					e.selectFirst("div.price div.topCon p").text().trim().replace("원", "").replace(",", "")
					);
			// String priceFinal = String.format("%d", (int)price);
			// System.out.println(price);
			
			
			list.add(new InfoBook(bookTitle, price, url, imgUrl));
		} // for
		
		
		return list;
	} // main

}
