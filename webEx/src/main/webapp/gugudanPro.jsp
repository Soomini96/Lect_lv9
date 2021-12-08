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
<%
request.setCharacterEncoding("UTF-8");
 
 String answer1 = request.getParameter("answer1");
 String answer2 = request.getParameter("answer2");
 String answer3 = request.getParameter("answer3");
 String answer4 = request.getParameter("answer4");
 String answer5 = request.getParameter("answer5");
 
 String target1 = request.getParameter("hidden1");
 String target2 = request.getParameter("hidden2");
 String target3 = request.getParameter("hidden3");
 String target4 = request.getParameter("hidden4");
 String target5 = request.getParameter("hidden5");
 
 String score[] = new String[5];
 int totalScore = 0;
 
 for(int i=0; i<5; i++){
	 score[i] = "X";
 }
 if(answer1.equals(target1)){
	score[0] = "O";
	totalScore += 20;
 }
 if(answer2.equals(target2)){
	score[1] = "O";
	totalScore += 20;
 }
 if(answer3.equals(target3)){
	score[2] = "O";
	totalScore += 20;
 }
 if(answer4.equals(target4)){
	score[3] = "O";
	totalScore += 20;
 }
 if(answer5.equals(target5)){
	score[4] = "O";
	totalScore += 20;
 }
 %>
    <h1>채점</h1>
    <form class="title">
        <table border="0" width="300">
            <tr>
                <td>번호</td>
                <td>정답</td>
                <td>사용자값</td>
                <td>정오표</td>
            </tr>
            <tr>
                <td>1</td>
                <td><%=target1%></td>
                <td><%=answer1%></td>
                <td><%=score[0]%></td>
            </tr>
            <tr>
                <td>2</td>
                <td><%=target2%></td>
                <td><%=answer2%></td>
                <td><%=score[1]%></td>
            </tr>
            <tr>
                <td>3</td>
                <td><%=target3%></td>
                <td><%=answer3%></td>
                <td><%=score[2]%></td>
            </tr>
            <tr>
                <td>4</td>
                <td><%=target4%></td>
                <td><%=answer4%></td>
                <td><%=score[3]%></td>
            </tr>
            <tr>
                <td>5</td>
                <td><%=target5%></td>
                <td><%=answer5%></td>
                <td><%=score[4]%></td>
            </tr>
        </table>
        <br>
    </form>
        <p><h1>당신의 점수는 <%=totalScore%>점 입니다.</h1></p>
</body>

</html>