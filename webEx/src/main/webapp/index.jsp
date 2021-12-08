
<%-- jsp 주석 태그 --%>
<!-- 지시자 태그 (브라우저에게 문제의 정보를 전달 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello world
	<%
	// JSP : Java Server Page
	// ㄴ html 문서 안에 java 문장(코드)를 작성하는 것
	
	// 1) 지시자 태그 <%@ % >
	// 2) 주석 태그 <%-- --% >
	// 3) 스크립틀릿 <% % >
	// 4) 표현식 <%= % >
	
	
	// 스크립틀릿(scriptlet) 태그 안에 자바 문장을 작성 할 수 있다.
	int num = 10;
	System.out.println(num);
	%>

	<%
	num = 1;
	while(num<=10){%>
	<h1><%=num %></h1>
	<%num ++;
	}
	%>

	<%
	// 구구단 2~9단까지 웹페이지에 출력
	
	int a = 2;
	int b = 2;
	int c;
	while(a<=9){%>
		<h1>[<%=a%>단]<h1>
		<%b = 2;
		while(b<=9){
		c = a*b;
		System.out.println(a + "*" + b + "=" + c);%>
	<h3><%=a%> X <%=b%> = <%=a*b%></h3>
	<%
		b++;
		}
		a++;
	}
	%>

</body>
</html>