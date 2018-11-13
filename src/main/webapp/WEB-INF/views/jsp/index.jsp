<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Shop Hoàng Anh Sport</title>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<link href="${root}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<script src="${root}/js/jquery.min.js"></script>
<link href="${root}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<script type="text/javascript" src="${root}/js/move-top.js"></script>
<script type="text/javascript" src="${root}/js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<link rel="stylesheet" href="${root}/css/etalage.css">
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

<script>
	$(document).ready(function(c) {
		$('.alert-close').on('click', function(c) {
			$('.message').fadeOut('slow', function(c) {
				$('.message').remove();
			});
		});
	});
</script>
<script>
	$(document).ready(function(c) {
		$('.alert-close1').on('click', function(c) {
			$('.message1').fadeOut('slow', function(c) {
				$('.message1').remove();
			});
		});
	});
</script>
	
<script>
    function getHuyen() {
    $.ajax({
        async: false,
        url: "CartServlet",
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
        url: "CartServlet",
        type: "POST",
        dataType: "json",
        data: {            
            'isAction': "getXaTP",
            'huyenTPId': $("#diaChiHuyenId").val()           
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