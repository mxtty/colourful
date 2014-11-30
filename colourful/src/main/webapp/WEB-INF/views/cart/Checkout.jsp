<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<%@ include file="../common/IncludeTop.jsp"%>
</head>
<body>
<form:form method="post"   modelAttribute="orderForm"  action="order/insert">
<div id="BackLink"><a href ="">
	Return to Shopping Cart</a></div>

<div id="Catalog">

<table>
	<tr>
		<td>
		<h2>Checkout Summary</h2>

		<table>

			<tr>
				<td><b>Item ID</b></td>
				<td><b>Product ID</b></td>
				<td><b>Description</b></td>
				<td><b>In Stock?</b></td>
				<td><b>Quantity</b></td>
				<td><b>List Price</b></td>
				<td><b>Total Cost</b></td>
			</tr>

			<c:forEach var="cartItem" items="${cart.cartItems}">
				<tr>
					<td><a href="detail?itemId=${cartItem.item.itemId}">
				  ${cartItem.item.itemId}
			    </a></td>
					<td>${cartItem.item.product.productId}</td>
					<td>${cartItem.item.attribute1} ${cartItem.item.attribute2}
					${cartItem.item.attribute3} ${cartItem.item.attribute4}
					${cartItem.item.attribute5} ${cartItem.item.product.name}</td>
					<td>${cartItem.inStock}</td>
					<td>${cartItem.quantity}</td>
					<td><fmt:formatNumber value="${cartItem.item.listPrice}"
						pattern="$#,##0.00" /></td>
					<td><fmt:formatNumber value="${cartItem.total}"
						pattern="$#,##0.00" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">Sub Total: <fmt:formatNumber
					value="${actionBean.cart.subTotal}" pattern="$#,##0.00" /></td>
			</tr>
		</table>
	</tr>
</table>
		<a href ="${flowExecutionUrl}&_eventId=accountAdded">
      	Proceed to Checkout
      </a>

</div>
</form:form>
</body>
<%@ include file="../common/IncludeBottom.jsp"%>
</html>