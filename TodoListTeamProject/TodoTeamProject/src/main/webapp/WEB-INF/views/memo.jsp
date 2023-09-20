<%@page import="TodoMemo.BoardMemo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

table,h2{
width:300px;
heigt:20px;
border-collapse: collapse;
margin:0 auto;
text-align:center;
}

td{
border:1px solid black;
}

input{
width:293px;
heigt:20px;
}

.button{
margin:0 auto;
border: 0px;
}

div{
margin-left:610px;
margin-top:30px;
}
</style>

</head>



<body>
<h2>to do Memo</h2>
<% ArrayList<BoardMemo> list=(ArrayList<BoardMemo>)request.getAttribute("list");%>

<table>
	
	
<% for(BoardMemo m: list) {%>

	<tr>
		<td><%=m.getM_code() %></td>
		<td><%=m.getM_contents() %></td>
		<td>
		
		<form action ="<%=request.getContextPath()%>/MemoModifyServlet" method="get">
			<button>수정</button>
		</form>
		<form action ="<%=request.getContextPath()%>/MemoDeleteServlet" method="get">	
			<button>삭제</button>
		</form>
		</td>
	</tr>


<%} %>

</table>

 		
	
	<div class="Reg">
 			<form action ="<%=request.getContextPath()%>/register" method="get">
			<input type="text"  name="contents"></input><button>등록</button>    
			</form>     
        </div>



</body>
</html>