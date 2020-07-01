package com.lec.sts15_mybatis.board.command;

import java.util.Arrays;
import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts15_mybatis.board.C;
import com.lec.sts15_mybatis.board.beans.BWriteDTO;
import com.lec.sts15_mybatis.board.beans.IWriteDAO;

public class BViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid");
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		dao.incViewCnt(uid);
		BWriteDTO dto = dao.selectByUid(uid);
		
		model.addAttribute("list", Arrays.asList(dto));
		// BWriteDAO dao = new BWriteDAO();
		// model.addAttribute("list", Arrays.asList(dto));
		
		// Arrays.asList(new String[]{"aaa", "bbb"})
		// Arrays.asList("aaa", "bbb")
		
		
		
		
		
		
		

	}

}















