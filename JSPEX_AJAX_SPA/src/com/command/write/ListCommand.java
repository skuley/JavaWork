package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		WriteDAO dao = new WriteDAO(); // DAO 객체 생성
		WriteDTO[] arr = null;

		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본 FAIL

		// 페이징 관련 default 세팅값들
		int page = 1; // 현재 page (default)
		int pageRows = 8; // 한 page에 몇개의 글을 리스트 (default)
		int writePages = 10; // 한 paging 에 몇개의 page 를 표시 (default)
		int totalCnt = 0; // 글은 총 몇개
		int totalPage = 0; // 총 몇 page

		String param;
		
		// page 값 : 현재 몇 page
		param = request.getParameter("page");
		if (param != null && param.trim().length() != 0) {

			try {
				page = Integer.parseInt(param);
			} catch (NumberFormatException e) {
				// 예외 처리 안함
			}
		}
		
		// pageRows 값 : 한 page 에 몇개의 글
		param = request.getParameter("pageRows");
		if (param != null && param.trim().length() != 0) {

			try {
				pageRows = Integer.parseInt(param);
			} catch (NumberFormatException e) {
				// 예외 처리 안함
			}
		}

		try {
			// 글 전체 개수 구하기
			totalCnt = dao.countAll();
			
			// 총 몇 page 분량인가?
			totalPage = (int)Math.ceil(totalCnt / (double)pageRows);
			
			// 몇번째 row부터 수행
			int fromRow = (page - 1) * pageRows + 1;  // ORACLE 은 1 부터 (ROWNUM)
			// int fromRow = (page - 1) * pageRows;  // MySQL 은 0 부터 (ROWNUM)
			
			dao = new WriteDAO();
			arr = dao.selectFromRow(fromRow, pageRows);
			
			if(arr == null) {
				message.append("[리스트할 데이터가 없습니다]");
			} else {
				status = "OK";
			}
			
		} catch (SQLException e) {
			message.append("[트랜잭션 에러 : " + e.getMessage() + "]");
		} // try

		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
		request.setAttribute("list", arr);
		
		request.setAttribute("page", page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("writePages", writePages);
		request.setAttribute("pageRows", pageRows);
		request.setAttribute("totalCnt", totalCnt);

	}
}