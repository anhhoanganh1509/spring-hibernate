<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
	<c:set var="root" value="${pageContext.request.contextPath}"/>
<script src="${root}/js/jquery.min.js"></script>
<script src="${root}/js/bootstrap.min.js"></script> 
<link rel="stylesheet" href="${root}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${root}/css/stylelogin.css"/>
</head>
<body>
	<div class="login-form">		
		<form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>			
			<h2 class="text-center">Log in</h2>
			<c:if test="${not empty error}">
				<div style="text-align: center;color: red;">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div style="text-align: center;color: blue;">${msg}</div>
			</c:if>
			<div class="form-group">
            	<input type="text" class="form-control" name="username" >
        	</div>
        	<div class="form-group">
            	<input type="password" class="form-control" name="password" >
			</div>
			<div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Log in</button>
            </div>				
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		
	</div>
</body>
</html>