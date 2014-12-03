<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--==============================header=================================-->
<header>
	<div  class="navbar">
		<nav class="navbar cl-effect-21">
			<a class="basket-summary" href="#">购物车</a>
			<a href="#">退出</a>
			<a href="#">登录</a>
			<a href="#">注册新用户</a>
		</nav>
	</div>
    <h1><a href="index.html"><img src="<c:url value = "/resources/images/logo1.jpg"/>"></a></h1>
    <nav>  
        <ul class=fancyNav>
            <li><a href="index.html">首页</a></li>
            <li  class="selected"><a href="registerUser">在线订餐</a></li>
            <li><a href="wine_list.html">菜单</a></li>
            <li><a href="cookbook.html">cookbook</a></li>
            <li><a href="gallery.html">相册</a></li>
            <li><a href="contacts.html">客户留言</a></li>
            <li><a href="contacts.html">用户中心</a></li>
        </ul>
        <div class="clear"></div>
     </nav>
</header>
