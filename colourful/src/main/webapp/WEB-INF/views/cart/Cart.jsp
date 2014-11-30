<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<%@ include file="../common/IncludeTop.jsp"%>
</head>
<body>

<form:form method="post"  modelAttribute="orderForm"  action="order/newOrder">

<div id ="Main">
<div id="Catalog">
<div id="Cart">

<h2>Shopping Cart</h2>
<security:authentication property="principal.username" />
	<table>
		<tr>
			<th><b>Item ID</b></th>
			<th><b>Product ID</b></th>
			<th><b>Description</b></th>
			<th><b>In Stock?</b></th>
			<th><b>Quantity</b></th>
			<th><b>List Price</b></th>
			<th><b>Total Cost</b></th>
			<th>&nbsp;</th>
		</tr>

		<c:if test="${myCart.numberOfItems == 0}">
			<tr>
				<td colspan="8"><b>Your cart is empty.</b></td>
			</tr>
		</c:if>

		<c:forEach var="cartItem" items="${orderForm.cartList}" varStatus="status">
			<tr>
				<td><a href ="itemId = ${cartItem.itemId}">
				${cartItem.itemId}<form:hidden path="cartList[${status.index}].itemId"/>
			  </a></td>
				<td>${cartItem.productId}</td>
				<td>${cartItem.description}</td>
				<td>false</td>
				<td><form:input size="3" path="cartList[${status.index}].quantity" /></td>
				<td><fmt:formatNumber value="${cartItem.listPrice}"
					pattern="$#,##0.00" /></td>
				<td><fmt:formatNumber value="${cartItem.totalCost}"
					pattern="$#,##0.00" /></td>
				<td><a href ="link">Remove </a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7">Sub Total1: <fmt:formatNumber
				value="111" pattern="$#,##0.00" /> <a href="updateCartQuantities">Update Cart</a></td>
			<td>&nbsp;</td>
		</tr>
	</table>

<c:if test="${myCart.numberOfItems > 0}">
     <input  type="submit" value="Proceed to Checkout"/>
</c:if>
</div>

<div id="Separator">&nbsp;</div>
</div>
</div>
</form:form>
</body>
<%@ include file="../common/IncludeBottom.jsp"%>
</html>