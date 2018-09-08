<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误信息提示</title>
<link href="/css/main.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
	<div id="global">
	<sf:form method="POST" action="/clan/waradmin" modelAttribute="warmember">
		<table>
			<tr>
				部落战日期:<input id="date" name="date" class="Wdate" type="text" style="width: 188px; color: #0000AA;" onfocus="WdatePicker()">
			<sf:errors path="date" cssClass="error"/>
			</tr>
			<br>
			<tr>
				 村庄名称： <input type=text name="name">
				<sf:errors path="name" cssClass="error"/>
			</tr>
			<tr>
			<td><input type="submit" value="我要报名"/></td>
			</tr>
		</table>
	</sf:form>

	</div>
</body>
</html>