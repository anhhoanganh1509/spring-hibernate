<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld" %>
<%@ taglib prefix = "fmd" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<div class="informasi">
	<a href="${root }/admin/${actionProduct}">
		<input type="submit" class="button" value="Thêm mới">
	</a>
	<form method="get" action="${root}/admin/listProduct" style="width: 40%;float: right;">
		<input type="text" style="width: 60%;" class="pendek" name="name" value="${name}" autocomplete="off" placeholder="Nhập tên đội">		
		<input type="submit" class="button" value="Tìm kiếm">
	</form>
</div>
<div style="height: 90%;">
<table class="data">
	<tr class="data">
		<th class="data" width="30px">STT</th>
		<th class="data">Tên Đội</th>
		<th class="data">Ngày Tạo</th>
		<th class="data">Người Tạo</th>
		<th class="data">Ngày Sửa</th>
		<th class="data">Người Sửa</th>
		<th class="data" width="75px">Thay Đổi</th>
	</tr>
	<c:if test="${not empty productList}">
		<c:forEach var="c" items="${productList}" varStatus="itr">
			<tr class="data">
				<td class="data" width="30px" style="text-align: center;">${offset + itr.index +1 }</td>
				<td class="data">${c.categoryname}</td>
				<td class="data" style="text-align: center;">
					<fmd:formatDate pattern="dd-MM-yyyy" value="${c.ngaytao}" />
				</td>
				<td class="data"></td>
				<td class="data" style="text-align: center;">
					<fmd:formatDate pattern="dd-MM-yyyy" value="${c.ngaysua}" />
				</td>
				<td class="data"></td>
				<td class="data" width="75px" style="text-align: center;">
					<a href="${root}/admin/editProduct/${c.categoryid}" title="Sửa">
						<img src="${root }/mos-css/img/edit.png"></a>&nbsp;&nbsp;
					
					<a href="${root}/admin/deleteProduct/${c.categoryid}" title="Xóa">
						<img src="${root }/mos-css/img/trash.gif"></a>			
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
</div>
<tag:paginate max="12" offset="${offset}" count="${count}" uri="${root}/admin/listProduct/${name}" next="&raquo;" previous="&laquo;"/>
