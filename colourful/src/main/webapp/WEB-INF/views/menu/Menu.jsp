<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p id ="navId" class ="menuNav1">
<!--==============================content================================-->
	<form:form id="menu_form" method="post"	modelAttribute="menuForm" action="cart/add">
        <div class="col-5 left-2">
        	<h2 class="h2-line-3">饺子类</h2>
            <div class="wrap1">
              <ul class="list">
                  <li><strong><input class="rain_chkbox" type="checkbox" />猪肉韭菜水饺</strong><span>¥25.30</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />白菜三鲜水饺</strong><span>¥30.80</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />羊肉芹菜水饺</strong><span>¥50.90</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />牛肉茴香水饺</strong><span>¥75.50</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />猪肉白菜煎饺</strong><span>¥120.60</span><em>&nbsp;</em></li>
              </ul>
              <ul class="list last">
                  <li><strong><input class="rain_chkbox" type="checkbox" />猪肉青菜水饺</strong><span>¥25.30</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />鱼肉水饺</strong><span>¥30.80</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />韭菜鸡蛋水饺</strong><span>¥50.90</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />鸡肉水饺</strong><span>¥75.50</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />牛肉白菜煎饺</strong><span>¥120.60</span><em>&nbsp;</em></li>
              </ul>
          </div>
        </div>
        <div class="col-5 left-2">
        	<h2 class="h2-line-3">凉菜类</h2>
            <div class="wrap1">
              <ul class="list">
                  <li><strong><form:checkbox class="rain_chkbox" path="myTest" value="1001"/>凉拌猪蹄</strong><span>¥25.30</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />凉拌三线</strong><span>¥30.80</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />将猪肉</strong><span>¥50.90</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />酱牛肉</strong><span>¥75.50</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />酱鸡肉</strong><span>¥120.60</span><em>&nbsp;</em></li>
              </ul>
              <ul class="list last">
                  <li><strong><input class="rain_chkbox" type="checkbox" />凉拌粉丝</strong><span>¥25.30</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />凉拌海蜇</strong><span>¥30.80</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />凉拌花生</strong><span>¥50.90</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />凉拌粉条</strong><span>¥75.50</span><em>&nbsp;</em></li>
                  <li><strong><input class="rain_chkbox" type="checkbox" />凉拌海带</strong><span>¥120.60</span><em>&nbsp;</em></li>
              </ul>
          </div>
        </div>
        <strong class="left-25" id="lb1"><a class="myButton width-8" >就买这些</a></strong>
    </form:form>
    <script type="text/javascript">
 
  function checked(el) {
	  
	  var id = $(el).attr('id');
    alert("id:"+id.val());
    $('#prompt').html(id + ': checked');
  }
  function unChecked(el) {
    var id = $(el).attr('id');
    $('#prompt').html(id + ': unchecked');
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