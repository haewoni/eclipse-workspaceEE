<%@page import="com.itwill.address.AddressService"%>
<%@page import="com.itwill.address.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 
	//  0.요청객체 encoding설정
	request.setCharacterEncoding("UTF-8");
	//	1.파라메타 받기
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	//	2.AddressService객체생성
	//  3.파라메타데이타로 Address객체생성
	AddressService addressService = new AddressService();
	Address recvAddress = new Address(id,name,phone,address);
	
	//  4.AddressService.create()메쏘드실행
	int insertRowCount = addressService.create(recvAddress);
	//  5.adress_list.jsp 로 redirection
	response.sendRedirect("address_list.jsp");
%>