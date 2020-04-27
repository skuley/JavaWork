package com.lec.java.crawl05;

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

public class Crawl05Main {

	private static final String PATH = "books"; // 썸네일 저장할 경로
	
	public static void main(String[] args) throws IOException {

		System.out.println("YES-24 Crawling");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력하세요");
		String search = sc.nextLine();
		
		// 메소드를 static으로 만들지 않아서 instance를 만들어줬다 
		Crawl05Main app = new Crawl05Main();
		ArrayList<InfoBook> list = app.crawlYes24(search);
		
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
	private ArrayList<InfoBook> crawlYes24(String search) throws IOException{
		ArrayList<InfoBook> list = new ArrayList<InfoBook>();
		
		// TODO
		// #schMid_wrap > div:nth-child(3)
		
		String url;
		Document doc;
		Response response;
		Element element;
		Elements elements;
		
		url = "http://www.yes24.com/searchcorner/Search?keywordAd=&keyword=&"
				+ "domain=ALL&qdomain=%C0%FC%C3%BC&Wcode=001_005&query=" + URLEncoder.encode(search, "euc-kr");
		
		//System.out.println(url);
		
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("#schMid_wrap > div.goods_list_wrap.mgt30").get(0).select("tr:nth-child(odd)"); // goods_list_wrap.mgt30 : goods_list_wrap 과 mgt30을 가지고 있는 div
		
		System.out.println(elements.size());
		
		for(Element e : elements) {
			// System.out.println(e.text().trim());
			String imgUrl = e.selectFirst("td.goods_img > a > img").attr("src").trim();
			// System.out.println(imgUrl);
			
			Element infoElement = e.selectFirst("td.goods_infogrp > p.goods_name > a");
			
			String bookTitle = infoElement.text().trim();
			String linkUrl = "http://www.yes24.com" +  infoElement.attr("href").trim();
			
			//System.out.println(bookTitle + " : " + linkUrl);
			
			double price = Double.parseDouble( 
			e.selectFirst("td.goods_infogrp > div.goods_price > em.yes_b").text().trim().replace(",", "")
			);
			
			// System.out.println(price + "원"); // 확인요
			
			list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));
		} // for
		
		return list;
	}

}
