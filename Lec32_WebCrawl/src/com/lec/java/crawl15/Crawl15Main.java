package com.lec.java.crawl15;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

/* XML, JSON 파싱 연습
 * ■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/stationInfo/1/5/서울

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/서울
 */

public class Crawl15Main {

	public static void main(String[] args) throws IOException {

		System.out.println("jackson-databind 연습 2");

		ObjectMapper mapper = new ObjectMapper();

		String search = "서울";

		URL url = new URL(String.format(
				"http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/%s",
				URLEncoder.encode(search, "utf-8")));
		System.out.println(url);

		StationList staList = mapper.readValue(url, StationList.class);
		// System.out.println(staList.getStationList().getRows().getSubRow());
		System.out.println(staList.getStationList().size());

		for (SubRow e : staList.getStationList()) {
			System.out.printf("%s: %s역 %s \n", e.getStatnId(), e.getStatnNm(), e.getSubwayNm());
		}

		System.out.println("\n프로그램 종료");

	} // main

}

@JsonIgnoreProperties(ignoreUnknown = true)
class StationList {
	private List<SubRow> StationList; // 항상 property name은 똑같이 해주자!!!!!

	public List<SubRow> getStationList() {
		return StationList;
	}

	public void setStationList(List<SubRow> stationList) {
		this.StationList = stationList;
	}

	
}

@JsonIgnoreProperties(ignoreUnknown = true)
class SubRow {

	private String statnId;
	private String statnNm;
	private String subwayNm;

	public SubRow() {
		// TODO Auto-generated constructor stub
	}

	public SubRow(String statnId, String statnNm, String subwayNm) {
		super();
		this.statnId = statnId;
		this.statnNm = statnNm;
		this.subwayNm = subwayNm;
	}

	public String getStatnId() {
		return statnId;
	}

	public void setStatnId(String statnId) {
		this.statnId = statnId;
	}

	public String getStatnNm() {
		return statnNm;
	}

	public void setStatnNm(String statnNm) {
		this.statnNm = statnNm;
	}

	public String getSubwayNm() {
		return subwayNm;
	}

	public void setSubwayNm(String subwayNm) {
		this.subwayNm = subwayNm;
	}

}
