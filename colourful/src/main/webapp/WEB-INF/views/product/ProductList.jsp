<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--==============================content================================-->
<div class="block-4 col-3">
	<form:form id="product_list_form" method="post"  modelAttribute="registerUserForm" action="registerUser/register">
		<div class="h2"><h2 class="h2-line-2">${products.categoryName}</h2></div>

		<div class="box-4 border-3">
		<c:forEach var="product" items="${products.productList}">
			<div>
				<h4>${product.productName}</h4>
				<div class="img-border"><img src="image/imageDisplay/${product.imgFileMain}" /></div>
				<div class="price">¥${product.unitPrice}/${product.unit} </div>
				<a href="product/showProduct/${product.productId}" class="myButton addToCartBtn" >加入购物车</a>
			</div>
		</c:forEach>
		</div>

	</form:form>
</div>