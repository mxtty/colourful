<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p id ="navId" class ="menuNav">
<!--==============================content================================-->
	<form:form id="menu_form" method="post"	modelAttribute="selectedMenuForm" action="cart/add">
        <div class="col-5 left-2">
        	<h2 class="h2-line-3">饺子类</h2>
            <div class="wrap">
              <ul class="list">
                  <li><form:checkbox path="" value=""/> <strong>猪肉韭菜水饺</strong><span>¥25.30</span><em>&nbsp;</em></li>
                  <li><strong>白菜三鲜水饺</strong><span>¥30.80</span><em>&nbsp;</em></li>
                  <li><strong>羊肉芹菜水饺</strong><span>¥50.90</span><em>&nbsp;</em></li>
                  <li><strong>牛肉茴香水饺</strong><span>¥75.50</span><em>&nbsp;</em></li>
                  <li><strong>猪肉白菜煎饺</strong><span>¥120.60</span><em>&nbsp;</em></li>
                  <li><strong>锅贴</strong><span>¥95.70</span><em>&nbsp;</em></li>
                  <li><strong>Viverra lectus</strong><span>¥45.74</span><em>&nbsp;</em></li>
                  <li><strong>Cras mattis</strong><span>¥37.45</span><em>&nbsp;</em></li>
                  <li><strong>Maecenas faucibus</strong><span>¥45.90</span><em>&nbsp;</em></li>
                  <li><strong>Sagittis cursus</strong><span>¥25.80</span><em>&nbsp;</em></li>
                  <li><strong>Fusce tincidunt</strong><span>¥90.37</span><em>&nbsp;</em></li>
                  <li><strong>Tellus eget tristique</strong><span>¥87.60</span><em>&nbsp;</em></li>
                  <li><strong>Amet dictum</strong><span>¥37.80</span><em>&nbsp;</em></li>
              </ul>
              <ul class="list last">
                  <li><strong>Mauris gravida</strong><span>¥95.90</span><em>&nbsp;</em></li>
                  <li><strong>Viverra lectus</strong><span>¥45.25</span><em>&nbsp;</em></li>
                  <li><strong>Cras mattis</strong><span>¥37.85</span><em>&nbsp;</em></li>
                  <li><strong>Tempor eros</strong><span>¥78.40</span><em>&nbsp;</em></li>
                  <li><strong>Sed vehicula augue</strong><span>¥56.78</span><em>&nbsp;</em></li>
              </ul>
          </div>
        </div>
    </form:form>