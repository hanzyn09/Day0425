package com.the.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.the.service.BoardService;
import com.the.service.impl.BoardServiceImpl;


@WebServlet("/board/*")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private BoardService boardService;
	    
	public FrontController() {
	    boardService=new BoardServiceImpl();
	}
	    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*
		 * System.out.println("uri : "+request.getRequestURI());
		 * System.out.println("url : "+request.getRequestURL());
		 */
		
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI(); // Day0425/board/list
		String[] uris = uri.split("/"); //문자열 4개가 담긴 배열로 저장
		String key = uris[uris.length-1];
		String path = null;
		System.out.println("key : " + key);
		if(key.equals("list")) {
			path="/view/board/list.jsp";
		}else if(key.equals("write")){
			path="/view/board/write.jsp";
		}else if(key.equals("write-done")) {
			//글쓰기 ...등록 버튼 눌렀을 때 처리
			//웹(클라이언트 페이지) 전송된 데이터 확인
		
			//넘어온 데이터를 DB에 저장
			
			path = boardService.execute(request, response); //권한을 넘겨주고 페이지를 리턴받음
		}else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND); //404 해도 된다.
			return;
		}
				
		//검증, 페이지 이동
		
		//null 인 경우에는 페이지 없다고 에러창 띄워줘야함 :web.xml
				//404 경로 에러 FileNotFoundException
				//500 소스 에러
		if(path == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND); //404 해도 된다.
			return;
		}
		//if(path != null) {
			System.out.println("페이지 이동");
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		//} 
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost로 진입");
		doGet(request, response);
	}

}
