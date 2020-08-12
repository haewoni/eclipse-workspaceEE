package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
		
		/*
		 * 1. HttpServlet 상속
		 */

public class HelloServlet extends HttpServlet {
	
		/*
		 * 2. service 메소드 재정의
		 */
	
	@Override
	public void service(HttpServletRequest request, 
						HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 2-1. 응답 헤더 ContentType 설정
		 */
		
		response.setContentType("text/html;charset=UTF-8"  );
		
		/*
		 * 2-2. 클라이언트(웹브라우져)로 전송할 스트림 생성
		 */
		
		PrintWriter out = response.getWriter(); 
		
		/*
		 * 2-3. 클라이언트(웹브라우져)로 데이터 출력
		 */
		
	 	for(int i = 0;i<1000;i++) {
			out.println("<h3>HelloServlet"+(i+1)+"[Servlet]!!!</h3><hr>");
			
		}
		
		
	}
}
