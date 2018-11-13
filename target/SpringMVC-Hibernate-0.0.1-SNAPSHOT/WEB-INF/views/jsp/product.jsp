<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
	<div class="container">
		<div class="content" style="padding: 4em 0 0 0;">
			<div class="content-middle">
				<h3 class="future">Logo Đội</h3>
				<div class="content-middle-in">
					<ul id="flexiselDemo1">
						<c:if test="${not empty cateList_Product}">
							<c:forEach var="c" items="${cateList_Product}" varStatus="itr">	
								<li><img src="${root}/productImageLogo?id=${c.categoryid}"></li>
							</c:forEach>
						</c:if>	
					</ul>
					<script type="text/javascript">
						$(window).load(function() {
							$("#flexiselDemo1").flexisel({
								visibleItems : 4,
								animationSpeed : 1000,
								autoPlay : true,
								autoPlaySpeed : 3000,
								pauseOnHover : true,
								enableResponsiveBreakpoints : true,
								responsiveBreakpoints : {
									portrait : {
										changePoint : 480,
										visibleItems : 1
									},
									landscape : {
										changePoint : 640,
										visibleItems : 2
									},
									tablet : {
										changePoint : 768,
										visibleItems : 3
									}
								}
							});

						});
					</script>
					<script type="text/javascript" src="${root}/js/jquery.flexisel.js"></script>
				</div>
			</div>
		</div>

		<div class="products">
		<h2 class=" products-in">Sản Phẩm</h2>
		<div class="top-products">
			<c:if test="${not empty listCustomerProduct}">
				<%int count = 0; int i = 4;%>
				<c:forEach var="c" items="${listCustomerProduct}" varStatus="itr">					
					<div class="col-md-3 md-col">
						<div class="col-md">
							<a href="${root}/customerProductSingle/${c.productid}" class="compare-in"> 
								<img src="${root}/productImage?id=${c.productid}">
								<div class="compare">
									<span>Chi Tiết</span>
								</div>
							</a>
							<div class="top-content">
								<h5 style="text-align: center;">
									<c:if test="${c.sanid == '1' }">
										<a href="#">${c.category.categoryname } sân nhà</a>
									</c:if>
									<c:if test="${c.sanid == '2' }">
										<a href="#">${c.category.categoryname } sân khách</a>
									</c:if>
								</h5>
								<div class="white">
									<a href="${root}/customerProductCart/${c.productid}"
										class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">Thêm Giỏ Hàng</a>
									<p class="dollar">
										<span>2</span><span>0</span><span class="in-dollar">vnđ</span>
									</p>
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</div>
					<%count++; if(count == i) {i=i+4;%>
			<div class="clearfix"></div>
		</div>
		<div class="top-products">
					<%} %>
				</c:forEach>
			</c:if>
			<div class="clearfix"></div>
		</div>
		<tag:paginate max="12" offset="${offset}" count="${count}" uri="${root}/customerProduct/${id}" next="&raquo;" previous="&laquo;"/>
	</div>
	</div>
	