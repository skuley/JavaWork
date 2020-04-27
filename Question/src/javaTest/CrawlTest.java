package javaTest;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlTest {

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
			if( i <= 5) {
			System.out.println(i++ + "위" + e.text().trim());
			}
		}
		
	} // movieRank()
	
	
}
