<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<link rel="StyleSheet" href="<c:url value = "/resources/css/cart.css"/>" type="text/css" media="screen" />
<link rel="StyleSheet" href="<c:url value = "/resources/css/bootstrap.min.css"/>" type="text/css" media="screen" />
<script src="<c:url value = "/resources/js/bootstrap-number-input.js"/>"></script>

<%-- <script src="<c:url value = "/resources/js/cart.js"/>"></script> --%>
<p id ="navId" class ="catalogNav">
<!--==============================content================================-->
<form:form method="post" action="order/Checkout" modelAttribute="cartForm">

       <div class="block-4 col-3">
       <div class="h2">
         <h2 class="h2-line-2">
          <c:if test="${!empty cartForm.productDetailList}">
           我点的菜:
           </c:if>
           <c:if test="${empty cartForm.productDetailList}">
           购物车是空的！<br>
           快来<a href="catalog">在线订餐</a>，选购吧。	
           </c:if>
         </h2>
       </div>

	<div class="box-4 ">

     <ul class="item-list">
     <c:forEach var="product" items="${cartForm.productDetailList}" varStatus="status">
	  <li class="item">
		<div class="item_information">
		  <div class="item_image">
			<img src="image/imageDisplay/${product.imgFileMain}">
		  </div>
		  <div class="item_body">
			<h2 class="item_title"><c:out value="${product.productName}"/></h2>
			<p class="item_description"><c:out value="${product.description}"/></p>
			<form:hidden path="productDetailList[${status.index}].productId" />
		  </div>
		  <div class="item_price js-item-price"><fmt:formatNumber value="${product.unitPrice * product.quantity}" pattern="¥###0.00" /></div>
		</div>
		<div class="item_interactions" id ="interactions">
		  <p class="item_quantity">
			<form:input type="number" path="productDetailList[${status.index}].quantity" value="1" class="inQuantity"  style="width:50px;height:20px;" max="999" min="1"/><form:errors path="productDetailList[${status.index}].quantity" class="errormsg" />
			<c:out value="${product.unit}/每${product.unit}"/>
			<fmt:formatNumber value="${product.unitPrice}" pattern="¥###0.00" />
			<form:hidden path="productDetailList[${status.index}].status" value="0" class = "status"/>
<%-- 			<form:hidden class = "js-unit-price" path="productDetailList[${status.index}].unitPrice" /> --%>
		 </p>
		  <a class="item_remove" title="这次不买"><img height="18" src="<c:url value = "/resources/images/icon_remove.png"/>"></a>
		   <a class="item_delete" title="从购物车清除"><img height="18" src="<c:url value = "/resources/images/icon_delete_3.png"/>"></a> 
		</div>
	  </li>
	</c:forEach>
 
	</ul>

	</div>	

   <c:if test="${!empty cartForm.productDetailList}">
	<div class="summary js-summary">
	  <ul class="steps">
		<li>
		  <b>合计:</b>
		  <span class="sum js-subtotal"><fmt:formatNumber value="${cartForm.total}" pattern="¥###0.00" /></span>
		</li>
		<li>
		  <b>运费:</b>
		  <span class="sum js-shipping"><fmt:formatNumber value="${cartForm.shipping}" pattern="¥###0.00" /></span>
		</li>
	  </ul>
	  <ul class="checkout">
		<li>
		  <b>总计:</b>
		  <span class="sum js-total"><fmt:formatNumber value="${cartForm.total+shipping}" pattern="¥###0.00" /></span>
		</li>
		<li>
		  <a class="myButton width-8">会员结算</a>
		  <sec:authorize access="isAnonymous()">
		    <a href="order/CheckoutNoLogin" class="myButton width-8">非会员结算</a>
		  </sec:authorize>
		</li>
	  </ul>
	</div> 
	</c:if>
	</div> 
</form:form>
	<script>
		$(document).ready(function(){
			$('.inQuantity').bootstrapNumber();
		
			$('.item_delete').click(function(e) {
	
				  removeItem(this,1);

			});
			
			$('.item_remove').click(function(e) {

				  removeItem(this,2);

			});
			
			
			 var  itemList = document.querySelector('.item-list');  
			 var initialList = itemList.innerHTML;
			 //alert(initialList);
			// alert("initialList:"+initialList);

			
			function removeItem (emitter,value) {
				//alert("In Remove"+value);
				$(emitter).closest("div").find(".status").val(value);
				
				var item = emitter.parentElement.parentElement;
				// alert("OK1");      
				 
				 var priceFields = $('.item .js-item-price');
				 
				 
				 var len = priceFields.length;
				 //alert("OK2");      
				var marginBottom = len > 1 ? parseInt(getComputedStyle(item).marginBottom, 10) : 0;
				  
				 //alert("OK3");
				  item.classList.add('item--disappearing');
				  item.style.marginTop = -(item.offsetHeight + marginBottom) + 'px';
	
				// var  itemList = document.querySelector('.item-list');
				  
				  setTimeout(function () {
				    //itemList.removeChild(item);
				   
				    //alert("remove");
				    //alert((item.innerHTML));
				    //alert ("after");

					//item.remove();
					itemList = document.querySelector('.item-list'); 
					//alert(itemList.innerHTML);
				    priceFields = document.querySelectorAll('.status');
				    
				    var selectedItemCount = 0;

			/* 	    for (var i =0;i<priceFields.length;i++){
				    	priceFields[i].val
				    } */
				    
				    $.each(priceFields, function() {
	                  if ($(this).val()==0 ) {
	                
	                	  //alert(selectedItemCount);
	                	  selectedItemCount++;
	                  }
				   	});
				    
				    
				    if (0==selectedItemCount) {
				      itemList.innerHTML = '<li class="item empty-hint"><p>结账的东西都没有啦 <a id="js-restore-list" class="js-restore-list" href="cart/Cart">再看看我的购物车</a>?</li>';
				      
				      //itemList.firstElementChild.classList.add('is-visible');
				      $(".js-summary").hide();
				      
				      //summaryFields = document.querySelectorAll('.js-summary')
				      //summaryFields.hide()
				      //alert(summaryFields.val())
				      //summaryFields.addClass('is-not-visible')
				      //summaryFields.style.marginTop = -(summaryFields.offsetHeight + 600) + 'px'
				      //summaryFields.classList.add('item--disappearing')
				     // alert(summaryFields.add('is-not-visible'))
				    }

				    //alert($(".js-summary").closest('form').html());
				    handleCalculations()
				  }, 500)
				};
				
				function handleCalculations(){
					//alert("In cal");
				};

		});
	</script>
