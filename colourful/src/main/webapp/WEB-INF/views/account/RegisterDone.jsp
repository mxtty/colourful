<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--==============================content================================-->
   <section id="content">
     <div class="block-2 pad-2">
       <div class="col-10">
       	<h3 class="h3-line">新用户<c:out value="${registerUserForm.realName}"/>注册成功</h3>
		   <form:form id="form" method="post"  modelAttribute="registerUserForm" action="registerUser/register">
		             <fieldset>
		               <label><strong class="right width-15">用户ID:</strong><strong class="left"><c:out value="${registerUserForm.userId}"/></strong></label>
		               <label><strong class="right width-15">用户姓名:</strong><strong class="left"><c:out value="${registerUserForm.realName}"/></strong></label>
		               <label><strong class="right width-15">电话:</strong><strong class="left"><c:out value="${registerUserForm.phone}"/></strong></label>
		               <label><strong class="right width-15">手机:</strong><strong class="left"><c:out value="${registerUserForm.cellPhone}"/></strong></label>
		               <label><strong class="right width-15">邮编:</strong><strong class="left"><c:out value="${registerUserForm.zip}"/></strong></label>
		               <label><strong class="right width-15">地址:</strong><strong class="left"><c:out value="${registerUserForm.address}"/></strong></label>
		
		              </fieldset>  
		             <label><strong class="left-25"><a href="registerUser" class="myButton width-8" >继续购物</a></strong></label>
		  </form:form>
       </div>
     </div>
</section> 
