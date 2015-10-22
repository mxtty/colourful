<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="StyleSheet" href="<c:url value = "/resources/css/table.css"/>" type="text/css" media="screen" />

<p id ="navId" class ="catalogNav">
<!--==============================content================================-->
  <div class="block-4 col-3">

   <div class="h2"><h2 class="h2-line-2">订单列表</h2></div>
   <div class="table">
    <div class="row header blue">
      <div class="cell60">订单号</div>
      <div class="cell60">收货人</div>
      <div class="cell">联系电话</div>
      <div class="cell">送货地址</div>
      <div class="cell">签收</div>
    </div>
    
    <c:forEach var="order" items="${orderList}" varStatus="status">    
    <div class="row">
      <div class="cell60"><a href="order/ViewOrder/${order.cartId}/${order.orderId}">${order.orderId}</a></div>
      <div class="cell60"><c:out value="${order.shipName}"/></div>
      <div class="cell"><c:out value="${order.phone}"/></div>
<%--       <div class="cell"><c:out value="${order.prductsName}"/></div> --%>
      <div class="cell"><c:out value="${order.shipAddress}"/></div>
<%--       <div class="cell60"><fmt:formatNumber value="${order.totalPrice}" pattern="¥###0.00" /></div> --%>
      <c:if test="${0==order.status}">
        <div class="cell"><a href="order/Sign/${order.orderId}" class="myLink">签收</a></div>
      </c:if>
      <c:if test="${0!=order.status}">
        <div class="cell">${order.status}</div>
      </c:if>
    </div>
	</c:forEach>

  </div>
</div>   
    
