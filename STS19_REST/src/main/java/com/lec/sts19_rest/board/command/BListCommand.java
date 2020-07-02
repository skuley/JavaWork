package com.lec.sts19_rest.board.command;

import java.sql.SQLException;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
//		BWriteDAO dao = new BWriteDAO();
//		List<BWriteDTO> list = dao.select();
//		model.addAttribute("list", list);
		
		// MyBatis 사용
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("list", dao.select());
		
		BWriteDTO[] arr = null;
		
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
				param = model.getAttribute("page").toString();
				if (param != null && param.trim().length() != 0) {

					try {
						page = Integer.parseInt(param);
					} catch (NumberFormatException e) {
						// 예외 처리 안함
					}
				}
				
				// pageRows 값 : 한 page 에 몇개의 글
				param = model.getAttribute("pageRows").toString();
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
					
					dao = new IWriteDAO();
					arr = dao.selectFromRow(fromRow, pageRows);
					
					if(arr == null) {
						message.append("[리스트할 데이터가 없습니다]");
					} else {
						status = "OK";
					}
					
				} catch (SQLException e) {
					message.append("[트랜잭션 에러 : " + e.getMessage() + "]");
				} // try

	} // execute

}








