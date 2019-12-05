<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.uiNum}</td>
				<td>${user.uiName}</td>
				<td>${user.uiId}</td>
				<td>${user.uiPwd}</td>
			</tr>
		</c:forEach>
	</table>
	<script>
	function getUserList(param){
		var xhr = new XMLHttpRequest();
		xhr.open('GET', '/user/list/ajax?'+param);
		xhr.setRequestHeader('Content-Type','application/json');
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					var list = JSON.parse(xhr.responseText);
					console.log(list);
				}
			}
		}
		xhr.send();
	}
	</script>
</body>
</html>