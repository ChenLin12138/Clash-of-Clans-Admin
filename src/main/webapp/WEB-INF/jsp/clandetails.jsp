<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部落简介</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include flush="true" page="header.jsp" />
	<div class="container">
		<P>
				
				部落ID:${clandetails.tag}<br/>
				部落名称:${clandetails.name}<br/>
				部落等级:${clandetails.clanLevel}<br/>
		        所需奖杯:${clandetails.requiredTrophies}<br/>
				部落介绍:${clandetails.description}<br/>
								
			</P>					
		
	</div>
	<jsp:include flush="true" page="footer.jsp" />
</body>
</html>