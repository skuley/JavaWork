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

		String depthStr = request.getParameter("depth");
		String parentStr = request.getParameter("parent");
		
		if(depthStr == null && parentStr == null ||
				Integer.parseInt(depthStr) == 1 && parentStr == "" ||
				Integer.parseInt(depthStr) == 1 && Integer.parseInt(parentStr) == 0) {
			int depth = 1;
			try {
				arr = dao.selectCate(depth);
				
				if (arr == null) {
					status = "FAIL";
				} else {
					status = "SUCCESS";
				}
			} catch (SQLException e) {
				status = "FAIL";
			}
		} else if(Integer.parseInt(depthStr) > 100 && Integer.parseInt(parentStr) > 100) {
			status = "FAIL";
		} else {
			int depth = Integer.parseInt(depthStr);
			int parent = Integer.parseInt(parentStr);
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
		}
		

		AjaxCateList result = new AjaxCateList();

		result.setStatus(status);

		if (arr != null) {
			result.setCount(arr.length);
			result.setList(Arrays.asList(arr));
		}

		ObjectMapper mapper = new ObjectMapper();

		try {
			String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // execute()

} // CateListCommand{}
