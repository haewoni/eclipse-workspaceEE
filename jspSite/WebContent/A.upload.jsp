<%--@page import="com.oreilly.servlet.MultipartRequest"--%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("A.file_upload.jsp");
		return;
	}
	/*
	POST 방식으로 전송 되어진 파일을 입력 스트림으로 읽어서
	서버의 특정 위치에 저장한다.
	C:\JAVA_PYTHON\eclipse-workspaceEE\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jspSite\\upload
	*/
	String saveDirectory = application.getRealPath("upload");
	MultipartRequest multipartRequest = 
			new MultipartRequest(request,saveDirectory,1024*1024,"UTF-8");
	/*
	   -MultipartRequest 객체를 사용해서 업로드를 종료한 후에는 
		request.getparameter("name")을 사용할 수 없다.
	   -MultipartRequest 객체를 사용해서 파라메타를 읽어야한다
	   ===> multipartRequest.getParameter("name");
	*/
	/*
	<input type=text name=name/>
	<input type=file name=fileone/>
	<input type=file name=filetwo/>
	*/
	String name1 = request.getParameter("name");
	String name2 = multipartRequest.getParameter("name");
	String fileName1 = multipartRequest.getFilesystemName("fileone");
	String fileName2 = multipartRequest.getFilesystemName("filetwo");
%>
<h1>Upload Data</h1>
<hr/>
<br/>
<br/>
<br/>
<li>name1:<%=name1 %></li>
<li>name2:<%=name2 %></li>
<li>fileone:<%=fileName1 %></li>
<li>filetwo:<%=fileName2 %></li>
