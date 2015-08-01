<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p id ="navId" class ="catalogNav">
<!--==============================content================================-->
<div class="block-4 col-3">
	<form:form id="product_list_form" method="post"  modelAttribute="registerUserForm" action="">
		<div class="h2"><h2 class="h2-line-2">${products.categoryName}</h2></div>
		<div class="box-4 border-3">
		<c:forEach var="product" items="${products.productList}">
			<div>
				<h4><c:out value="${product.productName}"></c:out></h4>
				<div class="img-border"><img height ="130px" src="image/imageDisplay/fulls_${product.imgFileMain}" /></div>
				<div class="price">¥<c:out value="${product.unitPrice}/${product.unit}"></c:out> </div>
				<a href="product/showProduct/${product.productId}" class="myLink" >加入购物车</a>
			</div>
		</c:forEach>
		</div>

	</form:form>
</div>