<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p id ="navId" class ="accountNav">
<!--==============================content================================-->
<div class="col-4 left-2">
	<h3 class="h3-line">我是会员:</h3>
    <form:form id="signOnform" action="processLogin" modelAttribute="registerUserForm" method="post" >
      <fieldset>
       <label><strong class="right width-10">会员帐号:</strong><form:input path="userId" class="left width150" placeholder="请输入会员帐号"></form:input><strong class="clear"></strong></label>
       <label><strong class="right width-10">密码:</strong><form:password path="passwd" class="left width150" placeholder="请输入会员密码"></form:password><strong class="clear"></strong></label>
      </fieldset>  

     <label><strong class="left-18"><a class="myButton width-6">登录</a></strong></label>
     <br><label><strong class="left-12"> <a href="checkout.html" >忘记密码?</a> &nbsp;&nbsp;&nbsp;<a href="registerUser.html" >立即注册新用户</a></strong></label>
     
    </form:form>
</div>
