<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
	margin-top: 115px;
}

.main {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 500px;
}

.MTD p {
	font-weight: 900;
	font-size: 35px;
	margin-top: -100px;
}

.MTD span {
	font-weight: 700;
	font-size: 20px;
}

.image-left {
	width: 272px;
	height: 460px;
	padding-right: 40px;
	margin-left: -46px;
}

.image-right {
	width: 210px;
	height: 460px;
	padding-left: 40px;
}

.startBut {
	background-color: #0078d4;
	color: white;
	border: 0px;
	width: 123px;
	height: 50px;
	font-size: 22px;
	margin-top: 50px;
	border-radius: 2px;
}

.startBut:hover {
	text-decoration: none;
	background: #106ebe;
}
</style>
</head>
<body>
	<div class="total">
		<div class="checkimg">
			<img
				src="https://to-do-cdn.microsoft.com/static-assets/c87265a87f887380a04cf21925a56539b29364b51ae53e089c3ee2b2180148c6/icons/logo.png"
				class="image-logo" alt="" />
		</div>
		<div class="main">
			<img
				src="https://to-do-cdn.microsoft.com/static-assets/c26cd0d92ec61ba2c661adefaa535ab3cc4fb124f347a850fded8034dad5d360/icons/welcome-left.png"
				class="image-left" alt="" />
			<div class="MTD">
				<p>Microsoft To Do</p>
				<span>To Do을(를) 통해 직장 생활과 여가 생활<br />에 모두 집중할 수 있습니다.
				</span> <br />
				<form name="frm" action="login.do
" method="get"
					onsubmit="return check()">
					<button class="startBut">Start</button>
				</form>
			</div>
			<img
				src="https://to-do-cdn.microsoft.com/static-assets/f2f56b7d4c72910540effed9ccddae703d8d09b94075dddfeeab6cd79def0c60/icons/welcome-right.png"
				class="image-right" alt="" />
		</div>
	</div>
</body>
</html>
