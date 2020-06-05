<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String type = request.getParameter("type");
String info = request.getParameter("mem");
//연결객체 생성
MemberDao dao = MemberDao.getInstance();
//연결맺기
Connection con = dao.getConnection();
//쿼리문
String sql = "select * from member where " + (type.equals("name") ? "name" : "address") + " like '%" + info + "%'";
out.print(sql + "<br>");
//쿼리객체 생성
Statement stmt = con.createStatement();
//결과받기
ResultSet rs = stmt.executeQuery(sql);
//결과 처리
while (rs.next()) {
	out.print(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "<br>");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>