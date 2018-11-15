<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<form:form 
	action="${pageContext.request.contextPath}/admin/${action }"
	modelAttribute="productForm" 
	method="POST" 
	enctype="multipart/form-data"
	autocomplete="off" >
	<table style="width: 95%;">	
		<tr>
			<td width="125px"><b>Loại</b></td>
			<td>
				<form:select path="chaid" style="width: 50%;">                    
					<c:forEach items="${cateList}" var="c">
						<c:choose>
							<c:when test="${c.categoryid == productForm.chaid}">
								<form:option value="${c.categoryid}" selected="true">${c.categoryname}</form:option>
							</c:when>
							<c:otherwise>
								<form:option value="${c.categoryid}">${c.categoryname}</form:option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select> 
			</td>
		</tr>	
		<tr>
			<td width="125px"><b>Tên Đội</b><b style="color: red;"> *</b></td>
			<td>
				<form:input type="text" style="width: 50%;" class="pendek" path="categoryname" autocomplete="off" required="required"/>
			</td>
		</tr>
		<tr>
			<td>
				<b>Hình Ảnh Logo</b>
			</td>
			<td>
				<input type="file" name="fileUpload" style="width: 50%;"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" class="button" value="Submit">
				<input type="reset" class="button" value="Reset">
				<c:if test="${action=='updateProduct'}">
					<form:input type="hidden" path="categoryid" />	
				</c:if>	
			</td>
		</tr>	
	</table>
</form:form>