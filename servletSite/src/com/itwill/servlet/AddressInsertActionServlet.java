package com.itwill.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

/**
 * Servlet implementation class AddressInsertActionServlet
 */
@WebServlet("/address_insert_action.do")
public class AddressInsertActionServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("address_insert_form.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/*
			 * 0.요청객체 encoding설정
			 * 1.파라메타 받기
			 * 2.AddressService객체생성
			 * 3.파라메타데이타로 Address객체생성
			 * 4.AddressService.create()메쏘드실행
			 * 5.adress_list.do로 redirection
			 */
			request.setCharacterEncoding("UTF-8");
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			
			Address recvAddress=new Address(id, name, phone, address);
			AddressService addressService=new AddressService();
			
			int insertRowcount = addressService.create(recvAddress);
			
			response.sendRedirect("address_list.do");
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("address_error.html");
		}
		
	}

}














