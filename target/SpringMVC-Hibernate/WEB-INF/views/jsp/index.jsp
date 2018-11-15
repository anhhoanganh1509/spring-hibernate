<html>
<head>
<title>Shop Hoàng Anh Sport</title>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${root}/css/bootstrap.css">
<script src="${root}/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${root}/css/style.css">

<script type="text/javascript" src="${root}/js/move-top.js"></script>
<script type="text/javascript" src="${root}/js/easing.js"></script>

<link rel="stylesheet" type="text/css" href="${root}/css/etalage.css">
<script src="${root}/js/jquery.etalage.min.js"></script>
		<script>
			jQuery(document).ready(function($){
				$('#etalage').etalage({
					thumb_image_width: 300,
					thumb_image_height: 400,
					source_image_width: 900,
					source_image_height: 1200,
					show_hint: true,
					click_callback: function(image_anchor, instance_id){
						alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
					}
				});
			});
		</script>

<script src="${root}/js/responsiveslides.min.js"></script>
<script>
	$(function() {
		$("#slider1").responsiveSlides({
			auto : true,
			speed : 500,
			namespace : "callbacks",
			pager : true,
		});
	});
</script>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<c:if test="${empty listCustomerProduct && empty customerProductSingle}">
		<jsp:include page="slidershow.jsp"></jsp:include>
		<jsp:include page="container.jsp"></jsp:include>
	</c:if>
	
	<c:if test="${not empty listCustomerProduct && empty customerProductSingle}">
		<jsp:include page="product.jsp"></jsp:include>
	</c:if>
	
	<c:if test="${empty listCustomerProduct && not empty customerProductSingle}">
		<jsp:include page="single.jsp"></jsp:include>
	</c:if>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>