<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<p id ="navId" class ="accountNav">
<div class="col-10">
<sec:authorize access="isAnonymous()">
<h3 class="h3-line">注册新用户</h3>

<form:form id="add_user_form" method="post"  modelAttribute="registerUserForm" action="account/RegisterDone">
   <fieldset>
     <label><strong class="right width-15">用户ID:</strong><form:input path="userId" class="width250" required="required" placeholder="4-20位。 可用字符(字母，数字，- ，_ )"/><form:errors path="userId" class="errormsg float-left" /></label>
     <label><strong class="right width-15">用户姓名:</strong><form:input path="realName" class="width250" placeholder="送餐联系人"/><form:errors path="realName" class="errormsg" /></label>
     <label><strong class="right width-15">密码:</strong><form:password path="passwd"  class="width250" placeholder="4-20位。 可用字符[字母，数字，符号]"/><form:errors path="passwd" class="errormsg" /></label>
     <label><strong class="right width-15">密码确认:</strong><form:password path="passwdConfirm" class="width250" placeholder="再次输入与上面相同的密码"/><form:errors path="passwdConfirm" class="errormsg" /></label>
     <label><strong class="right width-15">电话:</strong><form:input path="phone" class="width250" placeholder="联系人常用电话[可选]"/><form:errors path="phone" class="errormsg" /><strong class="float-left"></strong></label>
     <label><strong class="right width-15">手机:</strong><form:input path="cellPhone" class="width250" placeholder="联系人手机号码"/><form:errors path="cellPhone" class="errormsg" /></label>
     <label><strong class="right width-15">电子邮箱:</strong><form:input path="email" class="width250" placeholder="可用邮箱登陆，也用于找回密码"/><form:errors path="email" class="errormsg" /></label>
     <label><strong class="right width-15">邮编:</strong><form:input path="zip" class="width250" placeholder="邮政编码"/><form:errors path="zip" class="errormsg" /></label>
     <label><strong class="right width-15">地址:</strong><form:textarea  path="address"  cols="55" rows="4" class="width30" maxlength="200"  placeholder="常用送货地址"/><form:errors path="address" class="errormsg" /></label>
    </fieldset>
   <label ><strong class="left-25" id="lb1"><a class="myButton width-8" >注册新用户</a></strong></label>
</form:form>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_USER')">
    <h3 class="h3-line"><sec:authentication property="principal.realName" />，您好!<br>您已经登录成功，如需注册新用户，请<a href="processLogout">退出</a>登录。</h3> 
</sec:authorize>
</div>
