package com.lec.sts19_rest.ajax.controller;

import java.util.Arrays;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.AjaxWriteList;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

@RestController
@RequestMapping("/board")
public class BoardAjaxController {
	
	@RequestMapping("/list")
	public AjaxWriteList ajaxList(int fromRow, int pageRows, Model model) {
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		BWriteDTO dto = (BWriteDTO) dao.select();
		AjaxWriteList list = new AjaxWriteList();
		
		list.setList(Arrays.asList(dto));
		
		dao.selectFromRow(fromRow, pageRows);
		return list;
	}
}
