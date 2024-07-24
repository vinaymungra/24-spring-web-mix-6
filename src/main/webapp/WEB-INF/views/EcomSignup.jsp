<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="esignup" method="post" enctype="multipart/form-data">
		FirstName:<input type="text" name="firstName"/><br>${firstNameError}<br>
		Email:<input type="text" name="email"/><br><span>${emailTypeError}</span><br>
		
		Password:<input type="password" name="password"/><br><span>${passwordTypeError}</span><br>
		ProfilePic:<input type="file" name="profilePic"/><br><br>
		<input type="submit" value="Signup"/>
	</form>
</body>
</html>