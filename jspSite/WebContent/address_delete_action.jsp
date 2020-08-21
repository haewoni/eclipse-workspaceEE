<%@page import="com.itwill.address.Address"%>
<%@page import="com.itwill.address.AddressService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
/*
 요청URL==>
 http://192.168.15.31/servletSite/address_delete_action.do?no=1
				 
  0.요청객체 encoding설정
  1.파라메타 받기
  2.AddressService객체생성
  3.AddressService.delete()메쏘드실행
  4.adress_list.jsp로 redirection
*/
 
 request.setCharacterEncoding("UTF-8");
 String noStr = request.getParameter("no");
 String id = request.getParameter("id");
 String name = request.getParameter("name");
 String phone = request.getParameter("phone");
 String address = request.getParameter("address");
 
 Address deleteAddress = new Address(Integer.parseInt(noStr),id,name,phone,address);
 AddressService addressService = new AddressService();

 addressService.delete(Integer.parseInt(noStr)); 
 
 response.sendRedirect("address_list.jsp");

%>