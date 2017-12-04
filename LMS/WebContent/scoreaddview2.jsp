<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
  read
}
</style>
</head>
<body>
	<h1>view2</h1>
	<form action="sadd.do" method="post">
	<table border="1">
	<tr>	 
			<th>학생아이디</th>
	          <th>학생이름</th>
	         
	          <th>교실</th>
	          <th>출석유무</th>
	</tr>
	<c:forEach items="${list }" var="bean">
	
	<tr>	  		
		<td><input readonly="readonly" id="${bean.stuid }" value="${bean.stuid }" ></td>
          <td><input readonly="readonly" id="${bean.stuname }" value="${bean.stuname }" ></td>
          
           <td><input readonly="readonly" id="${bean.sclass }" value="${bean.sclass }" ></td>
          <td><select name="${bean.stuid }">
          <option value="출석" id="출석">출석</option>
          <option value="지각" id="지각">지각</option>
          <option value="조퇴" id="조퇴">조퇴</option>
          <option value="결석" id="결석">결석</option>
          </select>
          </td>
     </tr>
     </c:forEach>	
     </table>
     <c:forEach items="${list }" var="bean1" begin="0" end="1">
     <input type="hidden" value="${bean1.sclass }" name="sclass">
     </c:forEach>
     <input type="hidden" value="add" name="root">
     <button>저장</button>
     </form>
</body>
</html>