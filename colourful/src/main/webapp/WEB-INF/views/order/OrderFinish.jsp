<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p id ="navId" class ="catalogNav">
<!--==============================content================================-->
<div class="col-5">
	<h3 class="h3-line">订单完成</h3>
	<form:form id ="ship_form" method="post" action="cart/orderFinish" modelAttribute="orderEntryForm">
    <div id="orderFinish" class="info-detail" >
          <label><strong class="right width-10">订单号:</strong><strong class="left width-10"><a href="cart/ViewOrder/${orderEntryForm.orderId}">${orderEntryForm.orderId}</a></strong></label>
          <label><strong class="right width-10">联系人:</strong><strong class="left width-10">${orderEntryForm.shipName}</strong></label>
          <label><strong class="right width-10">电话:</strong><strong class="left width-10">${orderEntryForm.phone}</strong></label>
          <label><strong class="right width-10">送货时间:</strong><strong class="left width-10">${orderEntryForm.shipDate}</strong></label>
          <label><strong class="right width-10">送货地点:</strong><strong class="left width-30">${orderEntryForm.shipAddress}</strong></label>
         <label><strong class="left-25"><a href="catalog" class="myButton width-8" >继续选购</a></strong></label>
    </div>
	</form:form>
</div>
