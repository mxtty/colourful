<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<p id ="navId" class ="accountNav">
<!--==============================content================================-->
<div class="col-10">
<h3 class="h3-line">用户中心</h3>
<br><br>
<div id="orderFinish" >
      <label>
           <a href="account/AddMessageBoard" class="btn width-8">&nbsp;&nbsp;&nbsp;我要留言&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
<!--            <a href="account/SignOn" class="btn">&nbsp;&nbsp;&nbsp;留言履历&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp; -->
	       <sec:authorize access="isAnonymous()">
             <a href="account/SignOn" class="btn">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
             <a href="account/RegisterUser" class="btn">&nbsp;&nbsp;注册新用户&nbsp;&nbsp;</a>
           </sec:authorize>
      </label>
      <br><br><br><br>
      <label>
           <sec:authorize access="hasRole('ROLE_USER')">
<!--              <a href="account/SignOn" class="btn">&nbsp;&nbsp;&nbsp;购买履历&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp; -->
<!--              <a href="account/SignOn" class="btn">&nbsp;&nbsp;&nbsp;我的积分&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp; -->
             <a href="account/SignOn" class="btn width-8">&nbsp;&nbsp;&nbsp;密码变更&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
           </sec:authorize>
      </label>
</div>

</div>
