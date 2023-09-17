<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="TodoBoard.Board"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>


<!DOCTYPE html>
<html>

<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
window.addEventListener("load", test);
function test(){
	$.ajax({
		type:"get",
		url:"/TodoTeamProject/mainData",
		dataType:"json",
		success:function(data){
			output='';
			$.each(data,function(){
				output+= '<span>';
				
				output+= this.contents;
				 output += '<button onclick="updateContents(\'+ this.code + \')">수정</button><button>삭제</button><br>';
				output+= '</span>';
			});
			document.getElementById('disp').innerHTML = output;
		} 
	});
};

function updateContents(itemCode) {
    // Redirect to update.jsp with the item ID
    window.location.href = 'update?code=' + itemCode;
}

        </script>
</head>
<body>

<div id="disp"></div>


</body>
</html>