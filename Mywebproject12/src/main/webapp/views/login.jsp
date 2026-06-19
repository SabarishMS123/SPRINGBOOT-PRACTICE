<html>
	<head>
		<link rel="stylesheet" href="css/style.css"/>
	</head>
	<body class="body_bg">
		<h1>Profile page</h1>
		
		
		<c:if test="${not empty errorMsg}">
					<h4>${errorMsg}</h4>
		</c:if>
		
		<form action="loginForm" method="post">
			
			email:<input type="text" name="email"/><br>
			password:<input type="password" name="password"/><br>
			<input type ="submit" value="Login"/><br><br>
			
			if not registered <a href="register"><b>Click here</b></a>
		</form>
	</body>
</html>