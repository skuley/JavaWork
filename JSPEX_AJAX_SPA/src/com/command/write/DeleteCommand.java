package com.command.write;

import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;

		WriteDAO dao = new WriteDAO();

		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본 FAIL

		// 유효성 검증
		String[] params = request.getParameterValues("uid");
		int[] uids = null;
		if (params == null || params.length == 0) {
			message.append("[유효하지 않은 parameter 0 or null");
		} else {
			
			uids = new int[params.length];
			
			try {
				
				for(int i = 0; i < params.length; i++) {
					uids[i] = Integer.parseInt(params[i]);
				}
				cnt = dao.deleteByUid(uids);
				status = "OK"; // 결과가 0이여도 OK
			} catch (SQLException e) {
				message.append("[트랜잭션 에러: " + e.getMessage() + "]");
			} catch(Exception e) {
				message.append("[유효하지 않은 parameter ]" + Arrays.toString(params));
			}
		} // if

		request.setAttribute("result", cnt);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
	}

}
