package com.lec.java.crawl01;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverMovie {

	public static void main(String[] args) throws IOException {
		System.out.println("[결과예]");
		
		movieRank();
		
		

	} // main

	public static void movieRank() throws IOException {
		String url;
		Document doc;
		Response response;
		Elements elements;
		Element element;
		
		url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("div #old_content tbody tr > td");
		element = doc.selectFirst("div #old_content tbody tr td a");

		int i = 1;
		for(Element e : elements) {
			// e.selectFirst("span.blind").remove(); // 1위, 2위, ... 텍스트 <span> 업애려면 해당 element 삭제 (remove)
			if( i <= 5) {
			System.out.println(i++ + "위" + element.text().trim());
			}
		}
		
	} // movieRank()
	
	
}