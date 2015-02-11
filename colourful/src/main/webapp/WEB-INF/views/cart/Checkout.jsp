<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--==============================content================================-->
        <div class="col-5">
        	<h3 class="h3-line">送货信息</h3>
			<form:form id ="ship_form" method="post" action="order/newOrder" modelAttribute="orderEntryForm">
              <fieldset>
                <label><strong class="right width-10">联系人:</strong><form:input path="shipName" class="width250" placeholder="请输入联系人姓名"/><strong class="clear"></strong></label>
                <label><strong class="right width-10">电话:</strong><form:input  path="phone" class="width250" placeholder="请输入联系人电话"/><strong class="clear"></strong></label>
                <label><strong class="right width-10">送货时间:</strong><form:input  path="" class="width250" placeholder="请输入送货时间"/><strong class="clear"></strong></label>
                <label><strong class="right width-10">送货地点:</strong><form:textarea path="" cols="35" rows="4" class="width250" maxlength="200" placeholder="请输入送货地点"></form:textarea><strong class="clear"></strong></label>
               </fieldset>  
	
                <label><strong class="left-25"><a class="myButton width-8" >提交订单</a></strong></label> 
			 </form:form> 

        </div>
        <div class="col-4 left-2">
        	<h3 class="h3-line">我是会员:</h3>
            <form id="form" method="post" >
              <fieldset>
                <label><strong class="right width-10">会员帐号:</strong><input type="text" value="" class="left width150" placeholder="请输入会员帐号"><strong class="clear"></strong></label>
                <label><strong class="right width-10">密码:</strong><input type="text" value="" class="left width150" placeholder="请输入会员密码"><strong class="clear"></strong></label>
               </fieldset>  
	
                <label><strong class="left-18"><a href="order.html" class="myButton width-6">登录</a></strong></label>
                <br><label><strong class="left-12"> <a href="checkout.html" >忘记密码?</a> &nbsp;&nbsp;&nbsp;<a href="registerUser.html" >立即注册新用户</a></strong></label>
			   </form> 

	    </div>
