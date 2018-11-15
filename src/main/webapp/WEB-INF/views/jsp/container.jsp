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
			
	</div>
</div>