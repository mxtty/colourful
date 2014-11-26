<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<%@ include file="../common/IncludeTop.jsp"%>
</head>
<body>

<div id="BackLink"><a href ="">
	Return to ${product.productId}
</a></div>

<div id="Catalog">

<table>
	<tr>
		<td>${product.description}</td>
	</tr>
	<tr>
		<td><b> ${item.itemId} </b></td>
	</tr>
	<tr>
		<td><b><font size="4"> ${item.attribute1}
		${item.attribute2} ${item.attribute3}
		${item.attribute4} ${item.attribute5}
		${product.name} </font></b></td>
	</tr>
	<tr>
		<td>${product.name}</td>
	</tr>
	<tr>
		<td><c:if test="${item.quantity <= 0}">
        Back ordered.
      </c:if> <c:if test="${item.quantity > 0}">
      	${item.quantity} in stock.
	  </c:if></td>
	</tr>
	<tr>
		<td><fmt:formatNumber value="${item.listPrice}"
			pattern="$#,##0.00" /></td>
	</tr>

	<tr>
		<td><a href ="">
       	Add to Cart
       </a></td>
	</tr>
</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>
</body>
</html>


