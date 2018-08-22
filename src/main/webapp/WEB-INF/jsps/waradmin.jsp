<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部落战报名</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<jsp:include flush="true" page="header.jsp" />
	<div class="container">
	<sf:form method="post" action="/clan/waradmin">
	<table class="table table-hover">
	<tr>
        部落战日期:<input id="date" name="date" class="Wdate" type="text" style="width: 188px; color: #0000AA;" onfocus="WdatePicker()"><br>
	  
	    村庄名称： <input type=text name="name"><br>
		 <input type="submit" value="我要报名"/><br>
		</tr>
		<br>
		<br>
		<br>
		<tr>
		已报名单：<br>
		</tr>

			<thead>		
		    	<th>ID</th>		
				<th>村庄名称</th>
				<th>报名日期</th>
			</thead>
			<tbody>		
			<c:forEach items="${warmember}" var="member">
			<td>${member.id}</td>
			<td>${member.name}</td>
			<td>${member.date}</td>
			</tr>	
			</c:forEach>					
			</tbody>				
		</table>
		</sf:form>
	</div>
	<jsp:include flush="true" page="footer.jsp" />
</body>
</html>