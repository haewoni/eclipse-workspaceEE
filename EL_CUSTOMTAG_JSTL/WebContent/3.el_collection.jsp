<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Guest g1 = new Guest(1,"KIM","2020","guard1@gmail.com","http://naver.com","타이틀1","콘텐트1");
	Guest g2 = new Guest(1,"SIM","2021","guard2@gmail.com","http://oaver.com","타이틀2","콘텐트2");
	Guest g3 = new Guest(1,"DIM","2022","guard3@gmail.com","http://paver.com","타이틀3","콘텐트3");
	ArrayList<Guest> guestList = new ArrayList<Guest>();
	guestList.add(g1);
	guestList.add(g2);
	guestList.add(g3);
	
	request.setAttribute("guestList", guestList);
	
	pageContext.setAttribute("i", 2);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL ArrayList, 배열객체출력</h1><hr/>
<ul>
	<li>-------ArrayList-------</li>
	<li>${guestList}</li>
	<li>${guestList[0]}</li>
	<li>${guestList[0].guest_no}</li>
	<li>${guestList[0].guest_name}</li>
	<li>${guestList[0].guest_email}</li>
	<li>${guestList[0].guest_homepage}</li>
	<li>${guestList[0].guest_title}</li>
	<li>${guestList[0].guest_content}</li>
	<li>${guestList}</li>
	<li>${guestList[i]}</li>
	<li>${guestList[i].guest_no}</li>
	<li>${guestList[i].guest_name}</li>
	<li>${guestList[i].guest_email}</li>
	<li>${guestList[i].guest_homepage}</li>
	<li>${guestList[i].guest_title}</li>
	<li>${guestList[i].guest_content}</li>
	<li>------------for------------</li>
	<%
	for(int j=0;j<3;j++){ 
		request.setAttribute("j", j);
	%>
		<li>${guestList[j].guest_no},${guestList[j].guest_name},${guestList[j].guest_email}}</li>
		
	<%} %>
</ul>
	
</body>
</html>