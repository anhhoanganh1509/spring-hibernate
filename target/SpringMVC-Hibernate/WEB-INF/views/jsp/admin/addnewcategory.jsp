<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form 
	action="${pageContext.request.contextPath}/admin/${action}" 
	modelAttribute="categoryForm" 
	method="POST" 
	autocomplete="off" >
	<table style="width: 95%;">		
		<tr>
			<td width="125px"><b>Áo Bóng Đá</b><b style="color: red;"> *</b></td>
			<td>
				<form:input type="text" style="width: 50%;" class="pendek" path="categoryname" required="required"/>		
			</td>
		</tr>	
		<tr>
			<td></td>
			<td>
				<input type="submit" class="button" value="Submit"/>	
				<input type="reset" class="button" value="Reset"/>
				<c:if test="${action=='updateCategory'}">
					<form:input type="hidden" path="categoryid" />	
				</c:if>				
			</td>
		</tr>	
	</table>
</form:form>
