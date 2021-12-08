<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginpro</title>
</head>
<body>
	loginpro 페이지 입니다.
	<%
	// URI 쿼리 구간에 파라미터명1=값1&파라미터명2=값2... (요청과 함께 전달된 값이 받아짐)
	
	// GET
	// http://localhost:8080/webEx/loginPro.jsp?id=%E3%85%87%E3%85%87%E3%85%87&pw=%E3%85%87dd
	
	// POST : 전달되어지는 파라미터 값을 숨겨서 전달
	// http://localhost:8080/webEx/loginPro.jsp
	request.setCharacterEncoding("UTF-8"); // post의 한글은 새로 인코딩이 필요함
	
	// jsp 의 내장객체 중, request
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// 폼 예제
	// gugudan.jsp
	// 2~9단 안에서 랜덤으로 5개 문제를 출제 (table 처리)
	// 사용자가 문제에 대한 답을 입력(input -> req)
	
	// gugudanPro.jsp
	// 넘어온 파라미터를 바탕으로 성적표를 출력! (정오표)
	
	%>
	<h1>id: <%=id %></h1>
	<h1>pw: <%=pw %></h1>
</body>
</html>