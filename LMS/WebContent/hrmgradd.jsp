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
	<h1>입력페이지</h1>
	<div>
	
		<form action="hrmgrinsert.do" method="post">
		<c:forEach items="${list }" var="bean" begin="6" end="6">
				<p>ID:<input type="text" name="hrid" value="${bean.hrid }" readonly="readonly"/></p>
		</c:forEach>
			<p>NAME:<input type="text" name="hrname"/></p>	 
			  
    Team:<select name="hrteam">
    	  <option>선택하세요</option>
    	  <c:forEach items="${list }" var="bean" begin="0" end="5">   	  		
          		<option value="${bean.team}">${bean.team}</option>
          </c:forEach>
        </select>
                        
		<input type="submit" value="입력" >
		<input type="submit" value="취소">	
		</form>
	</div>
</body>
</html>