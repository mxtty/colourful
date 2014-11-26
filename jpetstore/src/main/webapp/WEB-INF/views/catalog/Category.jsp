<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<%@ include file="../common/IncludeTop.jsp"%>
</head>
<body>
<div id ="Main">
<div id="Catalog">

<h2>${actionBean.category.name}</h2>

<table>
	<tr>
		<th>Product ID</th>
		<th>Name</th>
	</tr>
	<c:forEach var="product" items="${productList}">
		<tr>
			<td><a href ="product/detail/${product.productId}">
				${product.productId}
			</a></td>
			<td>${product.name}</td>
		</tr>
	</c:forEach>
</table>

</div>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>
</body>
</html>
