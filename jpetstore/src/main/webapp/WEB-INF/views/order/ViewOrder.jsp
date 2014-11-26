<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/IncludeTop.jsp"%>
</head>
<body>
<div id="BackLink"><a href="">
	Return to Main Menu</a></div>


<form:form method="post" modelAttribute="orderForm" action="order/confirm">
<div id ="Main">
<div id="Catalog">
<table>
	<tr>
		<th align="center" colspan="2">Order #${orderForm.orderId}
		<fmt:formatDate value="${orderForm.orderDate}"
			pattern="yyyy/MM/dd hh:mm:ss" /></th>
	</tr>
	<tr>
		<th colspan="2">Payment Details</th>
	</tr>
	<tr>
		<td>Card Type:</td>
		<td><c:out value="${orderForm.cardType}" /></td>
	</tr>
	<tr>
		<td>Card Number:</td>
		<td><c:out value="${orderForm.creditCard}" /> * Fake
		number!</td>
	</tr>
	<tr>
		<td>Expiry Date (MM/YYYY):</td>
		<td><c:out value="${orderForm.expiryDate}" /></td>
	</tr>
	<tr>
		<th colspan="2">Billing Address</th>
	</tr>
	<tr>
		<td>First name:</td>
		<td><c:out value="${orderForm.billToFirstName}" /></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><c:out value="${orderForm.billToLastName}" /></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><c:out value="${orderForm.billAddress1}" /></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><c:out value="${orderForm.billAddress2}" /></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><c:out value="${orderForm.billCity}" /></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><c:out value="${orderForm.billState}" /></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><c:out value="${orderForm.billZip}" /></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><c:out value="${orderForm.billCountry}" /></td>
	</tr>
	<tr>
		<th colspan="2">Shipping Address</th>
	</tr>
	<tr>
		<td>First name:</td>
		<td><c:out value="${orderForm.shipToFirstName}" /></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><c:out value="${orderForm.shipToLastName}" /></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><c:out value="${orderForm.shipAddress1}" /></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><c:out value="${orderForm.shipAddress2}" /></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><c:out value="${orderForm.shipCity}" /></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><c:out value="${orderForm.shipState}" /></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><c:out value="${orderForm.shipZip}" /></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><c:out value="${orderForm.shipCountry}" /></td>
	</tr>
	<tr>
		<td>Courier:</td>
		<td><c:out value="${orderForm.courier}" /></td>
	</tr>
	<tr>
		<td colspan="2">Status: <c:out value="${orderForm.status}" /></td>
	</tr>
	<tr>
		<td colspan="2">
		<table>
			<tr>
				<th>Item ID</th>
				<th>Description</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Total Cost</th>
			</tr>
			<c:forEach var="lineItem" items="${lineItems}">
				<tr>
					<td>
					<a href="xxxx">${lineItem.item.itemId}</a>
					</td>
					<td><c:if test="${lineItem.item != null}">
						${lineItem.item.attribute1}
						${lineItem.item.attribute2}
						${lineItem.item.attribute3}
						${lineItem.item.attribute4}
						${lineItem.item.attribute5}
						${lineItem.item.product.name}
					</c:if> <c:if test="${lineItem.item == null}">
						<i>{description unavailable}</i>
					</c:if></td>

					<td>${lineItem.quantity}</td>
					<td><fmt:formatNumber value="${lineItem.unitPrice}"
						pattern="$#,##0.00" /></td>
					<td><fmt:formatNumber value="${lineItem.total}"
						pattern="$#,##0.00" /></td>
				</tr>
			</c:forEach>
			<tr>
				<th colspan="5">Total: <fmt:formatNumber
					value="${orderForm.totalPrice}" pattern="$#,##0.00" /></th>
			</tr>
		</table>
		</td>
	</tr>

</table>
</div>
</div>
</form:form>

</body>
<%@ include file="../common/IncludeBottom.jsp"%>
</html>