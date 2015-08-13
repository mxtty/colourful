<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="<c:url value = "/resources/js/jquery.jcarousel.min.js"/>"></script>
<%-- <script src="<c:url value = "/resources/js/jquery.fancybox-1.3.4.pack.js"/>"></script> --%>
<script src="<c:url value = "/resources/js/jquery.fancybox.js?v=2.1.5"/>"></script>
<script src="<c:url value = "/resources/js/jquery.mousewheel-3.0.6.pack.js"/>"></script>

<link rel="stylesheet" type="text/css" media="screen" href="<c:url value = "/resources/css/skin-2.css"/>">
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value = "/resources/css/jquery.fancybox.css?v=2.1.5"/>">
	<script type="text/javascript">
		$(document).ready(function() {

		/* 	$('.plus').fancybox(); */
			$(".plus").fancybox({
				padding: 0,

				openEffect : 'elastic',
				openSpeed  :350,

				closeEffect : 'elastic',
				closeSpeed  : 350,

				closeClick : true,

				helpers : {
					overlay : null
				}
			});
		});
	</script>
<p id ="navId" class ="catalogNav">
<!--==============================content================================-->
<form:form id="product_detail_form" method="post"	modelAttribute="cartEntryForm" action="product/add">
	<c:set var="productDetail" value="${cartEntryForm.productDetail}" />
	<div class="block-4 col-3">
		<div class="col-5">
			<div class="detail-pic">
		       <a class="plus" href="image/imageDisplay/fulls_${productDetail.imgFileMain}" data-fancybox-group="gallery" title="好吃">
				 <img src="image/imageDisplay/fulls_${productDetail.imgFileMain}" width="500">
			   </a>
<%--     			<img src="image/imageDisplay/fulls_${productDetail.imgFileMain}" width="500"> --%>
			</div>
			<div class="box-3">
				<c:forEach var="imgFileSub" items="${productDetail.imgFileSubList}">
			       <a class="plus" href="image/imageDisplay/fulls_${imgFileSub}" data-fancybox-group="gallery" title="本店特色菜，好吃。经过多年传统工艺。口感好，味道素。健康美食。好吃看得见。">
					 <img src="image/imageDisplay/thumbs_${imgFileSub}" width="100">
				   </a>
				</c:forEach>
			</div>
		</div>
		<div class="col-4 left-2">
			<h3 class="h3-line">${productDetail.productName}</h3>
			<div>
				<br><label>${productDetail.description}</label>
				<div>
						<form:hidden path="productId" value ="${productDetail.productId}"/>
						<fieldset>
							<label>
							    <Strong> 单价:¥${productDetail.unitPrice} &nbsp;&nbsp;&nbsp;&nbsp; 数量:</Strong><form:input type ="number" path="quantity" value="1" class="width40" max="999" min="1"/>
							    <Strong> ${productDetail.unit}</Strong><form:errors path="quantity" class="errormsg" />
							</label>
						</fieldset>
							<a class="myButton">立即购买</a>
				</div>
			</div>
		</div>
	</div>
</form:form>