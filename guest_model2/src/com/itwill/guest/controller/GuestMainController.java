package com.itwill.guest.controller;

public class GuestMainController {
	
	public String handleRequest() {
		/***************************guest_main.do*******************************/
		String forwardPath = "forward:/WEB-INF/views/guest_main.jsp";
		return forwardPath;
	}

}
