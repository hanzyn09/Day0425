package com.the.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.service.BoardService;

public class BoardServiceImpl implements BoardService{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//글쓰기 ...등록 버튼 눌렀을 때 처리
		//웹(클라이언트 페이지) 전송된 데이터 확인
		
		  String subject = request.getParameter("subject"); 
		  String content =request.getParameter("content"); 
		  System.out.println("subject : " + subject);
		  System.out.println("content : " + content);
		  
		 //넘어온 데이터를 DB에 저장
		  
		 
		  //페이지 이동 (response 이용)
		  //http://localhost:8080/board/list //풀네임 써야해서 내장객체 필요, 절대경로 작성은 비추천
		  //response.sendRedirect(request.getContextPath() + "/board/list"); //절대경로 요청
		  
		  //http://localhost:8080/board/write-done
		  response.sendRedirect("list");
		  //url주소가 아래주소로 변경된다.
		  //http://localhost:8080/board/list
		  
		return null;
	}

}
