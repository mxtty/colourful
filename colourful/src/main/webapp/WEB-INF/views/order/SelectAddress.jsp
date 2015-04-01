<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<p id ="navId" class ="catalogNav">
<!--==============================content================================-->
  <div class="block-4 col-3">
	<form:form id ="ship_form" method="post" action="order/MakeOrder" modelAttribute="orderEntryForm">
     <div class="h2"><h2 class="h2-line-2">请选择地址</h2></div>
	 	<div class="rainbow-table ">
    	  <ul class="steps">
	    	<li>
		     <form:radiobuttons path="selectedAddressIdx" items="${orderEntryForm.optionAddressList}" itemLabel="addressInfo" itemValue="addressIdx" delimiter="&nbsp;" width="300"/>
		    </li>
	      </ul>
	 </div>
	 
	 <label><strong class="left-25"><a class="myButton width-8" >确定</a></strong></label>
    </form:form>
  </div>   
    
