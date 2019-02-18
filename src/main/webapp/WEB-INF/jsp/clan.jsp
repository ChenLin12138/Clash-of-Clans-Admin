<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部落详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include flush="true" page="header.jsp" />
	<div class="container">
		<table class="table table-hover">
			<thead>				
				<th><a href="/clan/details">部落简介</a></th>
				<th><a href="/clan/members">捐兵排行榜</a></th>
				<th><a href="/clan/wardetails">部落对战详情</a></th>
				<th>当前部落战</th>
				<th><a href="/clan/applylist">部落战报名</a></th>
			</thead>
			<tbody>		
								
			</tbody>
				
		</table>
		
	</div>
	<jsp:include flush="true" page="footer.jsp" />
</body>
</html>