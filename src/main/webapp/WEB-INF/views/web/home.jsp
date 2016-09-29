<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script type="text/javascript">

/**
 * blank 검사
 */
function hasNotBlank(formId){
	var hasNotBlank = true;
	$("#" + formId + " input[required]").each(function(idx){
		if($(this).val() == ""){
			alert("필수항목이 입력되지 않았습니다.");
			$(this).focus();			
			hasNotBlank = false;
			return false;
		}else{
			hasNotBlank = true;
		}
	});	
	return hasNotBlank;
}

function signup(){
	window.location.href = "${pageContext.request.contextPath}/user/signup";
}


function login(){
	
	if(!hasNotBlank("frm")) return false;
	
	$("#frm").ajaxSubmit({
		url: "${pageContext.request.contextPath}/user/login"
		//, data: $("#frm").serialize()
		, dataType: "json"
		, success: function(response){
			if(response.header.status == 0000){
				alert("로그인 성공");
				location.reload();
			}
			else{
				alert("잘못된 로그인 정보입니다.");
			}
		}
		, error: function(xhr, status, error){
			alert(error + " 오류가 발생했습니다!");
		}
	});
}


function logout(){
	
	$.ajax({
		url: "${pageContext.request.contextPath}/user/logout"
		//, data: $("#frm").serialize()
		, dataType: "json"
		, success: function(response){
			if(response.header.status == 0000){
				alert("로그아웃");
				location.reload();
			}
			else{
				alert("잘못된 로그인 정보입니다.");
			}
		}
		, error: function(xhr, status, error){
			alert(error + " 오류가 발생했습니다!");
		}
	});
	
}

</script>

<h2>로그인</h2>
<c:if test="${empty sessionScope.USER_INFO}">
<form id="frm" method="post" >
아이디 <input type="text" id="twUserId" name="twUserId" required/><br>
비밀번호 <input type="password" id="twUserPwd" name="twUserPwd" required/><br>
</form>
<button id="signupBtn" onclick="signup();">회원가입</button>
<button id="loginBtn" onclick="login();">로그인</button>
</c:if>
<c:if test="${not empty sessionScope.USER_INFO}">
<h2>${sessionScope.USER_INFO.twUserName}님 어서오세요.</h2>
<button id="logoutBtn" onclick="logout();">로그아웃</button>
</c:if>