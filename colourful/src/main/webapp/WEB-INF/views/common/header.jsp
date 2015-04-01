<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!--==============================header=================================-->
<header>
	<div  class="navbar">
		<nav class="navbar cl-effect-21">
			<a class="basket-summary" href="cart/Cart">购物车</a>
            <sec:authorize access="hasRole('ROLE_USER')">
			   <b><sec:authentication property="principal.realName" />，您好!</b>
			   <a href="processLogout">退出</a>
			</sec:authorize>
			<sec:authorize access="isAnonymous()">
               <a href="account/SignOn">登录</a>
			   <a href="account/RegisterUser">注册新用户</a>
            </sec:authorize>
		</nav>
	</div>
    <h1><a href="home"><img src="/colourful/resources/images/logo1.jpg"></a></h1>
    <nav>  
        <ul class="fancyNav">
            <li id="homeNav" class = ""><a href="home">首页</a></li>
            <li id="catalogNav" ><a href="catalog">在线订餐</a></li>
            <li id="menuNav"><a href="home/Menu">菜单</a></li>
            <li id="philosophyNav"><a href="home/Philosophy">经营理念</a></li>
            <li id="galleryNav"><a href="home/Gallery">相册</a></li>
            <li id="accessNav"><a href="home/Access">本店位置</a></li>
            <li id="accountNav"><a href="account/MyAccount">用户中心</a></li>
        </ul>
        
     </nav>
</header>
