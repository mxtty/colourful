<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="col-10">
<h3 class="h3-line">注册新用户</h3>
<form:form id="add_user_form" method="post"  modelAttribute="registerUserForm" action="user/register">
   <fieldset>
     <label><strong class="right width-15">用户ID:</strong><form:input path="userId" class="width25" required="required"/><form:errors path="userId" class="errormsg" /><strong class="float-left">4-20位字母，数字，连字符（-），下划线（_）组合</strong></label>
     <label><strong class="right width-15">用户姓名:</strong><form:input path="realName" class="width25" /><form:errors path="realName" class="errormsg" /><strong class="float-left">送餐联系人</strong></label>
     <label><strong class="right width-15">密码:</strong><form:password path="passwd"  class="width25"/><form:errors path="passwd" class="errormsg" /><strong class="float-left">4-20位字母，数字，字母，符号组合</strong></label>
     <label><strong class="right width-15">密码确认:</strong><form:password path="passwdConfirm" class="width25"/><form:errors path="passwdConfirm" class="errormsg" /></label>
     <label><strong class="right width-15">电话:</strong><form:input path="phone" class="width25"/><form:errors path="phone" class="errormsg" /><strong class="float-left">联系人常用电话</strong></label>
     <label><strong class="right width-15">手机:</strong><form:input path="cellPhone" class="width25"/><form:errors path="cellPhone" class="errormsg" /><strong class="float-left">联系人手机号码</strong></label>
     <label><strong class="right width-15">电子邮箱:</strong><form:input path="email" class="width25"/><form:errors path="email" class="errormsg" /><strong class="float-left">可用邮箱登陆，也用于找回密码</strong></label>
     <label><strong class="right width-15">邮编:</strong><form:input path="zip" class="width25"/><form:errors path="zip" class="errormsg" /></label>
     <label><strong class="right width-15">地址:</strong><form:textarea  path="address"  cols="35" rows="4" class="width30" maxlength="200"/><form:errors path="userId" class="errormsg" /></label>
    </fieldset>
   <label ><strong class="left-25" id="lb1"><a class="myButton width-8" >注册新用户</a></strong></label>
</form:form>
</div>
