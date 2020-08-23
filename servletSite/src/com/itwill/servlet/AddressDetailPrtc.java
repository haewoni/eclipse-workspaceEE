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
@WebServlet("/address_detail_prtc")
public class AddressDetailPrtc extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
	
	
		int no = Integer.parseInt(request.getParameter("no"));
	
			
		try {
			AddressService addressService = new AddressService();
			
			Address address = new Address();
				address = addressService.selectByNo(no);
				
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset="UTF-8">");
		out.print("<title>Insert title here</title>");
		</head>
		<body>
		<h1>[김경호님 주소록상세보기]</h1><hr>
		<div>
			<a href='address_delete_action.do?no=1'>김경호님삭제[GET]</a>
			<a href='address_update_form.do'>[김경호님 주소록수정폼]</a>
			<a href='address_insert_form.do'>[주소록쓰기폼]</a>
			<a href='address_list.do'>[주소록리스트]</a>
		</div>
		<p>
			번호:1<br>
			아이디:guard<br>
			이름:김경호<br>
			전화:123-4568<br>
			주소:경기도 성남시<br>
		</p>
		</body>
		</html>
		
		
	}
		

}
