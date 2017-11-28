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
	<h1>출결페이지</h1>
	<table border="1">
		
	        <tr>
	          <th>출석이름</th>
	          <th>출석날짜</th>
	          <th>학생아이디</th>
	          <th>학생이름</th>
	          <th>교실</th>
	          <th>출석유무</th>
	        </tr>
	        
     <c:forEach items="${rlist }" var="rbean">   
        <tr>
          <td>${rbean.rollid }</td>
          <td>${rbean.calldate }</td>
          <td>${rbean.stuid }</td>
          <td>${rbean.stuname }</td>
          <td>${rbean.sclass }</td>
          <td>${rbean.status }</td>
        </tr>
 	 </c:forEach> 
	</table>
</body>
</html>