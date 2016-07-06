<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.*"%>
<jsp:useBean id="dao" class="dao.MemberDao" />

<%
	String userid = request.getParameter("userid");
	System.out.print(userid);
	String str = "";
	
	try {
		int isCheck = dao.memID(userid);
		if (isCheck == 1) {
			str = "YES";
			out.print(str);
		} else {
			str = "NO";
			out.print(str);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>