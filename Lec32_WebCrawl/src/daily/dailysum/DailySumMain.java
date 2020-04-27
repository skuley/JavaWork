package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요
// JSON 은  jackson 을 활용하여 파싱하세요


public class DailySumMain {
	
	public static final String API_KEY = "4d46796d7366726f3833774a774955";

	private static String url;
	private static URL urlJson;
	private static Document doc;
	private static Elements elements;
	private static Element element;
	static ObjectMapper mapper;

	public static void main(String[] args) throws IOException {
		
		System.out.println("Jsoup과 jackson data-bind를 사용해서 crawling 해보기");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("날짜입력 : ");
		int date = sc.nextInt();
		System.out.print("시작Index : ");
		int indexStart = sc.nextInt();
		System.out.print("끝Index : ");
		int indexEnd = sc.nextInt();
		System.out.println();
		
		// **************** XML ****************
		runXml(date, indexStart, indexEnd);
		
		
		// **************** JSON ****************
		runJson(date, indexStart, indexEnd);
		
		
		
		System.out.println("\n프로그램 종료");

	} // end main
	
	public static String xmlBuilder(String reqType, int indexStart, int indexEnd, int date) {
		String url = String.format("http://openapi.seoul.go.kr:8088/%s/%s/SPOP_DAILYSUM_JACHI/%d/%d/%d", 
				API_KEY, reqType, indexStart, indexEnd, date);
		return url;
	}
	
	public static void runXml(int date, int indexStart, int indexEnd) throws IOException {
		url = xmlBuilder("xml", indexStart, indexEnd, date);
		doc = Jsoup.connect(url).parser(Parser.xmlParser()).get(); // xml에 다른것이 없어서 xmlParser가 없어도 동작은 되지만 나중에는 
		elements = doc.select("row");
		
		System.out.println("[XML]");
		System.out.println("날짜\t\t구ID\t총생활인구수\t일최대이동인구수");
		System.out.println("----------------------------------------------------------------------");
		
		for(Element e : elements) {
			String id = e.selectFirst("STDR_DE_ID").text().trim();
			String  code = e.selectFirst("SIGNGU_CODE_SE").text().trim();
			String totalPop = e.selectFirst("TOT_LVPOP_CO").text().trim();
			String dailyMaxMov = e.selectFirst("DAIL_MXMM_MVMN_LVPOP_CO").text().trim();
			
			System.out.println(id + "\t" + code + "\t" + totalPop + "\t" + dailyMaxMov);
		} // for
	}
	
	public static String jsonBuilder(String reqType, int indexStart, int indexEnd, int date) {
		String url = String.format("http://openapi.seoul.go.kr:8088/%s/%s/SPOP_DAILYSUM_JACHI/%d/%d/%d",
				API_KEY, reqType, indexStart, indexEnd, date);
		return url;
	}
	
	public static void runJson(int date, int indexStart, int indexEnd) throws IOException, JsonParseException, JsonMappingException {
		mapper = new ObjectMapper();
		urlJson = new URL(jsonBuilder("json", indexStart, indexEnd, date));
		// System.out.println(urlJson);
		SpopDailysumJachi top = mapper.readValue(urlJson, SpopDailysumJachi.class);
		// System.out.println(top.getSPOP_DAILYSUM_JACHI().getRow());
		
		System.out.println("[XML]");
		System.out.println("날짜\t\t구ID\t총생활인구수\t일최대이동인구수");
		System.out.println("----------------------------------------------------------------------");
		for (Row e : top.getSPOP_DAILYSUM_JACHI().getRow()) {
			System.out.println(e.getStdrDeid() + "\t" + e.getCode() + "\t" + e.getTotalPop() + "\t" + e.getDailyMaxmov());
		}
		// System.out.println(top.getSPOP_DAILYSUM_JACHI().getRow().size());
	}

} // end class



@JsonIgnoreProperties(ignoreUnknown = true)
class SpopDailysumJachi {
	public Row2 SPOP_DAILYSUM_JACHI; // java에서는 멤버변수 이름을 대문자로 하지말자

	public Row2 getSPOP_DAILYSUM_JACHI() {
		return SPOP_DAILYSUM_JACHI;
	}

	public void setSPOP_DAILYSUM_JACHI(Row2 sPOP_DAILYSUM_JACHI) {
		SPOP_DAILYSUM_JACHI = sPOP_DAILYSUM_JACHI;
	}

	
	
}


@JsonIgnoreProperties(ignoreUnknown = true)
class Row2 {
	private List<Row> row;

	public List<Row> getRow() {
		return row;
	}

	public void setRow(List<Row> row) {
		this.row = row;
	}
	
	
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Row {
	
	@JsonProperty("STDR_DE_ID")
	private String stdrDeid;
	@JsonProperty("SIGNGU_CODE_SE")
	private String code;
	@JsonProperty("TOT_LVPOP_CO")
	private String totalPop;
	@JsonProperty("DAIL_MXMM_MVMN_LVPOP_CO")
	private String dailyMaxmov;
	
	// 기본 생성자 (Default Constructor)
	public Row() {
		// TODO Auto-generated constructor stub
	}

	// Constructor using Fields
	public Row(String stdrDeid, String code, String totalPop, String dailyMaxmov) {
		super();
		this.stdrDeid = stdrDeid;
		this.code = code;
		this.totalPop = totalPop;
		this.dailyMaxmov = dailyMaxmov;
	}

	public String getStdrDeid() {
		return stdrDeid;
	}

	// Getters & Setters
	public void setStdrDeid(String stdrDeid) {
		this.stdrDeid = stdrDeid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTotalPop() {
		return totalPop;
	}

	public void setTotalPop(String totalPop) {
		this.totalPop = totalPop;
	}

	public String getDailyMaxmov() {
		return dailyMaxmov;
	}

	public void setDailyMaxmov(String dailyMaxmov) {
		this.dailyMaxmov = dailyMaxmov;
	}
	
	

	
	
	
	
}
