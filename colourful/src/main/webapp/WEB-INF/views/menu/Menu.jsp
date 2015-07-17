<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p id ="navId" class ="menuNav">
<!--==============================content================================-->
	<form:form id="menu_form" method="post"	modelAttribute="menuForm" action="home/addMultiProducts">
      <div><form:errors path="*" class="errormsg"/></div>
      <c:forEach var="products" items="${menuForm.productsList}" varStatus="status">
        <div class="col-5 left-2">
        	<h2 class="h2-line-3">${products.categoryName}</h2>
            <div class="wrap1">
              <ul class="list">
               <c:forEach var="productDetail" items="${products.productList}" varStatus="status1">
                  <li><strong><form:checkbox class="rain_chkbox" path="selectedProductIdList" value="${productDetail.productId}"/>${productDetail.productName}</strong><span>¥${productDetail.unitPrice}/每${productDetail.unit}</span><em>&nbsp;</em></li>
               </c:forEach>
              </ul>
          </div>
        </div>
       </c:forEach> 

       <strong class="left-25" id="lb1"><a class="myButton width-8" >就买这些</a></strong>
    </form:form>

<script type="text/javascript">
  function checked(el) {
	  //var id = $(el).attr('id');
    //alert("id:"+id.val());
    //$('#prompt').html(id + ': checked');
  }
  function unChecked(el) {
    //var id = $(el).attr('id');
    //$('#prompt').html(id + ': unchecked');
  }
 
  // Execute on page load
  $(function () {
   $('.rain_chkbox').each(function(){
   
	   $(this).flatcheckbox({
		      onChecked: function (el) {
		        checked(el);
		      },
		      onUnChecked: function (el) {
		        unChecked(el);
		      }
		    });
	   
   });
  });
</script>