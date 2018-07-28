<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search a Product</title>
<link href="/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="global">
<sf:form method="POST" action="/product/search" modelAttribute="product">
		<h3>Search a product</h3>
		<table>
			<tr>
				<td>Product name:</td>
				<td><sf:input path="name"/></td> 
				<td><sf:errors path="name" cssClass="error"/><td>
			</tr>
			<tr>
				
				<td><input type="submit" value="Search Prodct"/></td>
			</tr>
		</table>
</sf:form>
</div>
</body>
</html>