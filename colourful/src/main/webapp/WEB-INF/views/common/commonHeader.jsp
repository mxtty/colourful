<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--==============================header=================================-->
<header>
	<div  class="navbar">
		<nav class="navbar cl-effect-21">
			<a class="basket-summary" href="cart/Cart">购物车</a>
			<a href="#">退出</a>
			<a href="account/SignOn">登录</a>
			<a href="account/RegisterUser">注册新用户</a>
		</nav>
	</div>
    <h1><a href="index.html"><img src="<c:url value = "/resources/images/logo1.jpg"/>"></a></h1>
    <nav>  
        <ul class=fancyNav>
            <li><a href="home">首页</a></li>
            <li  class="selected"><a href="catalog">在线订餐</a></li>
            <li><a href="home/Menu">菜单</a></li>
            <li><a href="home/Philosophy">经营理念</a></li>
            <li><a href="home/Gallery">相册</a></li>
            <li><a href="home/Access">本店位置</a></li>
            <li><a href="account/MyAccount">用户中心</a></li>
        </ul>
        <div class="clear"></div>
     </nav>
</header>
