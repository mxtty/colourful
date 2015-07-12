<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="StyleSheet" href="<c:url value = "/resources/css/select-address.css"/>" type="text/css" media="screen" />
<p id ="navId" class ="catalogNav">
<!--==============================content================================-->
  <div class="block-4 col-3">
	
     <div class="h2"><h2 class="h2-line-2">请选择地址</h2></div>
  </div>   
<form:form id ="ship_form" method="post" action="order/MakeOrder" modelAttribute="orderEntryForm">
<div id="address-table" class="clear">
  <c:forEach var="address" items="${orderEntryForm.optionAddressList}" varStatus="status">
    <div class="plan" >
        <h3>收件人<span>${address.userName}</span></h3>
        <a class="myButton width-8" href="<c:url value="order/MakeOrder/${status.index}"/>"> 送到这里</a>
        <ul>
            <li><b>邮政编码:</b> ${address.zip}</li>
            <li><b>送货地址:</b> ${address.address}</li>
            <li><b>手机号码:</b> ${address.cellPhone}</li>
            <li><b>联系电话:</b> ${address.phone}</li>
        </ul> 
    </div>
  </c:forEach>
</div> 
</form:form>
