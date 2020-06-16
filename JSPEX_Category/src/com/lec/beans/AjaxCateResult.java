package com.lec.beans;

public class AjaxCateResult {
	private int count;
	private String status;
	
	public AjaxCateResult() {
		// TODO Auto-generated constructor stub
	}

	public AjaxCateResult(int count, String status) {
		super();
		this.count = count;
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
