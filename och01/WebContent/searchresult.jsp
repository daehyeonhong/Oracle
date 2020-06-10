<%@page import="model.Dao"%>
<%@page import="java.util.Date"%>
<%@page import="model.Board"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 자바 코드가 입력되는 부분 -스크립틀립 -->
<%
	String type = request.getParameter("type");
String text = request.getParameter("search");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과</h1>
	<!-- 클라이언트로 부터 넘어온 조회 조건과 값 -->
	조회조건:<%=type%><br> 조회할 내용:<%=text%><br>
	<%
		String qstr = null;
	if (type.equals("title"))
		qstr = "title";
	else
		qstr = "content";
	//쿼리문 생성
	//검색 select * from 테이블 where 칼럼 like '%검색문장&'
	String sql = "select * from board where " + qstr + " like " + "'%" + text + "%'";
	//쿼리문 출력
	out.print("쿼리결과:" + sql + "<br>");

	//배열 선언
	Board[] boards = new Board[3];
	int index = 0;

	Dao dao = Dao.getInstance();//Dao:oracle Database와 연결을 중개하는 객체
	Connection con = dao.getConnection();//연결 맺기
	Statement stmt = con.createStatement();//sql문을 전송할 쿼리 객체
	ResultSet rs = stmt.executeQuery(sql);
	while (rs.next()) {//next() 반복자 역할
		int bno = rs.getInt("bno");//숫자값 getInt(칼럼명)
		String title = rs.getString("title");//문자열 getString(칼럼명)
		String content = rs.getString("content");//문자열 getString(칼럼명)
		Date regdate = rs.getDate("regdate");//날짜(문자열)getString(칼럼명)
		out.print("글번호: " + bno + "제목: " + title + ", 내용: " + content + ", 등록일: " + regdate + "<br>");//출력
		Board board = new Board(bno, title, content, regdate);
		boards[index++] = board;
	}
	%>
	<%
		for (int i = 0; i < boards.length; i++) {
		out.print(boards[i].toString() + "<br>");
	}
	%>
</body>
</html>