
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<div class="header">
	<div class="header-bottom">
		<div class="container">
			<div class="h_menu4">
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
					<li class="active"><a href="${root}/index"><i> </i>Trang chủ</a></li>
					<li><a href="#">Đồ bóng đá</a>
						<ul class="drop">
							<c:forEach items="${cateList}" var="c">
								<li>
									<a href="${root}/customerProduct/${c.categoryid}">${c.categoryname}</a>								
								</li>
							</c:forEach>							
						</ul></li>
					<li><a href="#"> ĐỒ BÓNG RỔ</a></li>
					<li><a href="#">THÔNG TIN</a></li>
					<li><a href="#">KHUYẾN MÃI</a></li>
					<li><a href="${root }/checkoutProductCart">THANH TOÁN</a></li>
					<li><a href="${root}/login">ĐĂNG NHẬP</a></li>
				</ul>
				<script type="text/javascript" src="${root}/js/nav.js"></script>
			</div>
		</div>
	</div>
	<div class="header-bottom-in">
		<div class="container">
			<div class="header-bottom-on">
				<p class="wel"><a href="#">Rất hân hạnh được phục vụ quý khách.</a></p>
				<div class="header-can">
					<div class="search">
						<form>
							<input type="text" value="Search" onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = '';}"> 
							<!-- <input type="submit" value=""> -->
						</form>
					</div>
					<div class="header-in">
						<ul class="icon1 sub-icon1">							
							<li><div class="cart">
									<a href="#" class="cart-in"> </a>
									<span> ${myCart.quantityTotal}</span>
								</div>
								<ul class="sub-icon1 list">
									<h3 style="text-align: center;">Đã chọn  sản phẩm</h3>
									<div class="shopping_cart">
										<c:forEach items="${cartForm.cartLines}" var="c"
               								varStatus="varStatus">								
												<div class="cart_box">
	                                               <div class="message">
	                                                 <div class="alert-close"><a href="#"></a></div>
	                                                   <div class="list_desc">
	                                                   	<h4><a href="#">${c.product.name} 
	                                                   		<c:if test="${c.product.sanid=='1'}">
																sân nhà
															</c:if>	
	                                                   		<c:if test="${c.product.sanid=='2'}">
																sân khách
															</c:if> </a></h4>
	                                                      ${c.quantity} x
	                                                       <span class="actual"> ${c.product.productPrice}.000</span>
	                                                   </div>
	                                                   <div class="clearfix"></div>
	                                               </div>
	                                           </div>
										</c:forEach>
									</div>
									<div class="total">
										<div class="total_left">Tổng tiền :</div>
										<div class="total_right">${myCart.amountTotal}00 vnđ</div>
										<div class="clearfix"></div>
									</div>
									<div class="login_buttons">
										<div class="check_button">			
											<a href="${root }/checkoutProductCart">Thanh Toán</a>
										</div>
										<div class="clearfix"></div>
									</div>
								</ul>
							</li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>