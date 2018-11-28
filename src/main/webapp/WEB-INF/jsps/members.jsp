<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>捐兵排行榜</title>
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
				<th>#ID</th><th>名称</th><th>近期增援</th><th>近期收到</th><th>职位</th><th>部落战胜利之星</th>
			</thead>
			<tbody>
				<c:forEach items="${members}" var="member">
				<tr>
				<td>${member.tag}</td>
				<td>${member.name}</td>
				<td>${member.donations}</td>
				<td>${member.donationsReceived}</td>
				<td>${member.position}</td>
				<td>${member.warstar}</td>
				</tr>
				</c:forEach>				
			</tbody>
			<tfoot>
				<th></th><th>总人数 ${fn:length(members)}</th>
			</tfoot>			
		</table>
		
	</div>
	<jsp:include flush="true" page="footer.jsp" />
</body>
</html>