<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="rb" uri="/WEB-INF/tlds/rainbow.tld"%>

<!DOCTYPE html>
<html>
<head>

<link rel="StyleSheet" href="<c:url value = "/resources/css/reset.css"/>" type="text/css" media="screen" />
<link rel="StyleSheet" href="<c:url value = "/resources/css/style.css"/>" type="text/css" media="screen" />

    <script src="<c:url value = "/resources/js/jquery-1.11.1.min.js"/>"></script>
    <script src="<c:url value = "/resources/js/jquery.easing.1.3.js"/>"></script>
	<!--[if lt IE 8]>
       <div style=' clear: both; text-align:center; position: relative;'>
         <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
           <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
        </a>
      </div>
    <![endif]-->
    <!--[if lt IE 9]>
   		<script type="text/javascript" src="js/html5.js"></script>
    	<link rel="stylesheet" type="text/css" media="screen" href="css/ie.css">
	<![endif]-->
</head>
<body>


<div class="bg-top">
<div class="bgr">
  <!--==============================header=================================-->
    <header>
        <h1><a href="index.html"><img src="<c:url value = "/resources/images/logo1.jpg"/>" alt=""></a></h1>
        <nav>  
            <ul class="menu">
                <li><a href="index.html">首页1</a></li>
                <li class="current"><a href="cuisine.html">在线订餐</a></li>
                <li><a href="wine_list.html">菜单</a></li>
                <li><a href="cookbook.html">cookbook</a></li>
                <li><a href="gallery.html">相册</a></li>
                <li><a href="contacts.html">客户留言</a></li>
                <li><a href="contacts.html">用户中心</a></li>
            </ul>
            <div class="clear"></div>
         </nav>
    </header> 
  <!--==============================content================================-->
    <section id="content">
       <div class="block-2 pad-2">
        <div class="col-5">
        	<h3 class="h3-line">注册新用户</h3>
    <form:form id="form" method="post"  modelAttribute="registerUserForm" action="registerUser/confirm">
	<form:errors path="*" cssClass="errorblock" element="div" />
              <fieldset>
                <label><strong class="right width-10">联系人:</strong><input type="text" value="" class="width25" placeholder="请输入联系人姓名"><strong class="clear"></strong></label>
                <label><strong class="right width-10">电话:</strong><input type="text" value="" class="width25" placeholder="请输入联系人电话"><strong class="clear"></strong></label>
                <label><strong class="right width-10">送货时间:</strong><input type="text" value="" class="width25" placeholder="请输入送货时间"><strong class="clear"></strong></label>
                <label><strong class="right width-10">送货地点:</strong><textarea  cols="35" rows="4" class="width30" maxlength="200" placeholder="请输入送货地点"></textarea><strong class="clear"></strong></label>
               </fieldset>  
              <label><strong class="left-25"><a href="order.html" class="myButton width-8" >注册新用户</a></strong></label>
   </form:form>
        </div>
	  </div>
    </section>  

<!--==============================footer=================================-->
  <footer>
      <p>© 2014  五彩爽口饺子<br>

  </footer>	

</div>
</div>

</body>
</html>