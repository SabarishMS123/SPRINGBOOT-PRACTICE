<html>
	<head>
		<link rel="stylesheet" href="css/style.css"/>
	</head>
	<body class="body_bg">
		<h1>Register page</h1>
		
		<c:if test="$(not empty successMsg)">
			<h4>$(successMsg)</h4>
		</c:if>
		<c:if test="$(not empty errorMsg)">
					<h4>$(errorMsg)</h4>
				</c:if>
		
		<form action="regForm" method="post">
			Name:<input typt="text" name="name"/><br>
			email:<input typt="text" name="name"/><br>
			password:<input typt="password" name="password"/>
			<input type ="submit" value="register"/>
		</form>
	</body>
</html>