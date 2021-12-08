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
<%
Random rn = new Random();

int data[][] = new int [5][3];

for(int i=0; i<data.length; i++){
	boolean overlapCheck = false;
	
	int a = rn.nextInt(7)+2; // 2~9
	int b = rn.nextInt(7)+2; // 2~9
	for(int j=0; j<i; j++){
		if(a == data[j][0] && b == data[j][1]){
			overlapCheck = true;
		}else if(a == data[j][1] && b == data[j][0]){
			overlapCheck = true;			
		}
	}
	
	if(overlapCheck){
		i --;
	} else{
		data[i][0] = a;
		data[i][1] = b;
		data[i][2] = a*b;	
		System.out.println(data[i][0] + ", "  + data[i][1] + ", " + data[i][2]);
	}
}

%>
    <h1>구구단 문제</h1>
    <form method="post" action="gugudanPro.jsp">
        <table border="1">
            <tr class="title">
                <td>번호</td>
                <td>문제</td>
                <td>정답</td>
            </tr>
            <tr>
            	<td>1</td>
            	<td><%=data[0][0]%> X <%=data[0][1]%> =</td>
            	<td><input type="text" name="answer1" required></td>
            </tr>
            
            <tr>
                <td>2</td>
                <td><%=data[1][0]%> X <%=data[1][1]%> =</td>
                <td><input type="text" name="answer2" required></td>
            </tr>
            <tr>
                <td>3</td>
                <td><%=data[2][0]%> X <%=data[2][1]%> =</td>
                <td><input type="text" name="answer3" required></td>
            </tr>
            <tr>
                <td>4</td>
                <td><%=data[3][0]%> X <%=data[3][1]%> =</td>
                <td><input type="text" name="answer4" required></td>
            </tr>
            <tr>
                <td>5</td>
                <td><%=data[4][0]%> X <%=data[4][1]%> =</td>
                <td><input type="text" name="answer5" required></td>
            </tr>
        </table>
        <br>
        <button type="submit">전송</button>
          <input type="hidden" name ="hidden1" value="<%=data[0][2]%>">
          <input type="hidden" name ="hidden2" value="<%=data[1][2]%>">
          <input type="hidden" name ="hidden3" value="<%=data[2][2]%>">
          <input type="hidden" name ="hidden4" value="<%=data[3][2]%>">
          <input type="hidden" name ="hidden5" value="<%=data[4][2]%>">
    </form>
</body>

</html>