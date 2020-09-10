package com.itwill.summer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestWriteFormController;

/*
모든요청의 진입점(단일 Controller)
 	<<요청command>>
	/guest_main.do
	/guest_write_form.do
	/guest_write_action.do
	/guest_list.do
	/guest_view.do
	/guest_modify_form.do
	/guest_modify_action.do
	/guest_remove_action.do
	/guest_error.do
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
			GuestMainController controller = new GuestMainController();
			forwardPath = controller.handleRequest();
		}else if(command.equals("/guest_write_form.do")) {
			GuestWriteFormController controller = new GuestWriteFormController();
			forwardPath = controller.handleRequest();
		}else if(command.equals("/guest_list.do")) {
			GuestListController controller = new GuestListController();
			forwardPath = controller.handleRequest(request);
		}else if(command.equals("/guest_view.do")) {
			/***************************guest_view*******************************
			String guest_noStr = request.getParameter("guest_no");
			if(guest_noStr==null||guest_noStr.equals("")){
				forwardPath="redirect:guest_list.do";
			}else {
				try {
					GuestService guestService=new GuestService();
					Guest guest=
							guestService.selectByNo(Integer.parseInt(guest_noStr));
					request.setAttribute("Guest", guest);
					forwardPath = "forward:/WEB-INF/views/guest_view.jsp";
				}catch (Exception e) {
					e.printStackTrace();
					forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
				}
			}
			*/
		}else if(command.equals("/guest_write_action.do")) {
			/***************************guest_write_action*******************************
			if(request.getMethod().equalsIgnoreCase("GET")){
				//response.sendRedirect("guest_write_form.do");
				forwardPath="redirect:guest_write_form.do";
			}else {
				try{
					request.setCharacterEncoding("UTF-8");
					String guest_name=request.getParameter("guest_name");
					String guest_email=request.getParameter("guest_email");
					String guest_homepage=request.getParameter("guest_homepage");
					String guest_title=request.getParameter("guest_title");
					String guest_content=request.getParameter("guest_content");
					Guest guest=
							new Guest(-999,guest_name,
									  null,guest_email,
									  guest_homepage,guest_title,
									  guest_content);
					GuestService guestService=new GuestService();
					int insertRowCount=
							guestService.insertGuest(guest);
					//response.sendRedirect("guest_list.do");
					forwardPath="redirect:guest_list.do";				
					
				}catch(Exception e){
					e.printStackTrace();
//					response.sendRedirect("guest_error.jsp");
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
				}
			}
			*/
		}else if(command.equals("/guest_modify_form.do")) {
			/***************************guest_modify_form*******************************
			if(request.getMethod().equalsIgnoreCase("GET")){
//				response.sendRedirect("guest_main.jsp");
				forwardPath="redirect:guest_main.do";
				
			}else {
				try {
					String guest_noStr = request.getParameter("guest_no");
					GuestService guestService=new GuestService();
					Guest guest=
							guestService.selectByNo(Integer.parseInt(guest_noStr));
					request.setAttribute("guest", guest);
					forwardPath="forward:/WEB-INF/views/guest_modify_form.jsp";
				}catch (Exception e) {
					e.printStackTrace();
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
				}
			}
	*/
		}else if(command.equals("/guest_modify_action.do")) {
			/***************************guest_modify_action*******************************
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:guest_main.do";
			}else {
				try{
					request.setCharacterEncoding("UTF-8");
					String guest_noStr=request.getParameter("guest_no");
					String guest_name=request.getParameter("guest_name");
					String guest_email=request.getParameter("guest_email");
					String guest_homepage=request.getParameter("guest_homepage");
					String guest_title=request.getParameter("guest_title");
					String guest_content=request.getParameter("guest_content");
					GuestService guestService=new GuestService();
					int updateRowCount=
							guestService.updateGuest(
										new Guest(Integer.parseInt(guest_noStr),
											guest_name,null,
											guest_email,guest_homepage,
											guest_title,guest_content));
					forwardPath="redirect:guest_view.do?guest_no="+guest_noStr;
				}catch(Exception e){
					e.printStackTrace();
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
					
				}
			}	
			*/
		}else if(command.equals("/guest_remove_action.do")) {
			/***************************guest_remove_action*******************************
			forwardPath="forward:/WEB-INF/views/guest_remove_action.jsp";
			if(request.getMethod().equalsIgnoreCase("GET")){
				//response.sendRedirect("guest_main.do");
				forwardPath="redirect:guest_main.do";
			}else {
			    try{
				    String guest_noStr = request.getParameter("guest_no");
				    GuestService guestService=new GuestService();
				    guestService.deleteGuest(Integer.parseInt(guest_noStr));
				    //response.sendRedirect("guest_list.do");
				    forwardPath="redirect:guest_list.do";
			    }catch(Exception e){
			    	e.printStackTrace();
			    	//response.sendRedirect("guest_error.do");
			    	forwardPath="redirect:guest_error.do";
			    }
			}	
			*/
		}else if(command.equals("/guest_error.do")) {
			/***************************guest_error*******************************
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		
		}
		*/
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

}
