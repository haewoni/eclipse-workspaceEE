<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>기본객체 application(ServletContect)</h1>
<hr/>
<p>
	context(사이트)의 정보를 가지고 있는 객체
</p>
<ol>
<li>서버정보<%=application.getServerInfo()%></li>
<li>major version : <%=application.getMajorVersion()%></li>
<li>minor version : <%=application.getMinorVersion()%></li>
<li>context real path : <%=application.getRealPath("")%></li>
<li>log : <% application.log(">>>>>>>> 현재날짜:"+new Date().toString()); %></li>
<!-- 
	<< web-xml >>
	  <context-param>
	  	<param-name>admin</param-name>
	  	<param-value>신혜원</param-value>
	  </context-param>
	  <context-param>
	  	<param-name>contextPath</param-name>
	  	<param-value>/jspSite</param-value>
	  </context-param>
 -->
<li>parameter name : contextPath : <%=application.getInitParameter("contextPath")%></li>
<li>parameter name : admin : <%=application.getInitParameter("admin")%> </li>
</ol>
</body>
</html>
