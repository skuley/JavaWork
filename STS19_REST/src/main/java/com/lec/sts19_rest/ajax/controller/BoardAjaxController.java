package com.lec.sts19_rest.ajax.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.ajax.command.AjaxListCommand;
import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.AjaxWriteList;
import com.lec.sts19_rest.board.beans.IWriteDAO;

@RestController
@RequestMapping("/board")
public class BoardAjaxController {
	
	@GetMapping("/list/{page}/{pageRows}")
	public AjaxWriteList ajaxList(
			@PathVariable("page") int page,
			@PathVariable("pageRows") int pageRows) {
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		AjaxWriteList list = new AjaxWriteList();
		list.setList(dao.select());
		list.setPage(page);
		list.setPageRows(pageRows);
		int totalCnt = dao.countAll();
		
		list.setCount(totalCnt);
		list.setStatus("OK");
		list.setTotalCnt(totalCnt);
		
		int fromRow = (page - 1) * pageRows + 1;
		dao.selectFromRow(fromRow, pageRows);
		
		return list;
	}
}
