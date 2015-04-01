<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="StyleSheet" href="<c:url value = "/resources/css/cart.css"/>" type="text/css" media="screen" />

<p id ="navId" class ="catalogNav">
<!--==============================content================================-->
  <div class="block-4 col-3">
  <c:if test="${!empty productDetailList}">
     <div class="h2"><h2 class="h2-line-2">订单详细(${brnOrder.orderId})</h2></div>
     <ul class="item-list">
     <c:forEach var="product" items="${productDetailList}" varStatus="status">
	  <li class="item">
		<div class="item_information">
		  <div class="item_image">
			<img src="image/imageDisplay/${product.imgFileMain}">
		  </div>
		  <div class="item_body">
			<h2 class="item_title"><a href ="product/showProduct/${product.productId}">${product.productName}</a></h2>
			<p class="item_description"><c:out value="${product.description}"/></p>
		  </div>
		  <div class="item_price js-item-price"><fmt:formatNumber value="${product.unitPrice * product.quantity}" pattern="¥###0.00" /></div>
		</div>
		<div class="item_interactions" id ="aaa">
		  <p class="item_quantity">
			<span>${product.quantity}&nbsp;</span>
			<c:out value="${product.unit}/每${product.unit}"/>
			<fmt:formatNumber value="${product.unitPrice}" pattern="¥###0.00" />
		 </p>
		</div>
	  </li>
	</c:forEach>
	</ul>
	<div id="shipInfo" class="info-detail" >
          <label><strong class="right width-10">订单号:</strong><strong class="left width-10">${brnOrder.orderId}</strong></label>
          <label><strong class="right width-10">联系人:</strong><strong class="left width-10">${brnOrder.shipName}</strong></label>
          <label><strong class="right width-10">电话:</strong><strong class="left width-10">${brnOrder.phone}</strong></label>
          <label><strong class="right width-10">送货时间:</strong><strong class="left width-30"><fmt:formatDate value="${brnOrder.shipDate}" pattern="yyyy年MM月dd日 HH:mm:ss" /></strong></label>
          <label><strong class="right width-10">送货地点:</strong><strong class="left width-30">${brnOrder.shipAddress}</strong></label>
	</div>
  </c:if>
  </div>   
    
