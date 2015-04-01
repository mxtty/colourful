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
<link rel="StyleSheet" href="<c:url value = "/resources/css/skel.css"/>" type="text/css" media="screen" />
<link rel="StyleSheet" href="<c:url value = "/resources/css/style.css"/>" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value = "/resources/css/style-desktop.css"/>" type="text/css" media="screen" />

<link rel="stylesheet" href="<c:url value = "/resources/css/style-noscript.css"/>" type="text/css" media="screen" >



<script src="<c:url value = "/resources/js/jquery-1.11.1.min.js"/>"></script>
<script src="<c:url value = "/resources/js/jquery.poptrox.min.js"/>"></script>
<script src="<c:url value = "/resources/js/skel.min.js"/>"></script> 
<script src="<c:url value = "/resources/js/init.js"/>"></script>

</head>

<body>

<div class="bg-top">
<div class="bgr">

			<div id="main">
				<div id="reel">

					
					<!-- Thumb Items -->


						

					<!-- Filler Thumb Items (just for demonstration purposes) -->
						<article class="item thumb" data-width="476"><h2>Kingdom of the Wind</h2><a href="/colourful/image/imageDisplay/fulls_f_01.jpg"><img src="/colourful/image/imageDisplay/thumbs_t_01.jpg"></a></article>
						<article class="item thumb" data-width="232"><h2>The Pursuit</h2><a href="/colourful/image/imageDisplay/fulls_f_02.jpg"><img src="/colourful/image/imageDisplay/thumbs_t_02.jpg"></a></article>
						<article class="item thumb" data-width="352"><h2>Boundless</h2><a href="/colourful/image/imageDisplay/fulls_f_03.jpg"><img src="/colourful/image/imageDisplay/thumbs_t_03.jpg"></a></article>
						<article class="item thumb" data-width="348"><h2>The Spectators</h2><a href="/colourful/image/imageDisplay/fulls_f_04.jpg"><img src="/colourful/image/imageDisplay/thumbs_t_04.jpg"></a></article>

				</div>
			</div>

</div>
</div>

</body>
</html>