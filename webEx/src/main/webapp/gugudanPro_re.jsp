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
    <title>table</title>
</head>

<body>
    <h1>성적표</h1>
    <div>
        <table border="1">
            <tr>
                <td>번호</td>
                <td>결과</td>
            </tr>
            <%
            int score = 100;
            for(int i=0; i<5; i++){
            	String name = String.format("a%d", i);
            	String dapName = String.format("d%d", i);
            	int answer = Integer.parseInt(request.getParameter(name));
            	int dap = Integer.parseInt(request.getParameter(dapName));
            %>
            <tr>
                <td><%=i+1%></td>
                <td><%=answer == dap ? "O" : "X" %></td>
            </tr>
           <%
          	score += answer == dap? 0 : -20;
            }
           %>
        </table>
        <br>
        <h1>당신의 점수는 <%=score%>점 입니다.</h1>
    </div>
</body>

</html>