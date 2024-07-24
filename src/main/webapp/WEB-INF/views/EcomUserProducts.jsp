<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.EProductBean" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Products</title>
<style type="text/css">
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 80%;
        margin: 0 auto;
        padding: 20px;
    }
    h2 {
        text-align: center;
        color: #333;
    }
    .card {
    	padding-top:30px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        width: 300px;
        height: 400px;
        margin: 15px;
        background-color: white;
        border-radius: 10px;
        overflow: hidden;
        text-align: center;
        transition: transform 0.2s;
        position: relative;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
    }
    .card-image {
        width: 100%;
        height: 200px;
        background-size: contain;
        background-repeat: no-repeat;
        background-position: center;
    }
    .card-content {
        padding: 15px;
    }
    .card h2 {
        font-size: 24px;
        margin: 15px 0;
    }
    .price {
        color: grey;
        font-size: 22px;
        margin: 15px 0;
    }
    .card p {
        margin: 10px 0;
        padding: 0 15px;
        font-size: 14px;
        color: #555;
    }
    .card button {
        border: none;
        outline: 0;
        padding: 12px;
        color: white;
        background-color: #000;
        text-align: center;
        cursor: pointer;
        width: 100%;
        font-size: 18px;
        transition: background-color 0.3s, opacity 0.3s;
    }
    .card button:hover {
        background-color: #333;
        opacity: 0.9;
    }
    .card:hover {
        transform: scale(1.05);
    }
    .parent1 {
        display: flex;
        justify-content: center;
    }
    .parent2 {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        gap: 10px;
    }
    a {
        display: inline-block;
        margin: 15px 0;
        color: #007BFF;
        text-decoration: none;
        font-size: 18px;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>All Products</h2>
        <a href="/ehome">Home</a>
        <div class="parent2">
            <% 
                List<EProductBean> products = (List<EProductBean>) request.getAttribute("products"); 
                for(EProductBean p : products) {
                	out.print("");
                    out.print("<div class='parent1'>");
                    out.print("<div class='card'>");
                    out.print("<div class='card-image' style='background-image: url(" + p.getProductPicPath() + ");'></div>");
                    out.print("<div class='card-content'>");
                    out.print("<h2>" + p.getProductName() + "</h2>");
                    out.print("<p class='price'>Rs. " + p.getPrice() + "</p>");
                    out.print("<p>Some text about the product..</p>");
                    out.print("<p><button>Add to Cart</button></p>");
                    out.print("</div>");
                    out.print("</div>");
                    out.print("</div>");
                }
            %>
        </div>
    </div>
</body>
</html>
