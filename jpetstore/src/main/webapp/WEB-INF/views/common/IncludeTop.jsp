<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<link rel="StyleSheet" href="<c:url value = "/resources/css/jpetstore.css"/>" type="text/css"
	media="screen" />

<title>JPetStore Demo</title>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<div id="Header">

<div id="Logo">
<div id="LogoContent"><a href="index/home">
	<img src="<c:url value = "/resources/images/logo-topbar.gif"/>" />
</a>
</div>
</div>

<div id="Menu">
<div id="MenuContent">
   <a href="">
       <img align="middle" name="img_cart" src="<c:url value = "/resources/images/cart.gif"/>" />
   </a>
<img align="middle" src="<c:url value = "/resources/images/separator.gif"/>" />

<sec:authorize access="isAnonymous()">
		<a href="auth/login">
            Sign In
        </a>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_USER')">
		<a href = "auth/logout">
            Sign Out
		</a>
		<img align="middle" src="<c:url value = "/resources/images/separator.gif"/>" />
		<a href ="">
            My Account
	      </a>
</sec:authorize>

 <img align="middle" src="<c:url value = "/resources/images/separator.gif"/>" /> <a
	href="../../../help.html">?</a></div>
</div>

<div id="Search">
<div id="SearchContent"><a href =""></a>
	<c:out value="keyword" />
	<input type ="button" name="searchProducts" value="Search" />
</div>
</div>

<div id="QuickLinks">
	<a href="">
		<img src="<c:url value = "/resources/images/sm_fish.gif"/>" />
	</a>
	
	<img src="<c:url value = "/resources/images/separator.gif"/>" /> 
	<a href="">
		<img src="<c:url value = "/resources/images/sm_dogs.gif"/>" />
	</a>
	
	<img src="<c:url value = "/resources/images/separator.gif"/>" />
	<a href="">
		<img src="<c:url value ="/resources/images/sm_reptiles.gif"/>" />
	</a>
	
	<img src="<c:url value = "/resources/images/separator.gif"/>" />
	<a href="">
		<img src="<c:url value = "/resources/images/sm_cats.gif"/>" />
	</a>
	
	<img src="<c:url value = "/resources/images/separator.gif"/>" />
	<a href="">
		<img src="<c:url value = "/resources/images/sm_birds.gif"/>" />
	</a>

</div>

</div>
