<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String name=request.getParameter("name");
    String password=request.getParameter("password");
    String address=request.getParameter("address");
    //DB연결객체 생성
    MemberDao dao = MemberDao.getInstance();
    //DB연결
    Connection con = dao.getConnection();
    //쿼리문
    String sql = "insert into member1 values((select nvl(max(mno),0)+1 from member1),'"
    +name+"','"+password+"','"+address+"')";
    out.print(sql+"<br>");
    //쿼리전송객체
   Statement stmt = con.createStatement();
    int result = stmt.executeUpdate(sql);
    if(result>0){
    	out.print("가입 성공");
    }else{
    	out.print("가입 실패"); 
    }
    %>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>