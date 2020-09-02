package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

/**
 * Servlet implementation class AddressDetailPrtc
 */
@WebServlet("/address_detail_prtc.do")
public class AddressDetailPrtc extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out= response.getWriter();
		
		/*
		http://192.168.15.31/servletSite/address_detail.do?no=45
		 */
		/*
		 * 1.파라메타 (no)
		 * 2.AddressService객체생성
		 * 3.받은파라메타로 AddressService.selectByNo()메쏘드실행
		 * 4.Address객체반환
		 * 5.보여주기
		 */
		
	
	
		String noStr = request.getParameter("no");
		if(noStr==null||noStr.equals("")) {
			response.sendRedirect("address_main.do");
			return;
		}
			
	
			AddressService addressService = new AddressService();
			
			Address address = new Address();
				address = addressService.selectByNo(Integer.parseInt(noStr));
				
			
			
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='UTF-8'>");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>["+address.getName()+"님 주소록상세보기]</h1><hr>");
		out.print("<div>");
		out.print("	<a href='address_delete_action.do?no="+noStr+">"+address.getName()+"님삭제[GET]</a>z");
		out.print("	<a href='address_update_form.do'>["+address.getName()+"님 주소록수정폼]</a>");
		out.print("	<a href='address_insert_form.do'>[주소록쓰기폼]</a>");
		out.print("	<a href='address_list.do'>[주소록리스트]</a>");
		out.print("</div>");
		out.print("<p>");
		out.print("	번호:"+noStr+"<br>");
		out.print("	아이디:"+address.getId()+"<br>");
		out.print("	이름:"+address.getName()+"<br>");
		out.print("	전화:"+address.getPhone()+"<br>");
		out.print("	주소:"+address.getAddress()+"<br>");
		out.print("</p>");
		out.print("</body>");
		out.print("</html>");
		} catch (Exception e) {
			response.sendRedirect("address_error.html");
			e.printStackTrace();
		}
		
	}
		

}
