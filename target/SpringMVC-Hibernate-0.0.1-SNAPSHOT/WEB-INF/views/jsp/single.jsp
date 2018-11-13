
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<div class="container">
			<div class="single">
				<div class="col-md-9 top-in-single">
					<div class="col-md-5 single-top">	
						<ul id="etalage">
						    <li>
								<img class="etalage_thumb_image img-responsive" src="${root}/productImage?id=${customerProductSingle.productid}" alt="">
								<img class="etalage_source_image img-responsive" src="${root}/productImage?id=${customerProductSingle.productid}" alt="">
							</li>
						</ul>
					</div>	
					<div class="col-md-7 single-top-in">
						<div class="single-para">								
								<div class="para-grid">
									<span  class="add-to">${customerProductSingle.productprice}.000 VNĐ</span>
									<a href="${root}/customerProductCart/${customerProductSingle.productid}" class="hvr-shutter-in-vertical cart-to">Thêm Giỏ Hàng</a>					
									<div class="clearfix"></div>
								 </div>
								 <h5>${customerProductSingle.category.categoryname}</h5>	
								 <p>${customerProductSingle.productdescription}</p>
																		
						</div>
					</div>
					<div class="clearfix"> </div>				
				</div>				
			<div class="clearfix"> </div>
		</div>
	</div>