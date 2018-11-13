<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld" %>
<%@ taglib prefix = "fmd" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<div class="informasi">
	<a href="${root}/admin/${actionDetail}"><input type="submit" class="button" value="Thêm mới"></a>
</div>
<div style="height: 90%;">
<table class="data">
	<tr class="data">
		<th class="data" width="30px">STT</th>
		<th class="data">Tên Sản Phẩm</th>
		<th class="data">Giá</th>
		<th class="data">Ngày Tạo</th>
		<th class="data">Người Tạo</th>
		<th class="data">Ngày Sửa</th>
		<th class="data">Người Sửa</th>
		<th class="data" width="75px">Thay Đổi</th>
	</tr>
	<c:if test="${not empty productListDetail}">
		<c:forEach var="c" items="${productListDetail}" varStatus="itr">
			<tr class="data">
				<td class="data" width="30px" style="text-align: center;">${offset + itr.index +1 }</td>
				
				<td class="data">${c.category.categoryname}</td>
				
				<td class="data">${c.productprice}</td>
				<td class="data" style="text-align: center;">
					<fmd:formatDate pattern="dd-MM-yyyy" value="${c.ngaytao}" />
				</td>
				<td class="data"></td>
				<td class="data" style="text-align: center;">
					<fmd:formatDate pattern="dd-MM-yyyy" value="${c.ngaysua}" />
				</td>
				<td class="data"></td>
				<td class="data" width="75px" style="text-align: center;">
					<a href="#" title="Sửa">
						<img src="${root }/mos-css/img/edit.png"></a>&nbsp;&nbsp;			
					<a href="${root}/admin/deleteDetailProduct/${c.productid}" title="Xóa">
						<img src="${root }/mos-css/img/trash.gif"></a>			
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
</div>
<tag:paginate max="12" offset="${offset}" count="${count}" uri="${root}/admin/listDetailProduct" next="&raquo;" previous="&laquo;"/>

