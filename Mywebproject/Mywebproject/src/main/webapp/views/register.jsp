<html>
	<head>
		<link rel="stylesheet" href="css/style.css"/>
	</head>
	<body class="body_bg">
		<h1>Register page</h1>
		
		<c:if test="${not empty successMsg}">
			<h4>${successMsg}</h4>
		</c:if>
		<c:if test="${not empty errorMsg}">
					<h4>${errorMsg}</h4>
		</c:if>
		
		<form action="regForm" method="post">
			Name:<input type="text" name="name"/><br>
			email:<input type="text" name="email"/><br>
			password:<input type="password" name="password"/><br>
			<input type ="submit" value="register"/><br><br>
			
			if already registered <a href="loginPage"><b>Click here</b></a>
		</form>
	</body>
</html>