package com.command.write;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.WriteDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;

		WriteDAO dao = new WriteDAO();
		FileDAO fdao = new FileDAO(); // 첨부파일
		
		// ----------------------------------------
		// 1. upload file(들) 부터 처리해야한다
		ServletContext context = request.getServletContext();
		String saveDirectory = context.getRealPath("upload");
		
		int maxPostSize = 5 * 1024 * 1024;
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest(
					request
					, saveDirectory
					, maxPostSize
					, encoding
					, policy
					);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 궁극적으로 이걸 만들기 위해 이렇게 길다...ㅠ
		// *****************************************************
		List<String> originalFileNames = new ArrayList<String>();
		List<String> fileSystemNames = new ArrayList<String>();
		// *****************************************************
		
		Enumeration names = multi.getFileNames(); // type='file' 요소의 name들 추출
		while(names.hasMoreElements()) {
			String name = (String)names.nextElement(); // 
			String originalFileName = multi.getOriginalFileName(name);
			String fileSystemName = multi.getFilesystemName(name);
			System.out.println("첨부파일 : " + originalFileName + "->" + fileSystemName);
			
			if(originalFileName != null && fileSystemName != null) {
				originalFileNames.add(originalFileName);
				fileSystemNames.add(fileSystemName);
			}
		
		} // while
		
		
		// ----------------------------------------
		// 2. 삭제될 첨부 파일(들) 
		String[] delFiles = multi.getParameterValues("delfile");
		if(delFiles != null && delFiles.length > 0) { // 삭제 대상의 파일이 있다면
			int[] delFileUids = new int[delFiles.length];
			
			for(int i = 0; i < delFileUids.length; i++) {
				delFileUids[i] = Integer.parseInt(delFiles[i]);
			}
			
			try {
				fdao.deleteByUid(delFileUids, request); // 물리적 삭제 + DB 테이블 삭제
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} // if
		
		// ----------------------------------------
		// 3. 글 수정 (입력한 값을 받아오기)
		int uid = Integer.parseInt(multi.getParameter("uid"));
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");

		// 유효성 체크  null 이거나, 빈문자열이면 이전화면으로 돌아가기
		if(subject != null && subject.trim().length() > 0){			
			try {			
				cnt = dao.update(uid, subject, content);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} // end if
		
		// --------------------------------------
		// 4. 추가된 첨부파일(들)
		fdao = new FileDAO();
		try {
			fdao.insert(uid, originalFileNames, fileSystemNames);
		} catch(SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("uid", uid); // Mulipart로 받은뒤 updateOk.jsp 로 넘겨야함.
		request.setAttribute("result", cnt);

	}

}
