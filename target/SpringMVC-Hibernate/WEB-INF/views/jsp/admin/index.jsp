
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Shop Hoàng Anh Sport</title>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${root}/mos-css/mos-style.css"> 
<link rel="stylesheet" type="text/css" href="${root}/css/style.css"> 
<link rel="stylesheet" type="text/css" href="${root}/css/pagination.css">
<script src="${root}/js/jquery.min.js"></script>
<script>
    function getAoDau() {
    $.ajax({
        async: false,
        url: "fetchDonViHanhChinh",
        type: "POST",
        dataType: "json",
        data: {            
            'isAction': "getCategory",
            'categoryId': $("#productid").val()         
        },      
        success: function(results) {        	
            var htmlCombo = "<option value='0'>Chọn đội</option>";
            $.each(results, function(key, value) {
            	if(value.key!="value") {
                	htmlCombo += "<option value='" + value.id + "'>"+ value.name + "</option>";
            	}
            });
            $('#doiId').html(htmlCombo);
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
	<div id="wrapper">
		
			<div id="leftBar">
				<jsp:include page="leftBar.jsp"></jsp:include>
			</div>
			<div id="rightContent" style="height: 75%;">	
				<%-- <c:if test="${listuser != null}">
					<jsp:include page="users.jsp"></jsp:include>
				</c:if>--%>
				<c:if test="${not empty categoryList}">
					<jsp:include page="category.jsp"></jsp:include>
				</c:if>
				<c:if test="${not empty categoryForm}">
					<jsp:include page="addnewcategory.jsp"></jsp:include>
				</c:if> 
				<c:if test="${not empty actionProduct}">
					<jsp:include page="product.jsp"></jsp:include>
				</c:if>
				<c:if test="${not empty productForm}">
					<jsp:include page="addnewproduct.jsp"></jsp:include>
				</c:if> 
				<c:if test="${not empty actionDetail}">
					<jsp:include page="detailproduct.jsp"></jsp:include>
				</c:if>
				<c:if test="${not empty productFormDetail}">
					<jsp:include page="addnewdetailproduct.jsp"></jsp:include>
				</c:if> 
			</div>
			<div class="clear"></div>
				<jsp:include page="footer.jsp"></jsp:include>
		
	</div>
</body>
</html>