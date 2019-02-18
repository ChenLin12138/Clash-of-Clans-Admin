<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Products are here!</title>
</head>
<body>
<div id="global">
<h4>The products as below.</h4>
<p>
<h5>Details:</h5>

<c:forEach items="${products}" var="product">
Product Pid:${product.pid} <a href="/product/delete?id=${product.id}">Delete</a>&nbsp<a href="/product/edit?id=${product.id}">Edit</a><br/>
Name:${product.name }<br/>
Description:${product.description}<br/>
Price:$${product.price}<br/>
<input type="hidden" name="id" value=${product.id}>
<br/>
</c:forEach>

</p>
</div>
</body>
</html>