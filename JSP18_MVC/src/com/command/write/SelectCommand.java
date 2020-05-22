package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class SelectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		WriteDAO dao = new WriteDAO();
		WriteDTO[] arr = null;
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		if(uid != 0 && uid > 0) {
			
			try {
				arr = dao.selectByUid(uid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			} // end if
			
			request.setAttribute("update", arr);
		
	}

}
