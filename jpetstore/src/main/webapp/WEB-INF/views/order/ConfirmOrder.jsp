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


<form:form method="post"   modelAttribute="orderForm"  action="order/insert">
<div id ="Main">
<div id="Catalog">Please confirm the information below and then
press continue...
<table>
	<tr>
		<th align="center" colspan="2"><font size="4"><b>Order</b></font>
		<br />
		<font size="3"><b> <fmt:formatDate
			value="${orderForm.orderDate}" pattern="yyyy/MM/dd hh:mm:ss" /></b></font>
		</th>
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

</table>

	<input type= "submit" name="newOrder" value="Confirm" />

</div>
</div>
</form:form>


</body>
<%@ include file="../common/IncludeBottom.jsp"%>
</html>




