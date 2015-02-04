<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--==============================content================================-->
<div class="block-category col-3">

<div class="box-category border-3">
<c:forEach var="category" items="${categories}">
	<div>
		<h4>${category.categoryName}</h4>
		<div class="img-border"><a href="catalog/<c:url value="${category.categoryId}"/>"> <img width="80px" src="image/imageDisplay/${category.imgFile}" /></a></div>
		<div class="catetoryDesc">${category.description}</div>
	</div>
</c:forEach>
</div>

</div>