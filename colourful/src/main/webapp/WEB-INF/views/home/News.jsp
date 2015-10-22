<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css" media="screen" href="<c:url value = "/resources/css/skin-2.css"/>">

<p id ="navId" class ="homeNav">
<!--==============================content================================-->
       <div class="block-4 col-3">
        	<div class="h2">
       			<h2 class="h2-line-2">${news.title}</h2>
            </div>
			<div style="width:860px;">
                ${news.contents}
			</div>
      </div>
