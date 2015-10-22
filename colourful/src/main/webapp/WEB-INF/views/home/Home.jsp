<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p id ="navId" class ="homeNav"> 
<header>
       <img src="image/imageDisplay/fulls_${homeContents.sliderFile}" />
       <div class="phone-number">订餐电话:<strong>0991-8881234</strong></div>	
</header>
<section id="content">
<div class="block-2 pad-1">
   <div class="col-1">
   	<h2 class="h2-line">欢迎光临五彩爽口饺子馆!<strong>健康饮食生活，从这里开始</strong></h2>
       <div class="box-1">
       	<div class="img-border img-indent"><img src="image/imageDisplay/thumbs_${homeContents.homeSubImgFile}" /></div>
           <div class="extra-wrap">
           	<p class="it-bold p2">${homeContents.newsletter.title}</p>
               <p class="border-1">${homeContents.newsletter.contents}</p>
               <a href="home/News/${homeContents.newsletter.newsId}" class="link-1">阅读全文</a>
           </div>
        </div>
    </div>
    <div class="col-2 left-2">
    	<h3 class="h3-line top-1">最新信息:</h3>
        <div class="box-2 top-2">
        <c:forEach var="news" items="${homeContents.newsList}">
            <div class="comment border-1">
                <p>
                  <img src="/colourful/resources/images/comment-top.png">
                  <span class="clr-1">${news.title}</span><br>${news.contents}
                  <img src="/colourful/resources/images/comment-bottom.png">
                </p>
                <span class="clr-1"><strong>${news.author}</strong></span>
            </div>
			</c:forEach>
           <!--  <a href="#" class="link-1">更多</a> -->
         </div> 
    </div>
    &nbsp;
    <div class="block-3">
    	<div class="h3">
   			<h3 class="h3-line-2">推荐菜单:</h3>
        </div>
         <div class="box-3">
	        <c:forEach var="productDetail" items="${homeContents.productDetailList}">
	        	<div>
	            	<div class="img-border">
	            	 <a href="product/showProduct/${productDetail.productId}" ><img src="image/imageDisplay/${productDetail.imgFileMain}"></a></div>
	            	<a href="product/showProduct/${productDetail.productId}" class="link"><span class="it-bold ">${productDetail.productName}</span></a>
	            </div>
			</c:forEach>
        </div> 
	</div>
  </div>
</section> 