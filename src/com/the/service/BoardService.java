package com.the.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardService {
	//추상 메서드
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;


}
