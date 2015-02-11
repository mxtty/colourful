<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="StyleSheet" href="<c:url value = "/resources/css/cart.css"/>" type="text/css" media="screen" />
<script src="<c:url value = "/resources/js/cart.js"/>"></script>
<!--==============================content================================-->
       <div class="block-4 col-3">
       <div class="h2">
         <h2 class="h2-line-2">
          <c:if test="${!empty productDetailList}">
           我点的菜:
           </c:if>
           <c:if test="${empty productDetailList}">
           购物车是空的！<br>
           快来<a href="catalog">在线订餐</a>，选购吧。	
           </c:if>
         </h2>
       </div>

	<div class="box-4 ">

     <ul class="item-list">
     <c:forEach var="product" items="${productDetailList}">
	  <li class="item">
		<div class="item_information">
		  <div class="item_image">
			<img src="image/imageDisplay/${product.imgFileMain}">
		  </div>
		  <div class="item_body">
			<h2 class="item_title"><c:out value="${product.productName}"/></h2>
			<p class="item_description"><c:out value="${product.description}"/></p>
		  </div>
		  <div class="item_price js-item-price" data-price="${product.unitPrice}"><fmt:formatNumber value="${product.unitPrice * product.quantity}" pattern="¥###0.00" /></div>
		</div>
		<div class="item_interactions">
		  <p class="item_quantity">
			<a class="js-item-increase" title="加上一${product.unit}">+</a>
			<a class="js-item-decrease" title="去掉一${product.unit}">-</a>
			<span data-quantity="${product.quantity}"> <b>${product.quantity}</b>&nbsp;</span>
			<c:out value="${product.unit}/每${product.unit}"/>
			<fmt:formatNumber value="${product.unitPrice}" pattern="¥###0.00" />
		 </p>
		  <a class="item_remove js-item-remove" title="这次不买">&times;</a>
		   <a class="item_remove js-item-remove1" title="从购物车清除"><img height="18" src="<c:url value = "/resources/images/icon_trash.png"/>"></a> 
		</div>
	  </li>
	</c:forEach>
 
	</ul>

	</div>	

   <c:if test="${!empty productDetailList}">
	<div class="summary js-summary">
	  <ul class="steps">
		<li>
		  <b>合计:</b>
		  <span class="sum js-subtotal"><fmt:formatNumber value="${total}" pattern="¥###0.00" /></span>
		</li>
		<li>
		  <b>运费:</b>
		  <span class="sum js-shipping"><fmt:formatNumber value="${shipping}" pattern="¥###0.00" /></span>
		</li>
	  </ul>
	  <ul class="checkout">
		<li>
		  <b>总计:</b>
		  <span class="sum js-total"><fmt:formatNumber value="${total+shipping}" pattern="¥###0.00" /></span>
		</li>
		<li>
		  <a href="cart/checkout" class="myButton width-8">结算</a>
		</li>
	  </ul>
	</div> 
	</c:if>

	</div> 
   
