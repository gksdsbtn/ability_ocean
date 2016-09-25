<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script>


</script>

<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>조회수</th>
		<th>날짜</th>
	</tr>
	<c:forEach items="${boardList}" var="boardList" varStatus="status">
		<tr>
			<td>${status.index+1}</td>
			<td>${boardList.bTitle}</td>
			<td>${boardList.bHit }</td>
			<td>${boardList.bDate }</td>
		</tr>
	</c:forEach>
</table>

<p>
</p>
<p>
</p>
<p>
</p>


	<ul>
		<c:if test="${page.totalPage eq 1 }">
          <li><a href="#">left</a></li>
       	</c:if>
       	<c:if test="${page.totalPage ne 1 }">
          <li><a href="javascript:movePage('${page.nowPage - 1}');">left</a></li>
       	</c:if>
       	
       	<c:forEach var="pageNum" begin="${page.startPage}" end="${page.endPage}">
          <li><a href="javascript:movePage('${pageNum}');"<c:if test="${pageNum eq page.nowPage}">class="active"</c:if>>${pageNum}</a></li>
       	</c:forEach>
         
         	<c:if test="${page.startPage eq page.totalPage }">
          <li><a href="#">right</a></li>
        </c:if>
        <c:if test="${page.startPage ne page.totalPage }">
          <li><a href="javascript:movePage('${page.nowPage + 1}');">right</a></li>
        </c:if>
	</ul>


	<form id="frm" name="frm" method="post">
    	<input type="hidden" name="nowPage" value="${page.nowPage}"/>
    </form>
