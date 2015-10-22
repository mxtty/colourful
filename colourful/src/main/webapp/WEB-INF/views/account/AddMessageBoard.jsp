<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<p id ="navId" class ="accountNav">

<div class="col-10">
<h3 class="h3-line">用户留言</h3>

<form:form id="add_message_board" method="post"  modelAttribute="messageBoardForm" action="account/AddMessageBoardDone">
   <fieldset>
     <label><strong class="right width-15">标题:</strong><form:input path="title" class="width300" required="required" placeholder="请输入标题"/><form:errors path="title" class="errormsg float-left" /></label>

	 <sec:authorize access="isAnonymous()">
       <label><strong class="right width-15">姓名:</strong><form:input path="userName" class="width300" placeholder="用户姓名"/><form:errors path="userName" class="errormsg" /></label>
       <label><strong class="right width-15">电话:</strong><form:input path="phone" class="width300" placeholder="联系人常用电话[可选]"/><form:errors path="phone" class="errormsg" /><strong class="float-left"></strong></label>
       <label><strong class="right width-15">邮箱:</strong><form:input path="email" class="width300" placeholder="电子邮箱，用于对于您的意见或投诉内容回复"/><form:errors path="email" class="errormsg" /></label>
     </sec:authorize>

     <label><strong class="right width-15">内容:</strong><form:textarea  path="contents"  cols="65" rows="4" class="width20" maxlength="200"  placeholder="我要留言"/><form:errors path="contents" class="errormsg" /></label>
   </fieldset>
   <label ><strong class="left-25" id="lb1"><a class="myButton width-8" >提交留言</a></strong></label>
</form:form>
</div>
