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
	<table border="1">
		
	        <tr>
	          <th>점수아이디</th>
	          <th>과목</th>
	          <th>학생아이디</th>
	          <th>학생</th>
	          <th>교실</th>
	          <th>점수</th>
	        </tr>
	        
     <c:forEach items="${list }" var="bean">   
        <tr>
          <td>${bean.scoreid }</td>
          <td>${bean.subject }</td>
          <td>${bean.stuid }</td>
          <td>${bean.stuname }</td>
          <td>${bean.sclass }</td>
          <td>${bean.score }</td>
        </tr>
 	 </c:forEach> 
	</table>
	<a href="scoreindex.do">뒤로</a>
</body>
</html>