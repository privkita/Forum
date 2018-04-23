<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forum</title>
</head>
<body>
	<h1>Temat: ${subject.title}</h1>
	<table border="1">
		<tr>
			<th>Login</th>
			<th width="500">Treść</th>
			<th>Data</th>
		</tr>
		<tr>
			<td>${subject.user_id.login}</td>
			<td>${subject.content}</td>
			<td>${subject.date}</td>
		</tr>
		<c:forEach var="post" items="${subject.posts}">
			<tr>
				<td>${post.user_id.login}</td>
				<td>${post.content}</td>
				<td>${post.date}</td>
			</tr>
		</c:forEach>
	</table>
	<form method="post">
		<input type="hidden" name="subject_id" value="${subject.subject_id}" />
		<p>Napisz odpowiedz:</p>
		<textarea name="content" rows="8" cols="40"></textarea><br />
		<input type="submit" value="OK" />
	</form>
</body>
</html>