<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script>
$(function(e){
	setTimeout(function() {
		window.location.href = "${pageContext.request.contextPath}/admin/home";
	}, 1500);
});
</script>

<h2>관리자</h2>