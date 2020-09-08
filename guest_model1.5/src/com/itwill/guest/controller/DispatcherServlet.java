package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 모든 요청의 진입점(단일 Controller)
 */

public class DispatcherServlet extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request,response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request,response);
		
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1.클라이언트 요청 >>>>"+request.getRequestURI());
		/*
		 * 1. 클라이언트의 요청URL을 사용해서 요청분석(구분)
		 */
		String requestURI = request.getRequestURI();
//		System.out.println("requestURI:"+requestURI);
		String contextPath = request.getContextPath();
//		System.out.println("contextPath:"+contextPath);
		String command = requestURI.substring(contextPath.length());
//		System.out.println("command:"+command);
		/*
		 * 2.클라이언트의 요청에 따른 업무실행(XXSercive)
		 */
		String forwardPath="";
		if(command.equals("/guest_main.do")) {
			forwardPath="forward:/WEB-INF/views/guest_main.jsp";
			
		}else if(command.equals("/guest_write_form.do")) {
			forwardPath="forward:/WEB-INF/views/guest_write_form.jsp";	
			
		}else if(command.equals("/guest_list.do")) {
			
		}else if(command.equals("/guest_view.do")) {
		
		}
		/*
		 * 3.JSP forward or redirect
		 */
		String [] pathArray = forwardPath.split(":");
		String forwardOrRedirect=pathArray[0];
		String path=pathArray[1];
				
		if(forwardOrRedirect.equals("redirect")) {
			response.sendRedirect(path);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
			
	}

}
