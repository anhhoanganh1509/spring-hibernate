<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<div class="container">
	<div class="content">
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
		<!---->
		<div class="content-bottom">
			<h3 class="future">Sản phẩm bán chạy</h3>
			<div class="content-bottom-in">
				<ul id="flexiselDemo2">		
				<%-- <%
				ProductDao pDao = new ProductDao();
				for(Product p : pDao.getListReport(null,null,"sanphambanchay")){
				%>	 --%>		
					<li>
						<div class="col-md men">
							<a href="single.html" class="compare-in "><img src="data:image/jpg;base64," alt="" /></a>
							<div class="top-content bag">
								<h5>
									<%-- <%if(p.getSanId() == 1) {%>
										<a href="#"><%=p.getName() %> sân nhà</a>
									<%}else{ %>
										<a href="#"><%=p.getName() %> sân khách</a>
									<%} %> --%>
								</h5>
								<div class="white">
									<a href="CartServlet?command=plus&ID="
										class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">Thêm Giỏ Hàng</a>
									<p class="dollar">
										<span>1</span><span>0</span><span class="in-dollar">vnđ</span>
									</p>
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</li>	
					<%-- <%} %>			 --%>	
				</ul>
				<script type="text/javascript">
					$(window).load(function() {
						$("#flexiselDemo2").flexisel({
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
			</div>
		</div>		
	</div>
</div>