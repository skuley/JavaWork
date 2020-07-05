package com.lec.sts19_rest.ajax.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.AjaxWriteList;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

@RestController
@RequestMapping("/board")
public class BoardAjaxController {
	
	@RequestMapping("/list/{page}/{pageRows}")
	public AjaxWriteList ajaxList(
			@PathVariable("page") String pageParam,
			@PathVariable("pageRows") String pageRowsParam) {
		
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		int page = 1;
		int pageRows = 8;
		int writePages = 10;
		int totalCnt = 0;
		int totalPage = 0;
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		AjaxWriteList list = new AjaxWriteList();
		
		// pageParam (게시판 페이지) parameter 검사 [ 현재 몇 페이지 ]
		if(pageParam != null && pageParam.trim().length() != 0) {
			
			try {
				page = Integer.parseInt(pageParam);
			} catch (NumberFormatException e){
				System.out.println("숫자 타입이 아닙니다. 문자를 적었는지 확인하세요");
			}
		}
		
		// pageRowsParam (한 페이지에 몇개 보여줄지) parameter 검사
		if(pageRowsParam != null && pageRowsParam.trim().length() != 0) {
			try {
				pageRows = Integer.parseInt(pageRowsParam);
			} catch(NumberFormatException e) {
				System.out.println("숫자 타입이 아닙니다. 문자를 적었는지 확인하세요");
			}
		}	
		
		totalCnt = dao.countAll();
		totalPage = (int)Math.ceil(totalCnt / (double)pageRows);
		int fromRow = (page - 1) * pageRows + 1;
		
		List<BWriteDTO> data = dao.selectFromRow(fromRow, pageRows);
		
		if(data == null) {
			message.append("[리스트할 데이터가 없습니다.]");
		} else {
			status = "OK";
			message.append("[데이터 가져오기 성공!]");
		}
		
		list.setCount(data.size());
		list.setStatus(status);
		list.setMessage(message.toString());
		list.setPage(page);
		list.setList(data);
		list.setTotalPage(totalPage);
		list.setTotalCnt(totalCnt);
		list.setWritePages(writePages);
		
		return list;
	}
	
	@RequestMapping(value="/writeOk.ajax", method=RequestMethod.POST)
	public int ajaxWrite() {
		int cnt = 0;
		
		
		
		return cnt;
	}
}
