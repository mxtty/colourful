<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--==============================content================================-->

	<div class="block-4 col-3">
		<div class="col-5">
			<div class="detail-pic">
				<img src="image/imageDisplay/${productDetail.imgFileMain}" width="500">
			</div>
			<div class="box-3">
				<c:forEach var="imgFileSub" items="${productDetail.imgFileSubList}">
					<img src="image/imageDisplay/${imgFileSub}" width="100">
				</c:forEach>
			</div>
		</div>
		<div class="col-4 left-2">
			<h3 class="h3-line">${productDetail.productName}</h3>
			<div>
				${productDetail.description}
				<div>
					<form:form id="product_detail_form" method="post"	modelAttribute="cartEntryForm" action="cart/add">
						<form:hidden path="productId" value ="${productDetail.productId}"/>
						<fieldset>
							<label>
							    <Strong> 单价:¥${productDetail.unitPrice} &nbsp;&nbsp;&nbsp;&nbsp; 数量:</Strong><input type ="number" name="quantity" value="1" class="width40" max="999" min="1"/>
							    <Strong> ${productDetail.unit}</Strong>
							</label>
						</fieldset>
							<a class="myButton">立即购买</a>
					</form:form>
				</div>
			</div>
		</div>
	</div>