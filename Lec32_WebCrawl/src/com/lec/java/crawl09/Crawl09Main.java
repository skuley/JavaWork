package com.lec.java.crawl09;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 * 연습
 * 네이버 검색어
 * 블로그
 * 
 *    - post TItle
 *    - post Url
 *    - blog title
 *    
 * Pagination 구현
 * 
 */

public class Crawl09Main {
	
	public static void main(String[] args) throws IOException {
	
		System.out.println("네이버 검색, 페이징");
		
		// TODO
		crawlNaverBlog("자바", 2);
		
		System.out.println("프로그램 종료");
		
	} // main
	
	public static void crawlNaverBlog(String search, int page) throws IOException{
		
		// TODO
		if(search == null || search.trim().length() == 0 || page < 1) return;
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		
		url = String.format("https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%s"
				+ "&sm=tab_pge&srchby=all&st=sim&where=post&start=d", URLEncoder.encode(search, "utf-8") , (page -1) * 10 + 1);
		
		System.out.println(url);
		doc = Jsoup.connect(url).execute().parse();
		
	}

}
