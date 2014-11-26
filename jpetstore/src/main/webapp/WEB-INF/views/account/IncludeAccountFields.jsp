<h3>Account Information</h3>

<table>
	<tr>
		<td>First name:</td>
		<td><c:out value="account.firstName" /></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><c:out value="account.lastName" /></td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><c:out size="40" value="account.email" /></td>
	</tr>
	<tr>
		<td>Phone:</td>
		<td><c:out value="account.phone" /></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><c:out size="40" value="account.address1" /></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><c:out size="40" value="account.address2" /></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><c:out value="account.city" /></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><c:out size="4" value="account.state" /></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><c:out size="10" value="account.zip" /></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><c:out size="15" value="account.country" /></td>
	</tr>
</table>

<h3>Profile Information</h3>

<table>
	<tr>
		<td>Language Preference:</td>
		<td>
		 
		<rb:defineCodeList id="languages" />
		<form:select path="cardType">
               <form:option label="選択してください" value="" selected="selected"/>
               <form:options items="${languages}"/>
         </form:select>
		</td>
	</tr>
	<tr>
		<td>Favourite Category:</td>
		<td><form:select name="account.favouriteCategoryId">
			<form:options collection="${actionBean.categories}" />
		</form:select></td>
	</tr>
	<tr>
		<td>Enable MyList</td>
		<td><input type="checkbox" name="account.listOption" /></td>
	</tr>
	<tr>
		<td>Enable MyBanner</td>
		<td><input type="checkbox" name="account.bannerOption" /></td>
	</tr>

</table>
