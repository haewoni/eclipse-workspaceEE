package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetLoginServlet
 */
@WebServlet("/post_login.do")
public class PostLoginServlet2 extends HttpServlet {
	
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*	
		System.out.println("요청방식(method):"+request.getMethod());
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<h1>잘못된 요청방식입니다</h1><hr>");
			out.println("<a href='05-02.login_post.html'>로그인폼[POST]</a>");
		
		*/
		response.sendRedirect("05-02.login_post.html");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청방식(method):"+request.getMethod());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		 /*
		  * 1.요청시에 전송되는 파라메타 받기
		  
		     - 파라메타이름은 input element의 name속성과일치
		      	<input type="text" name="id">
		      	<input type="text" name="pass">
		     - search.do?searchWord=java
		  */
		    
		/*
		 * 1.파라미터 받기
		 */
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		if(id==null || pass== null || id.equals("")|| pass.equals("")) {
			out.println("<h1>아이디, 패스워드를 입력하세요<h1><hr>");
			out.println("<a href='05-02.login_post.html'>로그인폼[POST]</a>");
			return;
		}
	    
		/*
		 * 2.Service 메소드 실행(login)
		 */
		/*
		 * 
		 */
		boolean isMember1 = id.equals("xxx") && pass.contentEquals("1111");
		boolean isMember2 = id.equals("yyy") && pass.contentEquals("2222");
		/*
		 * 3.클라이언트로 결과전송(응답)
		 */
		out.println("<h1>POST 로그인결과</h1><hr>");
		if(isMember1 || isMember2) {
			//로그인 성공
			/*
			out.println("<h3>"+id+" 님 로그인 성공<h3><hr>");
			out.println("<a href ='index.html'>메인으로</a>");
			*/
			response.sendRedirect("index.html");
		}else {
			//로그인 실패
			out.println("<h3>"+id+" 님 로그인 실패<h3><hr>");
			out.println("<a href='05-02.login_post.html'>다시로그인</a>");
		}
		
	}

}
