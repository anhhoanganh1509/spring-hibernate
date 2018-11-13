<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:url value="/j_spring_security_logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>
<ul>
	<li><a href="${root}/admin/listCategory">Loại Áo</a></li>
	<li><a href="${root}/admin/listProduct">Tên Đội</a></li>
	<li><a href="${root }/admin/listDetailProduct">Áo Đội</a></li>
	<li><a href="#">Thống Kê</a></li>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<li><a href="javascript:formSubmit()">Đăng Xuất</a></li>
	</c:if>
</ul>