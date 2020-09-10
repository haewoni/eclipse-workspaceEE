package com.itwill.summer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	 * - 모든 컨트롤러가 구현해야 하는 인터페이스(규칙)
	 * - Controller 구현 객체는 DispatcherServlet이 구현 객체의 메소드를 호출해서 업무 실행
	 * - Controller 구현 객체는 DispatcherServlet에게 ForwardPath를반환
	 */

public interface Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
