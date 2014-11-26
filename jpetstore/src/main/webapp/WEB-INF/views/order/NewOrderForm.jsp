<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="rb" uri="/WEB-INF/tlds/rainbow.tld"%>

<!DOCTYPE html>
<html>
<head>

<%@ include file="../common/IncludeTop.jsp"%>
</head>
<body>

<form:form method="POST" modelAttribute="orderForm" action="order/confirm">
<form:errors path="*" cssClass="errorblock" element="div" />
<div id ="Main">
<div id="Catalog">
	<table>
		<tr>
			<th colspan=2>Payment Details</th>
		</tr>
		<tr>
			<td>Card Type:</td>
 			<td>
 		     <rb:defineCodeList id="cardTypeCode"/>
			 <form:select path="cardType">
               <form:option label="選択してください" value="" selected="selected"/>
               <form:options items="${cardTypeCode}"/>
             </form:select>
			</td>
		</tr>
		<tr>
			<td>Card Number:</td>
			<td><c:out value="${orderForm.creditCard}" /> * Use a fake
			number!</td>
		</tr>
		<tr>
			<td>Expiry Date (MM/YYYY):</td>
			<td><c:out value="${orderForm.expiryDate}" /></td>
		</tr>
		<tr>
			<th colspan=2>Billing Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><form:input  path="billToFirstName"/><form:errors path="billToFirstName"/></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><form:input  path="billToLastName"/></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><form:input  path="billAddress1" /></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><form:input  path="billAddress2" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><form:input  path="billCity"/></td>
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
			<td><c:out  value="${orderForm.billCountry}" /></td>
		</tr>


	</table>

	<input type= "submit" name="newOrder" value="Continue" />
</div>
</div>
</form:form>

<%@ include file="../common/IncludeBottom.jsp"%>
</body>
</html>