package com.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.beans.AjaxCateList;
import com.lec.beans.CategoryDAO;
import com.lec.beans.CategoryDTO;

public class CateListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		CategoryDAO dao = new CategoryDAO();
		CategoryDTO[] arr = null;
		
		String status = "FAIL";
		int depth = 1;
		int parent = 0;
		
		depth = Integer.parseInt(request.getParameter("depth"));
		String param = request.getParameter("parent");
		if(depth == 1 && param == null || param == "") {
			parent = 0;
		} else if(depth >= 1 && param == null || Integer.parseInt(param) > 100 ) {
			status="FAIL";
		} else {
			parent = Integer.parseInt(param);
		}
		
		try {
			arr = dao.selectCate(depth, parent);
			if(arr == null) {
				status = "FAIL";
			} else {
				status = "SUCCESS";
			}
		} catch(SQLException e) {
			status = "FAIL";
		}
		
		
		
		AjaxCateList result = new AjaxCateList();
		
		result.setStatus(status);
		
		if(arr != null) {
			result.setCount(arr.length);
			result.setList(Arrays.asList(arr));
		}
		
		ObjectMapper mapper = new ObjectMapper(); 
		
		try {
			String jsonString = mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(result);
			response.setContentType("application/json; charset=utf-8"); 
			response.getWriter().write(jsonString);
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	} // execute()

} // CateListCommand{}
