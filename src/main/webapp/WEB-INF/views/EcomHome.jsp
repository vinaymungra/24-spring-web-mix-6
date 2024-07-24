<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>EcomHome</h2>

Welcome,${user.firstName}<Br>

<img alt="" src="${user.profilePicPath}" height="100px" width="100px"/>
<Br>
<a href="/userproducts"> Products</a>
</body>
</html>