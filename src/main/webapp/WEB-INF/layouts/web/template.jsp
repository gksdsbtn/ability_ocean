<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="kr">

<head>
     <meta charset="utf-8">
    <meta name="" content="">
    <meta name="description" content="">
    <meta name="keyword" content="">
    <title>TAEWOONG HOME PAGE MAIN</title>
    
    
    <script src="${pageContext.request.contextPath}/resources/web/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/web/js/jquery.form.min.js"></script>
    
 </head>
<body>
	
    
    	<t:insertAttribute name="header"/>
		<t:insertAttribute name="content"/>
    
    <!-- /#wrapper -->
    
    	<t:insertAttribute name="footer" />

</body>

</html>
