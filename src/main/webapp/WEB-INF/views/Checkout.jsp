<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Pay</h2>

	Final Amount : XXXX
	<br> CreditCard :
	<input type="text" name="creditCardNum" />
	<br>
	<br> ExpiredDate :
	<input type="text" name="expiredDate" />
	<br>
	<Br> Cvv:
	<input type="text" name="cvv" />
	<br>
	<Br>
	<input type="submit" value="Pay" />
//parameters easily visible
//Model Scope? and It requires DB query for product price time complexity
//HttpSession It requires DB query for product price time complexity
</body>
</html>