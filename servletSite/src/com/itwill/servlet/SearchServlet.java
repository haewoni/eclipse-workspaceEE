package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search.do")
public class SearchServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		/*
		 http://192.168.15.31/servletSite/search.do?searchWord=java
		 */
		/*******************************************
		  1.요청시에 전송되는 파라메타 받기
		     - 파라메타이름은 input element의 name속성과일치
		      	<input type="text" name="searchWord">
		     - search.do?searchWord=java
		    
		    << GET방식 파라메타 값 한글인코딩 >>
		      A. server.xml LINE 63 --> URIEncoding="EUC-KR" 속성추가
		       <Connector connectionTimeout="20000" port="80"
					protocol="HTTP/1.1" redirectPort="8443" 
					URIEncoding="UTF-8"/>
		      B.요청객체에 문자인코딩설정  
		 **************************************************/
		
		/*
		 * 1.파라메타 받기
		 */
		String searchWord = request.getParameter("searchWord");
		if(searchWord==null|| searchWord.equals("")) {
			out.println("Ooooops!!! 검색어를 입력하셔야합니다.<hr>");
			out.println("<a href='05-00.search_form.html'>검색페이지</a>");
			return;
		}
		/*
		 * 2.검색업무실행
		 */
		/*
		 * 3.검색결과 HTML 응답
		 */
		out.println("<h1>"+searchWord+"검색결과</h1><hr>");
		out.println("<ol>");
		for(int i=0;i<10;i++) {
			out.println("<li>"+searchWord+" 검색데이타</li>");
		}
		out.println("</ol>");
		out.println("<a href='05-00.search_form.html'>검색페이지</a>");
	}

}












