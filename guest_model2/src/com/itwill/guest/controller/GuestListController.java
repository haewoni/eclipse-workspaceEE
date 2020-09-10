package com.itwill.guest.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestListController {
	public String handleRequest(HttpServletRequest request) {
		/********************guest_list.do***********************/
		String forwardPath="";
		try {
			GuestService guestService=new GuestService();
			ArrayList<Guest> guestList=guestService.selectAll();
			request.setAttribute("guestList", guestList);
			forwardPath="forward:/WEB-INF/views/guest_list.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		
		return forwardPath;
	}
}
