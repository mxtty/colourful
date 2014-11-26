<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog"><a href =""></a>

	<h3>User Information</h3>

	<table>
		<tr>
			<td>User ID:</td>
			<td><c:out value="username" /></td>
		</tr>
		<tr>
			<td>New password:</td>
			<td><c:out value="password" /></td>
		</tr>
		<tr>
			<td>Repeat password:</td>
			<td><c:out value="repeatedPassword" /></td>
		</tr>
	</table>

	<%@ include file="IncludeAccountFields.jsp"%>

	<input type ="button" name="newAccount" value="Save Account Information" />

</div>

<%@ include file="../common/IncludeBottom.jsp"%>