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
	<h1>반 나누는 페이지</h1>
	<form action="score.do" method="get">
			<div>
				<select name="idx">				
					<c:forEach items="${list }" var="bean">   	  		
          				<option value="${bean.sclass}">${bean.sclass}</option>
          			</c:forEach>			
				</select>
			</div>
			<input type="hidden" value="addview2" name="root">
			<button>검색</button>
	</form>
</body>
</html>