<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="TodoBoard.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

ul {
	background: #faf9f8;
	box-shadow: 1px 1px 1px 1px #edeceb;
	border-radius: 5px;
}

li {
	list-style: none;
	line-height: 30px;
	padding-left: 20px;
}

button {
	width: 50px;
	height: 30px;
	color: #2564cf;
	background-color: white;
	border: 1px solid #e1dfdd;
	transition: all 0.2s;
}

button:hover {
	background: #faf9f8;
}

hr {
	background: #e1dfdd;
	height: 1px;
	border: 0;
	margin-top: 15px;
	margin-bottom: 15px;
}

header {
	width: 100%;
	height: 48px;
	background-color: #2564cf;
	/*border: 1px solid black;*/
	position: relative;
	display: flex;
}

header img {
	width: 15px;
	height: 15px;
	margin-left: 10px;
	margin-top: 14px;
}

header .title {
	color: white;
	font-size: 16px;
	font-weight: bold;
	margin-left: 40px;
	position: relative;
	top: 12px;
	​
}

.logOutIcon {
	width: 35px;
	height: 35px;
	position: absolute;
	right: 10px;
	top: -8px;
	filter: invert(100%) sepia(0%) saturate(7499%) hue-rotate(169deg)
		brightness(125%) contrast(98%);
}

.todayToDoTitle {
	font-size: 20px;
	color: #292827;
	font-weight: bold;
	text-align: center;
	margin-bottom: 15px;
	font-size: 50px;
	margin-top: 85px;
}

section {
	width: 100%;
	height: 900px;
	background-color: #faf9f8;
	/*border: 1px solid black;*/
	padding-top: 20px;
}

.toDo {
	width: 100%;
	height: 100px;
	border: 1px solid #edeceb;
	background-color: white;
	box-shadow: 1px 1px 1px #edeceb;
	border-radius: 5px;
	padding-left: 30px;
	margin-top: 30px;
	padding-top: 40px;
	box-sizing: border-box;
}

}
.wrapText {
	
	margin: 0px auto;
	
	height : 100px
	width: 90%;
	
}

.submitBtn {
	width: 50px;
	height: 30px;
	color: #2564cf;
	background-color: white;
	border: 1px solid #e1dfdd;
	transition: all 0.2s;
	position: absolute;
}

.submitBtn:hover {
	background: #faf9f8;
}

.wrapButton {
	position: absolute;
    right: 52px;
    bottom: 31px;
}

.wrapUpdateFrm {
	position: relative;
}

#updateFrm {
	text-align: center;
	margin: 0 auto;
	justify-content: center;
}

.toDo text {
	margin-left: 10px;
}

.wrap_test{

height : 150px;
width : 547.19px;
position : relative;
margin: 0px auto;
}
</style>
<script>
	
