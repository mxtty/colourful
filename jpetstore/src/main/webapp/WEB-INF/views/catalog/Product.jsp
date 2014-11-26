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
<div id ="Main">
<div id="BackLink">
  <a href="">
	Return to ${product.categoryId}
  </a>
</div>

<div id="Catalog">

<h2>${product.name}</h2>

<table>
	<tr>
		<th>Item ID</th>
		<th>Product ID</th>
		<th>Description</th>
		<th>List Price</th>
		<th>&nbsp;</th>
	</tr>
	<c:forEach var="item" items="${itemList}">
		<tr>
			<td><a href="product/item/${item.itemId}" >
				${item.itemId}
				</a>
			</td>
			<td>${item.product.productId}</td>
			<td>${item.attribute1} ${item.attribute2} ${item.attribute3}
			${item.attribute4} ${item.attribute5} ${actionBean.product.name}</td>
			<td><fmt:formatNumber value="${item.listPrice}"
				pattern="$#,##0.00" /></td>
			<td><a href ="cart/add/${item.itemId}/${item.product.productId}">			
        	Add to Cart
        	</a>
            </td>
		</tr>
	</c:forEach>
</table>

</div>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>
</body>
</html>




