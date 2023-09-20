<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정하기</title>
</head>
<body>
<%	
String id =(String) request.getAttribute("id"); 
String pw =(String) request.getAttribute("pw"); 
String name =(String) request.getAttribute("name"); 
String birth =(String) request.getAttribute("birth"); 
String tel =(String) request.getAttribute("tel"); 
%> 

	<form  action="modi.do" method="post">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" name="id" value="id" disabled></td>
            </tr>
            
            <tr>
                <td>비밀번호</td>
                <td><input type="text" name="pw" value="pw"></td>
            </tr>
            
            <tr>
                <td>이름</td>
                <td><input type="text" name="name" value="name" disabled></td>
            </tr>
            
            <tr>
                <td>생년월일</td>
                <td><input type="text" name="birth" value="birth" disabled></td>
            </tr>
            
            <tr>
                <td>전화번호</td>
                <td><input type="text" name="tel" value="tel"></td>
            </tr>
            
            <tr>
                <td></td>
                <td><input type="submit" value="수정하기"></td>
            </tr>
 
            <tr>
            <td></td>
            <td ><input type="reset" value="다시입력"></td>
            </tr>
        </table>
    
    </form>


</body>
</html>