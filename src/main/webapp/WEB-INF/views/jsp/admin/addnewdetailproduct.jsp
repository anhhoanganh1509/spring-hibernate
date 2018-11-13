<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form 
	id="addnewdetailproduct_form"
	action="${pageContext.request.contextPath}/admin/${action}" 
	modelAttribute="productFormDetail" 
	method="POST" 
	enctype="multipart/form-data"
	autocomplete="off" >
	<table style="width: 95%;">
		<tr>
			<td>
				<b>Đồ Bóng Đá</b><b style="color: red;"> *</b>
			</td>
			<td>
				<form:select path="chaid" id="productid" onChange="getAoDau()" style="width: 70%;">
					<form:option value="0">Đồ Bóng Đá</form:option>
					<c:forEach items="${cateList}" var="c">
						<form:option value="${c.categoryid}">${c.categoryname}</form:option>
					</c:forEach>
				</form:select>						
			</td>
			<td>
				<b style="color: red;display: none;" id="msg_doBongDaId"> Vui lòng chọn</b>
			</td>				
		</tr>
		<tr>
			<td>
				<b>Đội</b><b style="color: red;"> *</b>
			</td>
			<td> 
				<form:select id="doiId" path="category.categoryid" style="width: 70%;">
					<form:option value="0">Chọn Đội</form:option>
				</form:select>
			</td>
			<td>
				<b style="color: red;display: none;" id="msg_doiId"> Vui lòng chọn</b>
			</td>
		</tr>
		<tr>
			<td>
				<b>Chọn sân</b>
			</td>
			<td>
				<form:select style="width: 70%;text-align: center;" path="sanid">
					<form:option value="1">Sân nhà</form:option>
					<form:option value="2">Sân khách</form:option>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>
				<b>Áo mặt trước</b><b style="color: red;"> *</b>
			</td>
			<td>
				<input type="file" name="fileUpload" style="width: 70%;" id="ao_mat_truoc"/>
			</td>
		</tr>		
		<tr>
			<td width="125px">
				<b>Giá</b><b style="color: red;"> *</b>
			</td>
			<td>
				<form:input type="text" style="width: 70%;" class="pendek" id="productprice" path="productprice" />
			</td>
			<td>
				<b style="color: red;display: none;" id="msg_productPrice"> Vui lòng nhập</b>
			</td>
		</tr>
		<tr>
			<td>
				<b>Mô tả</b>
			</td>
			<td>
				<form:textarea id="productdescription" path="productdescription" style="height: 90px;"></form:textarea>
			</td>
		</tr>
		<tr><td></td><td>
		<input type="button" class="button" id="save" name="save" value="Submit">	
		<input type="reset" class="button" value="Reset">
		</td></tr>
	</table>
	</form:form>
	<script type="text/javascript">
$(function() {
	$( "#save" ).click(function() {
		if($("#productid").val() == 0){
			$('#msg_doBongDaId').css({ display: "block"});
			$('#productid').css({ border: "1px solid red"});
		}else{
			$('#msg_doBongDaId').css({ display: "none"});
			$('#productid').css({ border: "1px solid #dcdcdc"});
			if($("#doiId").val() == 0){
				$('#msg_doiId').css({ display: "block"});
				$('#doiId').css({ border: "1px solid red"});
			}else{
				$('#msg_doiId').css({ display: "none"});
				$('#doiId').css({ border: "1px solid #dcdcdc"});
				if(document.getElementById('ao_mat_truoc').value.length == 0){					
					alert("Vui lòng chọn Áo mặt trước !");
				}else{
					if($("#productprice").val() == 0){
						$('#msg_productPrice').css({ display: "block"});
						$('#productprice').css({ border: "1px solid red"});
					}else{
						$('#msg_productPrice').css({ display: "none"});
						$( "#addnewdetailproduct_form" ).submit();
					}
				}
			}			
		}
	});	
});
</script>