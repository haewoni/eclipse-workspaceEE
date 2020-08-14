package com.itwill.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpServletRequestServlet
 */
@WebServlet("/request.do")
public class HttpServletRequestServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("HttpServletRequestServlet.service()");
		/*
		 * http://192.168.15.3/servletSite/request.do?name=kim&address=LA
		 */
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String queryString = request.getQueryString();
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String contextPath = request.getContextPath();
		String requestURL = request.getRequestURL().toString();
		String requestURI = request.getRequestURI();
		String remoteAddress = request.getRemoteAddr();
		InputStream in = request.getInputStream();
		
		System.out.println("----------------파라미터-----------------");
		out.println("query string:"+queryString);
		out.println("name parameter: "+name);
		out.println("address parameter: "+address);
		out.println("phone parameter: "+phone);
		System.out.println("---------------------------------");
		out.println("contextPath:"+contextPath);
		out.println("requestURL: "+requestURL);
		out.println("requestURI: "+requestURI);
		out.println("remoteAddress: "+remoteAddress);
		out.println("in:"+in);
		
		
		System.out.println("----------------파라미터-----------------");
		out.println("query string:"+queryString);
		out.println("name parameter: "+name);
		out.println("address parameter: "+address);
		out.println("phone parameter: "+phone);
		System.out.println("---------------------------------");
		out.println("contextPath:"+contextPath);
		out.println("requestURL: "+requestURL);
		out.println("requestURI: "+requestURI);
		out.println("remoteAddress: "+remoteAddress);
		out.println("in:"+in);
		}

}
