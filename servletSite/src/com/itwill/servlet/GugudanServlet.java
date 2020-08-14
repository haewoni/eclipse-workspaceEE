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
public class GugudanServlet extends HttpServlet {
		
	/*
		 * 2. service 메소드 재정의
		 */
	
	protected void service(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {

		
		/*
		 * 2-1. 응답 객체에 응답 헤더 ContentType 설정
		 */
		 
		response.setContentType("text/HTML;charset=UTF-8");

		/*
		 * 2-2. 응답 객체로부터 클라이언트(웹브라우져)로 전송할 스트림 생성
		 */
		PrintWriter out = response.getWriter();
		
		/*
		 * 2-3. 클라이언트(웹브라우져)로 데이터 출력
		 */
		
//		for(int i = 1; i < 10; i++) {
//			for (int j = 2; j < 10; j++) {
//			out.printf(" %d*%d = %2d  ",j,i,i*j);
//			}
//			out.println();
//		}
		
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>방가워요 서블릿</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<center><H2>서블릿 잘났어 정말 별꼴이야!!!!!!!!!</H2><center>");
		out.println("<img src='tomcat.gif'/>");
		

		out.println("<center><H2>서블릿 구구단</H2></center>");
		out.println("<table border=1 width=600 bgcolor=#CCFF33 bordercolordark=#FF6600 cellspacing=0>");
		// loop start
		for(int i = 1; i < 10; i++) {
			out.println("<tr>");
			for (int j = 2; j < 10; j++) {
			out.println("<td align=center>"+j+"*"+i+"="+i*j+"</td>");
			}
			out.println("</tr>");

		out.println("</table>");
		out.println("<br/>");
		out.println("</BODY>");
		out.println("</HTML>");
		
		
		
		/*
		"2*1=2  3*1=3  4*1=4  5*1=5  6*1=6  7*1=7  8*1=8  9*1=9
		2*2=4  3*2=6  4*2=8  5*2=10 6*2=12 7*2=14 8*2=16 9*2=18
		2*3=6  3*3=9  4*3=12 5*3=15 6*3=18 7*3=21 8*3=24 9*3=27
		2*4=8  3*4=12 4*4=16 5*4=20 6*4=24 7*4=28 8*4=32 9*4=36
		2*5=10 3*5=15 4*5=20 5*5=25 6*5=35 7*5=35 8*5=40 9*5=45
		2*6=12 3*6=18 4*6=24 5*6=30 6*6=36 7*6=42 8*6=48 9*6=54
		2*7=14 3*7=21 4*7=28 5*7=35 6*7=42 7*7=49 8*7=56 9*7=63
		2*8=16 3*8=24 4*8=32 5*8=40 6*8=48 7*8=56 8*8=64 9*8=72
		2*9=18 3*9=27 4*9=36 5*9=45 6*9=54 7*9=63 8*9=72 9*9=81 
		 */
	}

}
