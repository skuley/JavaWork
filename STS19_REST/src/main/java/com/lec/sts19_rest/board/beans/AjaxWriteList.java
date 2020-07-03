package com.lec.sts19_rest.board.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AjaxWriteList extends AjaxWriteResult {
	@JsonProperty("data")
	private List<BWriteDTO> list; // 데이터 목록
	
	private int page; // 현재 페이지
	
	@JsonProperty("totalpage")
	private int totalPage; // 전체 페이지
	
	@JsonProperty("totalcnt")
	private int totalCnt; //  전체 글
	
	@JsonProperty("writepages")
	private int writePages; // 한 paging에 몇개의 page를 표현할것인가
	
	@JsonProperty("pagerows")
	private int pageRows; // 한 page에 몇개의 글을 리스트 할것인가
	
	
	public List<BWriteDTO> getList() {
		return list;
	}
	public void setList(List<BWriteDTO> list) {
		this.list = list;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getWritePages() {
		return writePages;
	}
	public void setWritePages(int writePages) {
		this.writePages = writePages;
	}
	public int getPageRows() {
		return pageRows;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	
	
	
}
