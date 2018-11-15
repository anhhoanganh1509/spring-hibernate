
<!DOCTYPE html>
<html>
<head>
<title>Shop Hoàng Anh Sport</title>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${root}/css/bootstrap.css">

<script src="${root}/js/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="${root}/css/style.css">

<script>
    function getHuyen() {
    $.ajax({
        async: false,
        url: "fetchDonViHanhChinh",
        type: "POST",
        dataType: "json",
        data: {            
            'isAction': "getHuyenTP",
            'tinhTPId': $("#diaChiTinhId").val()           
        },      
        success: function(results) {        	
            var htmlCombo = "<option value='0'>Ch&#7885;n Qu&#7853;n/Huy&#7879;n</option>";
            var htmlCombo1 = "<option value='0'>Ch&#7885;n x&atilde;</option>";
            $.each(results, function(key, value) {
            	if(value.key!="value") {
                	htmlCombo += "<option value='" + value.id + "'>"+ value.name + "</option>";
            	}
            });
            $('#diaChiHuyenId').html(htmlCombo);
            $('#diaChiXaId').html(htmlCombo1); 
        },
        error: function () {
            console.log("Error");
        }
    });
}    
function getXa() {
    $.ajax({
        async: false,
        url: "fetchDonViHanhChinh",
        type: "POST",
        dataType: "json",
        data: {            
            'isAction': "getXaTP",
            'tinhTPId': $("#diaChiHuyenId").val()           
        },      
        success: function(results) {        	
            var htmlCombo = "<option value='0'>Ch&#7885;n x&atilde;</option>";
            $.each(results, function(key, value) {
            	if(value.key!="value") {
                	htmlCombo += "<option value='" + value.id + "'>"+ value.name + "</option>";
            	}
            });
            $('#diaChiXaId').html(htmlCombo);     
        },
        error: function () {
            console.log("Error");
        }
    });
}     
</script>
</head>
<body>
	
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container">
		<div class="account">
			<h2 class="account-in">Thông tin</h2>
			<form:form 
				action="${root}/${action}" 
				modelAttribute="info_customer" 
				method="POST" 
				autocomplete="off" >
				<div>
					<span style="padding-right: 2em;">Họ và tên<b style="color: red;"> *</b></span> 
					<form:input type="text" id="customername" path="customername" autocomplete="off" required="required" />
				</div>
				<div>
					<span style="padding-right: 1.85em;">Điện thoại<b style="color: red;"> *</b></span> 
					<form:input type="text" id="customerphone" path="customerphone" autocomplete="off" required="required" />
				</div>
				<div>
					<span style="padding-right: 3.4em;">Địa chỉ<b style="color: red;"> *</b></span> 
					<form:input type="text" id="customeraddress" path="customeraddress" autocomplete="off" required="required" />
				</div>
				<div class="row mb40" style="margin-left: 115px;">
					<div class="col-md-4" style="width: 22.5%;">
						<form:select class="form-control" style="width: 90%;"
							path="diaChiTinhId" id="diaChiTinhId" onChange="getHuyen()">
							<form:option value="0">--Chọn Tỉnh/TP--</form:option>
							<c:forEach items="${cateListDVHC}" var="c">
								<form:option value="${c.id}">${c.ten}</form:option>
							</c:forEach>
						</form:select>
					</div>
					<div class="col-md-4" style="width: 22.5%;">
						<form:select class="form-control" style="width: 90%;" id="diaChiHuyenId" path="diaChiHuyenId" onChange="getXa()">
							<form:option value="0">--Chọn quận/ huyện--</form:option>
						</form:select>
					</div>
					<div class="col-md-4" style="width: 22.5%;">
						<form:select class="form-control" style="width: 90%;" id="diaChiXaId" path="diaChiXaId">
							<form:option value="0">--Chọn xã/ phường--</form:option>
						</form:select>
					</div>
				</div>
				<input type="submit" value="Thanh toán">
			</form:form>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
