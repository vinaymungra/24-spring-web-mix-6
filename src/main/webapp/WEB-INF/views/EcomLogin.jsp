<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="elogin" method="post">
		Email: <input type="text" name="email"/><br/>
		Password: <input type="password" name="password"/><br/>
		<input type="submit" value="Login"/>
		<span >${error}</span>
		
	</form>
</body>
</html>