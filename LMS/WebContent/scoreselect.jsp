<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
window.onload = function() {
    document.getElementById('btn').onclick = function() {
        var request = new XMLHttpRequest();//생성
        //펄스-동기/  트루 - 비동기
    
//펄스일겅우 요청을 보낸 후 받은다음 다음구문이 진행되는데
//트루일경우 보낸다음 기다리지 않고 진행함
//데이터가 배달된 것을 onreadystatechange로 알 슈 있ㄱ다
        
        request.onreadystatechange = function() {//비동기일경우 
//데이터가 오는 순간 쓰임. 쓰레드 헨들러처럼
        // console.log(request.readyState);
        
//데이터를 다받은뒤에 출력(리퀘스트4가 모든데이터를 다받은것)
        if(request.readyState == 4){
// HTTL 에서 제대로된 데이터를 받은게 200이다
            if(request.status ==200){
                var result = document.getElementById('result');
                result.innerHTML =request.responseText;
            }else{console.log('비정상 처리입니다');}   
        }else{console.log('진행중');}
    };
        request.open('get','scoreedit.do',true);//요청의 형식
        request.send();//요청
// 동기로 불러오는함수 
        var result = document.getElementById('result');
        result.innerHTML =request.responseText;//내용 뿌려주기
    };
};
//document.getElementById('btn').onclick= function(){
///	var request = new XMLHttpRequest();
//	request.open('get','./data/data.json',false);
//	request.send();
//	var result = document.getElementById("result");
//	result.innerHTML = request.responseText;
//};
</script>
</head>
<body>
	<button id="btn">요청</button>
	<div id="result"></div>
	<form action="scoreselectadd.do" method="get">
			<div>
				<select>				
					<c:forEach items="${list }" var="bean">   	  		
          				<option value="${bean.sclass}">${bean.sclass}</option>
          			</c:forEach>			
				</select>
			</div>
	</form>
</body>
</html>