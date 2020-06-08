<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String id = request.getParameter("id");
String password1 = request.getParameter("password1");
String password2 = request.getParameter("password2");
String name = request.getParameter("name");
int tel = Integer.parseInt(request.getParameter("tel"));
String email = request.getParameter("email");
String dob = request.getParameter("dob");
String url = request.getParameter("url");
String gender = request.getParameter("gender");

//DB연결 객체 생성
Dao dao = Dao.getInstance();
//DB연결
Connection con = dao.getConnection();
//쿼리문
String sql = "insert into register values('" + id + "','" + password1 + "','" + password2 + "','" + name + "','" + tel
		+ "','" + email + "','" + dob + "','" + url + "','" + gender + "')";
out.print(sql + "<br>");
//쿼리 전송객체
Statement stmt = con.createStatement();
int result = stmt.executeUpdate(sql);
if (result > 0) {
	out.print("가입 성공");
} else {
	out.print("가입 실패");
}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>