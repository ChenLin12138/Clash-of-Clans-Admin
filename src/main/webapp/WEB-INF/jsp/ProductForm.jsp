<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product Form</title>
<link href="/css/main.css" rel="stylesheet" type="text/css"/>
</head>

<body>
	<div id="global">
	<sf:form method="POST" action="/product/add" modelAttribute="product">
		<table>
			<tr>
				<td>Product id:</td>
				<td><sf:input path="pid"/></td> 
				<td><sf:errors path="pid" cssClass="error"/><td>
			</tr>
			<tr>
				<td>Product name:</td>
				<td><sf:input path="name"/></td> 
				<td><sf:errors path="name" cssClass="error"/><td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><sf:input path="description"/></td> 
				<td><sf:errors path="description" cssClass="error"/><td>
			</tr>
			<tr>
				<td>Price</td>
				<td><sf:input path="price"/></td> 
				<td><sf:errors path="price" cssClass="error"/><td>			</tr>
			<tr>
				<td><input type="reset"/></td>
				<td><input type="submit" value="Add Prodct"/></td>
			</tr>
		</table>
	</sf:form>

	</div>
</body>
</html>