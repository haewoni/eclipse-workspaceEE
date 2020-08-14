package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	*/
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		/*******************************************
		  1.요청시에 전송되는 파라메타받기 
		     - 파라메타이름은 input element의 name속성과일치
		      	<input type="text" name="xxx">
		     - join.do?xxx=java
		     - request.getParameter("xxx")
		     
		    << POST방식 파라메타 값 한글인코딩 >>
		      - 요청객체에 문자인코딩설정
		        request.setCharacterEncoding("UTF-8");
		          
		 **************************************************/
		
		/*
		 * 1.파라메타 받기
		 */
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String[] hobbies=request.getParameterValues("hobby");
		
		/*
		 * 2.Service객체메쏘드 호출
		 */
		
		/*
		 * 3.클라이언트에 결과전송
		 */
		out.print("<tr>");
		out.print("<table border=1 width=300>");
		out.print("</tr>");
		out.println("<h1>"+name+"님 가입정보</h1><hr>");
		out.print("<o1>");
		out.println("<ul>");
		out.println("<li>아이디:"+id+"</li>");
		out.println("<li>주소:"+address+"</li>");
		out.println("<li>성별:"+gender+"</li>");
		for (int i = 0; i < hobbies.length; i++) {
			out.println("<li>취미:"+hobbies[i]+"</li>");
		}
		out.println("</ul>");
		
		
	}

}











