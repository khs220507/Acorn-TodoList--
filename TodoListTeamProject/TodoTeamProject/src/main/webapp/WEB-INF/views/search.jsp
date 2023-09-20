<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul {
	list-style: none;
}
</style>
</head>
<body>
	<h1>검색 결과</h1>

	<form action="searchtest" method="post">
		<input type="text" name="searchTerm" class = "searchInsert" placeholder="검색어를 입력하세요">
		<input type="submit" value="검색">
	</form>

	<c:if test="${empty searchResults}">
		
	</c:if>

	<c:if test="${not empty searchResults}">
		<ul>
			<c:forEach items="${searchResults}" var="result">
				<li>${result}</li>
			</c:forEach>
		</ul>
	</c:if>


</body>

</html>