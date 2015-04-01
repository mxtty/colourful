<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="rb" uri="/WEB-INF/tlds/rainbow.tld"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  

<!DOCTYPE html>
<html>
<head>
<title><tiles:insertAttribute name="title"/></title>
<link rel="StyleSheet" href="<c:url value = "/resources/css/reset.css"/>" type="text/css" media="screen" />
<link rel="StyleSheet" href="<c:url value = "/resources/css/style.css"/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value = "/resources/css/navistyles.css"/>" type="text/css" media="screen" />
<%-- <link rel="StyleSheet" href="<c:url value = "/resources/css/slider.css"/>" type="text/css" media="screen" /> --%>

<script src="<c:url value = "/resources/js/jquery-1.11.1.min.js"/>"></script>
<script src="<c:url value = "/resources/js/jquery.easing.1.3.js"/>"></script>
<%-- <script src="<c:url value = "/resources/js/tms-0.4.1.js"/>"></script> --%>
<script src="<c:url value = "/resources/js/colour.js"/>"></script>

<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<!--    <script>
		$(document).ready(function(){				   	
			$('.slider')._TMS({
				show:0,
				pauseOnHover:true,
				prevBu:false,
				nextBu:false,
				playBu:false,
				duration:700,
				preset:'fade',
				pagination:true,
				pagNums:false,
				slideshow:1000,
				numStatus:false,
				banners:false,
				waitBannerAnimation:false,
				progressBar:false
			})		
		});
	</script> -->
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
<tiles:insertAttribute name="commonHeader"/>
<tiles:insertAttribute name="body" />
<tiles:insertAttribute name="footer" />
</div>
</div>

</body>
</html>