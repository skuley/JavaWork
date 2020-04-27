package com.lec.java.crawl02;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl02Main {

	public static void main(String[] args) throws IOException {

		System.out.println("네이트 인기 검색어");
		
		String url;
		Document doc;
		Response response;
		Element element;
		Elements elements;
		
		url = "https://www.nate.com";
		response = Jsoup.connect(url).execute();
		doc = response.parse();
		System.out.println(doc.title());
		element = doc.selectFirst("div.search_keyword");
		elements = element.select("a");
		System.out.println(elements.size() + "개 가지고 옵니다");
		//System.out.println(elements.outerHtml());
		
		for(Element e : elements) {
			System.out.println(e.text());
			System.out.println(e.attr("href"));
		}
		
		System.out.println("\n프로그램 종료");
		
	} // main

}