</script>
</head>
<body>
	<header>
		<img
			src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDABQODxIPDRQSEBIXFRQYHjIhHhwcHj0sLiQySUBMS0dARkVQWnNiUFVtVkVGZIhlbXd7gYKBTmCNl4x9lnN+gXz/2wBDARUXFx4aHjshITt8U0ZTfHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHz/wAARCABUAFUDASIAAhEBAxEB/8QAGwABAAMBAQEBAAAAAAAAAAAAAAQFBgMCAQf/xAArEAACAgEDAgUEAgMAAAAAAAABAgADBAUREgYxEyFBUZEyYXGhIoEUQrH/xAAZAQACAwEAAAAAAAAAAAAAAAADBAABAgX/xAAfEQADAQEBAQADAQEAAAAAAAAAAQIRAxIxBCFhEzL/2gAMAwEAAhEDEQA/AISqzsFUEsTsAPWWqdPZroGJqQn/AFZjv+hPHTyo2prz23Ckr+Zro927VDxC3PmqWsweTjW4tprvQqw/c5TSdUKngUN5c+RA/G0zcPzv3Og7ny8OuNjW5VoroQsx/UsX6ezUQsDU5H+qsd/2JO6XVPAvby58gD+Npexbr3qaxBY5prWfn7KyMVYEMDsQfSfJZ9Qqi6m3DbcqC35lZGpr1KYFrHhLwtNyM4nwVAUd2Y7CdsvRMvFqNjBLFHfgd9po9HVF0zH4bbFdzt7+smEAgg9vWKV+RSr+B1yTR+fxOmQFXItCfSHIH43iOi58qtem1bK24up3Bl2nUzhALMZWf1IfYfG0oYmK5zf/AEjSpz8JOdnW513iXEeXkqjsBI0RNpJLEZb0k4Odbg3eJSR5+TKexEtX6mcoRXjKr+hL7j42lDExXOKetGldL9I922vda1ljcnY7kzxETZksdN1e7AU18RZV34k7bfgyRl9Q3X1GumoU8vIty3P9SmiDfKG9aNe6SzRERCGTrjY75V6U1DdmPxNCnTWOEHiXWl/UrsB/yVegWpVqa8ztyUqD95r4p36VNYg/KE1rMXqenPp9oUtzRvpbaQpouqLU8Omrf+fLlt7CZ2H5U6hNg7SVYibpmnPqFpUNwRfqbaXL9NY5Q+HdaH9C2xH/ACc+l7U8O6rf+fLlt7iX8V7dbV4g3OJc6zB5OO+Le9No2ZT8zlLLX7Ut1N+B34qFJ+8rY5DblNi9LHhb6Vopza/GvcpUewXuZKzOnEWkti2OXA34vsd/iWWjWpbplPA/QvEj2Ikx3VELuQFUbkmI12tWMzznyYAjY7GJ0vcWX2OvZmJHzE6Aqc5OTWM+tAi5DbD3AJ+SJBiU5T+otNr4erLHtcvYxdj3JO88xEso9V2PU4etijDsQdpMfWM+xCjZDbH2AB+QJBiU5T+otNr4IiJZR2xsu/Ectj2MhPfbsf6nTJ1LLyk4X3sy+wAA/UixK8rdwvX8EREsolabif5uYlJOy92P2msTTMKtAgxqiB6soJ+TMtpGWuHnJY/0EcWPsDNiliWIHrdWQ+YIPlEvyXSr+DHJLDMa7pteG6W0Datztx9jKiXfUWdVeUopYOEO7MO2/tKSM8vThegV56/Rb6FpteY723jetDtx9zL99MwrEKHGqAPqqgH5EpOnc6qgvRcwQOd1Y9t/aaN7ErQvY6qg8ySfKKd3asPzU+TF6lif4WY9IO691P2kWTdXy1zM57E+gDip9wJCjsb5W/Ras39Gl0XSaDjLkZCCx381DeYA/EmZmkYmRSVSlKn2/iyLt5/1OOhZ9V2JXQWC21jjxJ7j3EnZmZTh0my1wPLyX1J+0Qur/wBP6NSp8mIdSjsjd1OxiLXNlrue7MSf7idEUPMREhBERIQRESEEREhBERIQRESEP//Z">
		<p class="title">To Do</p>


		<a href="/TodoTeamProject/logout"><img class="logOutIcon"
			src="https://img.icons8.com/material/24/000000/exit.png" alt="exit" /></a>
	</header>
	<section>
		<div class="todayToDoTitle">할 일 수정</div>

		<%-- <form id="updateFrm" action="/TodoTeamProject/update" method="get">
		<input type="text"  value="${board.code}"> 
		<textarea id="contents" name="newContents" rows="4" cols="50">${board.contents}</textarea>
		<br> <input type="button" value="수정" onclick="updateContents()">
	</form>  --%>

		<form id="updateFrm" action="/TodoTeamProject/update" method="post">
			<!-- 			<div class="wrapUpdateFrm"> -->
			<!-- Hidden field for the task code -->
			<div class="wrap_test">
				<input type="hidden" name="code" value="${board.code}"> <label
					for="contents"></label><br>
				<!-- 				<div class="wrapText"> -->
				<textarea class="toDo" name="newContents" rows="4" cols="50">${board.contents}</textarea>

				<br>
				<div class="wrapButton">
					<input class="submitBtn" type="submit" value="수정">
				</div>
			</div>
			</div>
			</div>


		</form>

	</section>

</body>
</html>