<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<style>
.total {
	position: relative;
	width: 100%;
	border-top: 6px solid #0078d4;
	margin-top: -8px;
	/* border: 1px solid black; */
	font-family: "돋움", Dotum, "맑은 고딕", "Malgun Gothic", "Apple Gothic",
		sans-serif;
	justify-content: center;
	align-items: center;
	text-align: center;
}

.image-logo {
	width: 97px;
	height: 79px;
	margin-top: 45px;
	margin-bottom: 30px;
}

.wrap {
	border: solid 2px var(--GRAY125S, #e5e5e5);
	width: 580px;
	justify-content: space-between;
	margin: 0 auto;
}

.body {
	width: 600px;
	/* border: solid 2px var(--GRAY125S, #e5e5e5); */
	/* border: 1px solid black; */
	border-radius: 2px;
	margin: 0 auto;
	font-family: "Apple SD Gothic Neo", "Noto Sans KR", "맑은 고딕",
		"Malgun Gothic", 돋움, Dotum, sans-serif;
}

#login-form {
	display: flex;
	flex-direction: column;
	margin: 70px 68px;
}

#login-form input {
	padding: 10px px 0px;
	border: 0 solid black;
	font-size: 18px;
	border-bottom: 1px solid rgba(0, 0, 0, 1);
	margin-bottom: 46px;
	transition: border-color 0.3s ease-in-out;
}

#login-form input:not([type="submit"]) {
	border-bottom: 1px solid rgba(0, 0, 0, 1);
	transition: border-color 0.3s ease-in-out;
}

#login-form input::placeholder {
	color: rgba(0, 0, 0, 1);
	border: none;
}

.btnmenu {
	width: 585px;
	height: 450px;
	margin: 0 auto;
}

.btnmenu a {
	text-decoration: none;
	color: black;
	font-size: 18px;
}

.btn1 {
	width: 440px;
	height: 60px;
	background-color: #0078d4;
	margin-bottom: 10px;
	border: none;
	border-radius: 7px;
	margin-top: 51px;
}

.btn2 {
	width: 440px;
	height: 60px;
	background-color: #f0f0f0;
	border-radius: 7px;
	border: none;
	margin-top: 22px;
}

.checkboxwrap {
	/* border: 1px solid black; */
	float: left;
	margin-left: 70px;
	margin-top: -233px;
	cursor: pointer;
}

.hr-sect {
	display: flex;
	flex-basis: 100%;
	align-items: center;
	color: rgba(0, 0, 0, 0.2);
	font-size: 12px;
	margin: 13px 65px;
	margin-top: -95px;
	margin-bottom: -3px;
}

.hr-sect::before, .hr-sect::after {
	content: "";
	flex-grow: 1;
	background: rgba(0, 0, 0, 0.2);
	height: 1px;
	font-size: 0px;
	line-height: 0px;
	margin: 0px 16px;
}
</style>
</head>
<body>
	<div class="total">
		<div class="img_header">
			<img
				src="https://to-do-cdn.microsoft.com/static-assets/c87265a87f887380a04cf21925a56539b29364b51ae53e089c3ee2b2180148c6/icons/logo.png"
				class="image-logo" alt="" />
		</div>

		<div class="wrap">
			<div class="body">


				<div class="btnmenu">
					<%
					if (session.getAttribute("userId") == null) {
					%>
					<form action="login" method="post" id="login-form">
						<input type="text" name="id" placeholder="아이디, 이메일" /> <input
							type="password" name="pw" placeholder="비밀번호" /> <input
							type="submit" class="btn1" value="로그인">
					</form>
					<div class="checkboxwrap">
						<input type="checkbox" id="checkbox" /> <label for="checkbox">로그인
							상태 유지</label>
					</div>
					<div class="hr-sect">또는</div>
					<%
					}
					%>  
					<form action="reg.do" method="get">
						<input type="submit" class="btn2" value="회원가입">
					</form>
				</div>
			</div>
		</div>
	</div>

	<%
	// LoginServlet에서 전달한 메시지를 확인하고 출력
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<script>
    alert('<%=message%>');
	</script>
	<%
	}
	%>
</body>
</html>
