package com.lec.java.crawl00;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl00Main {

	public static void main(String[] args) throws IOException {

		System.out.println("Jsoup");
		
		Element element;
		Elements elements;
		
		File f = new File("data/hello.html");
		// 파일 -> Document 변환 (DOM구조로 변환)
		Document doc = Jsoup.parse(f, "UTF-8"); 

		// System.out.println(doc.outerHtml());
		
		// Document나 Element 객체
		element = doc.selectFirst("div"); // 리턴 타입 Element
		
		// System.out.println(element.outerHtml());
		
		elements = doc.select("div");
		System.out.println(elements.size());
		
		// Elements 의 get(n) -> n번째 Element 리턴
//		element = elements.get(4);
//		System.out.println(element.outerHtml());
//		
//		for(int i = 0; i < elements.size(); i++) {
//			element = elements.get(i);
//			System.out.println(element.outerHtml());
//			System.out.println();
//		}
//		
//		for(Element e : elements) {
//			System.out.println(e.outerHtml());
//			System.out.println();
//		}
		
		element = doc.selectFirst("div#addr");
		// System.out.println(element.outerHtml());
		// element 안에서 a elements들을 찾는다
		elements = element.select("ul.favorite a");
		System.out.println(elements.size());
		
		for(Element e : elements) {
			// System.out.println(e.outerHtml());
			System.out.println(e.text().trim());
			System.out.println(e.attr("href").trim());
		}
		
		elements = doc.select("div img");
		System.out.println(elements.outerHtml());
		System.out.println(elements.size());
		
		for(Element e : elements) {
			System.out.println(e.text().trim());
			System.out.println(e.attr("src").trim());
		}
		
		
		System.out.println("\n프로그램 종료");
		
	} // main

}
