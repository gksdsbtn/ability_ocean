<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script type="text/javascript">

/**
 * 아이디 유효성 검사
 */
 function isVaildId(){
	 var regId = /^[A-Za-z0-9]{6,12}$/;
	 var testId = $("input[name='twUserId']").val();
	 
	 if(!regId.test(testId)){
		 alert("아이디는 숫자와 영문자로 6자 이상 12자 이하로 입력해주세요!");
		 $("input[name='twUserId']").focus();
		 return false;
	 }
	 return true;
}

 /**
  * 비밀번호 유효성 검사
  */
 function isValidPassword(){
 	var regExp = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-]|.*[0-9]).{9,24}$/;
 	var pwd = $("#frm input[name='twUserPwd']").val();
 	var pwd2 = $("#frm input[name='twUserPwd2']").val();	
 	
 	if(!regExp.test(pwd)){
 		alert("비밀번호는 숫자와 영문자를 조합하여\n9자이상 24자 이하로 입력해주세요!");
 		$("#signupForm input[name='twUserPwd']").focus();
 		return false;
 	}	
 	
 	if(pwd.search(/[0-9]/g) < 0 || pwd.search(/[a-z]/ig) < 0){ 
         alert("비밀번호는 숫자와 영문자를 조합하여 입력해주세요!");
         $("#signupForm input[name='twUserPwd2']").focus();
         return false;
     }
 	
 	if(pwd != pwd2){
 		alert("비밀번호가 서로 일치하지 않습니다.");
 		$("input[name='twUserPwd2']").focus();
 		return false;
 	}
 	return true;		
 }


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
 
 


function create(){
	
	if(!hasNotBlank("frm")) return false; // 빈 칸 확인
	if(!isValidPassword()) return false; //비밀번호 유효성
	alert("dd");
	
	$("#frm").ajaxSubmit({
		url: "${pageContext.request.contextPath}/user/create"
		//, data: $("#frm").serialize()
		, dataType: "json"
		, success: function(response){
			if(response.header.status == 0000){
				alert("로그인 되었습니다.");
				window.location.href = "${pageContext.request.contextPath}/";
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



function cancel(){
	window.location.href = "${pageContext.request.contextPath}/";
}

</script>


<h2>회원가입</h2>

<form id="frm" method="post">
아이디 <input type="text" id="twUserId" name="twUserId" placeholder="ID 입력" onchange="isVaildId();"/><br>
이름 <input type="text" id="twUserName" name="twUserName" placeholder="NAME 입력" /><br>
비밀번호 <input type="password" id="twUserPwd" name="twUserPwd" placeholder="PWD 입력" /><br>
비밀번호확인 <input type="password" id="twUserPwd2" name="twUserPwd2" placeholder="PWD 입력" /><br>
</form>

<button onclick="create();">회원등록</button>
<button onclick="cancel();">취소</button>