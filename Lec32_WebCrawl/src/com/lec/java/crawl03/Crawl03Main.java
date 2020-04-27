package com.lec.java.crawl03;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {

	public static void main(String[] args) throws IOException {

		System.out.println("Daum 실시간 검색어");
		
		// TODO
		String url = "http://www.daum.net";
		Response response;
		Document doc;
		Element element;
		Elements elements;
		
		response = Jsoup.connect(url).execute();
		doc = response.parse();
		
		elements = doc.select("div.slide_favorsch ul.list_favorsch li a");
		
		for(Element e : elements) {
			System.out.println(e.text().trim());
			System.out.println(e.attr("href").trim());
		}
		
		System.out.println("\n프로그램 종료");
		
	} // main

}
