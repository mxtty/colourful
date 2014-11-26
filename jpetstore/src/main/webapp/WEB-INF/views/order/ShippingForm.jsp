<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
<a href =""></a>

	<table>
		<tr>
			<th colspan=2>Shipping Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><c:out value="order.shipToFirstName" /></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><c:out value="order.shipToLastName" /></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><c:out value= size="40" name="order.shipAddress1" /></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><c:out value= size="40" name="order.shipAddress2" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><c:out value="order.shipCity" /></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><c:out size="4" value="order.shipState" /></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><c:out size="10" value="order.shipZip" /></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><c:out size="15" value="order.shipCountry" /></td>
		</tr>


	</table>

	<input type ="button" name="newOrder" value="Continue" />

</div>

<%@ include file="../common/IncludeBottom.jsp"%>