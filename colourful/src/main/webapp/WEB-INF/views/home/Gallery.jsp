<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script src="<c:url value = "/resources/js/jquery.jcarousel.min.js"/>"></script>
<%-- <script src="<c:url value = "/resources/js/jquery.fancybox-1.3.4.pack.js"/>"></script> --%>
<script src="<c:url value = "/resources/js/jquery.fancybox.js?v=2.1.5"/>"></script>
<script src="<c:url value = "/resources/js/jquery.mousewheel-3.0.6.pack.js"/>"></script>

<link rel="stylesheet" type="text/css" media="screen" href="<c:url value = "/resources/css/skin-2.css"/>">
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value = "/resources/css/jquery.fancybox.css?v=2.1.5"/>">
    
	<script type="text/javascript">
		$(document).ready(function() {

		/* 	$('.plus').fancybox(); */
			$(".plus").fancybox({
				padding: 0,

				openEffect : 'elastic',
				openSpeed  :350,

				closeEffect : 'elastic',
				closeSpeed  : 350,

				closeClick : true,

				helpers : {
					overlay : null
				}
			});
		});
	</script>


<p id ="navId" class ="galleryNav">
<!--==============================content================================-->
       <div class="block-4 col-3">
        	<div class="h2">
       			<h2 class="h2-line-2">我们的相册:</h2>
            </div>
			<div align="center">
		 		<c:forEach var="image" items="${imageList}">					
					<a class="plus" href="image/imageDisplay/fulls_${image.imageFile}" data-fancybox-group="gallery" title="${image.note}">
					  <img class="img-border-gallery" src="image/imageDisplay/thumbs_${image.imageFile}">
					</a>
				</c:forEach>
			</div>
      </div>
