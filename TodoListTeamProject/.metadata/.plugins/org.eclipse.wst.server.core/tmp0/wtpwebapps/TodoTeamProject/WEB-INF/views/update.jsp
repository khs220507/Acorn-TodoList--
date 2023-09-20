<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="TodoBoard.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>

</script>
</head>
<body>
	<h2>할 일 수정</h2>

	<%-- <form id="updateFrm" action="/TodoTeamProject/update" method="get">
		<input type="text"  value="${board.code}"> 
		<textarea id="contents" name="newContents" rows="4" cols="50">${board.contents}</textarea>
		<br> <input type="button" value="수정" onclick="updateContents()">
	</form>  --%>
	
	
	<form id="updateFrm" action="/TodoTeamProject/update" method="post">
        
       
        <!-- Hidden field for the task code -->
        <input type="hidden" name="code" value="${board.code}">
        
        <label for="contents">할 일:</label><br>
        <textarea id="contents" name="newContents" rows="4" cols="50">${board.contents}</textarea>
        <br>
        <input type="submit" value="Update">
        
        
    </form> 


</body>
</html>