<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>성적 입력</h1>
		<form action="" method="get">
			
			<div>
				<label >학생이름</label>
				<input type="text" value="" >
			</div>
			
			<div>
				<select>
					<option value="web">web</option>
					<option value="java">java</option>
					<option value="db">db</option>
				</select>
			</div>
			<div>
				<button type="submit">전송</button>
				<button type="reset">취소</button>
			</div>
		</form>
</body>
</html>