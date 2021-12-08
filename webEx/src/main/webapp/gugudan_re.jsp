<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .title {
            text-align: center;
        }

        h1 {
            margin-top: 30px;
        }
    </style>
    <title>구구단 문제</title>
</head>

<body>
    <h1>구구단</h1>
    <form method="GET" action="gugudanPro.jsp">
        <table border="1">
            <tr class="title">
                <td>문제</td>
                <td>정답</td>
            </tr>
            <%
            Random rn = new Random();
            for(int i=0; i<5; i++){
            	int x = rn.nextInt(8)+2;
            	int y = rn.nextInt(9)+1;
            	String name = String.format("a%d", i);
            	String dapName = String.format("d%d", i);
            	%>
            <tr>
            	<td><%=x%> X <%=y%> =</td>
            	<td>
            		<input type="text" name="<%=name%>" required>
            		<input type="hidden" name="<%=dapName%>" required>
            	</td>
            </tr>
           <%
            }
            %>
        </table>
        <br>
        <button type="submit">전송</button>
    </form>
</body>

</html>