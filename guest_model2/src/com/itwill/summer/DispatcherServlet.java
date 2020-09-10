package com.itwill.summer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.controller.GuestErrorController;
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestModifyFormController;
import com.itwill.guest.controller.GuestRemoveActionController;
import com.itwill.guest.controller.GuestViewController;
import com.itwill.guest.controller.GuestWriteActionController;
import com.itwill.guest.controller.GuestWriteFormController;
import com.itwill.guest.controller.guestModifyActionController;


public class DispatcherServlet extends HttpServlet {
	/*
	 * Controller 객체들을 저장하는 맵
	 */
	private HashMap<String, Controller> controllerMap;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		controllerMap=new HashMap<String, Controller>();
		/*
		 * /guest_main.do
			/guest_write_form.do
			/guest_write_action.do
			/guest_list.do
			/guest_view.do
			/guest_modify_form.do
			/guest_modify_action.do
			/guest_remove_action.do
			/guest_error.do
		 */
		
		controllerMap.put("/guest_main.do", new GuestMainController());
		controllerMap.put("/guest_write_form.do", new GuestWriteFormController());
		controllerMap.put("	/guest_write_action.do", new GuestWriteActionController());
		controllerMap.put("/guest_list.do", new GuestListController());
		controllerMap.put("/guest_view.do", new GuestViewController());
		controllerMap.put("/guest_modify_form.do", new GuestModifyFormController());
		controllerMap.put("/guest_modify_action.do", new guestModifyActionController());
		controllerMap.put("/guest_remove_action.do", new GuestRemoveActionController());
		controllerMap.put("	/guest_error.do", new GuestErrorController());
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		/*
		 * 1.클라이언트의 요청URI를  사용해서 요청분석(구분)
		 */
		String requestURI = request.getRequestURI();
		String contextPath= request.getContextPath();
		String command =requestURI.substring(contextPath.length());
		/*
		 * 2.클라이언트의 요청에따른 업무실행(XXService),forwardPath
		 */
		String forwardPath="";
		Controller controller = controllerMap.get(command);
		forwardPath = controller.handleRequest(request, response);
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
