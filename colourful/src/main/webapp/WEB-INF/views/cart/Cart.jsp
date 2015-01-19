<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="StyleSheet" href="<c:url value = "/resources/css/cart.css"/>" type="text/css" media="screen" />
<script src="<c:url value = "/resources/js/cart.js"/>"></script>
<!--==============================content================================-->
       <div class="block-4 col-3">
       <div class="h2"><h2 class="h2-line-2">我点的菜:</h2></div>
     <ul class="item-list">
	  <li class="item">
		<div class="item_information">
		  <div class="item_image">
			<img src="image/imageDisplay/c1001_10001_img3.jpg">
		  </div>
		  <div class="item_body">
			<h2 class="item_title">猪肉三鲜水饺</h2>
			<p class="item_description">美味可口，回味无穷.</p>
		  </div>
		  <div class="item_price js-item-price" data-price="11.99">¥1199</div>
		</div>
		<div class="item_interactions">
		  <p class="item_quantity">
			<a class="js-item-increase" title="Add another copy">+</a>
			<a class="js-item-decrease decrease--disabled" title="Remove a copy">-</a>
			<span data-quantity="1">
			  <b>1</b>
			  
			</span>
			份/每份 ¥11.99
		  </p>
		  <a class="item_remove js-item-remove" title="Remove this item">&times;</a>
		</div>
	  </li>
	</ul>
	</div>	   


	<div class="summary js-summary">
	  <ul class="steps">
		<li>
		  <b>合计:</b>
		  <span class="sum js-subtotal">¥32.86</span>
		</li>
		<li>
		  <b>运费:</b>
		  <span class="sum js-shipping">¥5.00</span>
		</li>
	  </ul>
	  <ul class="checkout">
		<li>
		  <b>总计:</b>
		  <span class="sum js-total">¥39.50</span>
		</li>
		<li>
		  <a href="cart/checkout" class="myButton width-8">结算</a>
		</li>
	  </ul>
	</div> 
