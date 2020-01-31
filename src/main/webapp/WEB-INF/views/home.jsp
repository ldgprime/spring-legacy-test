<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	${username }님  Welcome world!  
</h1>

<P>  홈에 오신것을 환영합니다. </P>
<form action="hello" method="Post">
<input type="hidden" name ="id" value="ssar">
<input type="hidden" name ="pw" value="1234">
<button type="submit">hello페이지로 이동</button> 
</form>
</body>
</html>
