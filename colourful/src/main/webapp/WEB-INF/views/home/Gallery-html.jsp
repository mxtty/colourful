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
			/*
			 *  Simple image gallery. Uses default settings
			 */

			$('.plus').fancybox();




		});
	</script>



<!--==============================content================================-->
       <div class="block-4 col-3">
        	<div class="h2">
       			<h2 class="h2-line-2">我们的相册:</h2>
            </div>

<div align="center">
					<a class="plus" href="image/imageDisplay/gallery-2-big.jpg" data-fancybox-group="gallery" title="大堂">
					  <img class="img-border-gallery" src="image/imageDisplay/gallery-2.jpg">
					</a>
	
					<a class="plus" href="image/imageDisplay/gallery-3-big.jpg" data-fancybox-group="gallery" title="厨房">
					  <img class="img-border-gallery" src="image/imageDisplay/gallery-3.jpg">
					</a>
					<a class="plus" href="image/imageDisplay/gallery-4-big.jpg" data-fancybox-group="gallery" title="厨房">
					  <img  class="img-border-gallery" src="image/imageDisplay/gallery-4.jpg">
					</a>


					<a class="plus" href="image/imageDisplay/gallery-2-big.jpg" data-fancybox-group="gallery" title="大堂">
					  <img class="img-border-gallery" src="image/imageDisplay/gallery-2.jpg">
					</a>
					<a class="plus" href="image/imageDisplay/gallery-3-big.jpg" data-fancybox-group="gallery" title="厨房">
					  <img class="img-border-gallery" src="image/imageDisplay/gallery-3.jpg">
					</a>
					<a class="plus" href="image/imageDisplay/gallery-4-big.jpg" data-fancybox-group="gallery" title="厨房">
					  <img class="img-border-gallery" src="image/imageDisplay/gallery-4.jpg">
					</a>
					<a class="plus" href="image/imageDisplay/gallery-5-big.jpg" data-fancybox-group="gallery" title="厨房">
					  <img class="img-border-gallery" src="image/imageDisplay/gallery-5.jpg">
					</a>
										<a class="plus" href="image/imageDisplay/gallery-6-big.jpg" data-fancybox-group="gallery" title="厨房">
					  <img class="img-border-gallery" src="image/imageDisplay/gallery-6.jpg">
					</a>
										<a class="plus" href="image/imageDisplay/gallery-7-big.jpg" data-fancybox-group="gallery" title="厨房">
					  <img class="img-border-gallery" src="image/imageDisplay/gallery-7.jpg">
					</a>
										<a class="plus" href="image/imageDisplay/gallery-8-big.jpg" data-fancybox-group="gallery" title="厨房">
					  <img class="img-border-gallery" src="image/imageDisplay/gallery-8.jpg">
					</a>
										<a class="plus" href="image/imageDisplay/gallery-9-big.jpg" data-fancybox-group="gallery" title="厨房">
					  <img class="img-border-gallery" src="image/imageDisplay/gallery-9.jpg">
					</a>
</div>
        </div>
