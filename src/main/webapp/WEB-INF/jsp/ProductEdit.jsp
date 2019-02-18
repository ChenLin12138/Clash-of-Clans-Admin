<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="global">
		<h3>Amend a product</h3>
		<form method="post" action="/product/edit">
			<table>
			<tr>
				<td>Product name:</td>
				<td><input type="text" name="name" value=${product.name }></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description" value=${product.description}></td>
			</tr>
			<tr>
				<td>Price $</td>
				<td><input type="text" name="price" value=${product.price}></td>
			</tr>
			
			<tr>
				<td>Pid</td>
				<td><input type="text" name="pid" value=${product.pid}></td>
			</tr>
			<tr>
				<td><input type="reset"/></td>
				<td><input type="submit" value="Update Prodct"/></td>
			</tr>
			
			<input type="hidden" name="id" value=${product.id}></td>
			
			</table>
	</form>
	</div>
</body>
</html>