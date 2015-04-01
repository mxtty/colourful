<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
$(function() {
  $('#date').datepicker({ dateFormat: 'yy/mm/dd' });
});
</script>
<p id ="navId" class ="catalogNav">

<!--==============================content================================-->
        <div class="col-10">
        	<h3 class="h3-line">送货信息</h3>
			<form:form id ="ship_form" method="post" action="order/OrderFinish" modelAttribute="orderEntryForm">
              <fieldset>
                <label><strong class="right width-10">联系人:</strong><form:input path="shipName" class="width250"  placeholder="请输入联系人姓名"/><form:errors path="shipName" class="errormsg float-left" /></label>
                <label><strong class="right width-10">电话:</strong><form:input  path="phone" class="width250" placeholder="请输入联系人电话"/><form:errors path="phone" class="errormsg float-left" /></label>
                <label><strong class="right width-10">送货日期:</strong><form:input id="date" path="shipDate" class="width250" placeholder="请输入送货时间"/><form:errors path="shipDate" class="errormsg float-left" /></label>
                <label><strong class="right width-10">送货地点:</strong><form:textarea path="shipAddress" cols="35" rows="4" class="width250" maxlength="200" placeholder="请输入送货地点"></form:textarea><form:errors path="shipAddress" class="errormsg float-left" /></label>
               </fieldset>  
                <label><strong class="left-25"><a class="myButton width-8" >提交订单</a></strong></label> 
			 </form:form> 
       </div>