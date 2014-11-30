<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

<head>
<%@ include file="../common/IncludeTop.jsp"%>
</head>
<body>
<form:form method="post" action="addContact.html">
<div id="Main">
<div id ="welcome" class="h1">
	<sec:authentication var="principal" property="principal" />
	<sec:authorize access="hasRole('ROLE_USER')">
	Welcome ${principal.username}
	</sec:authorize>
</div>
<br/>

<div id="Sidebar">
<div id="SidebarContent"><a href="category/find/FISH">
	<img src="<c:url value="/resources/images/${doggif}"/>" />
</a>
 <br />
Saltwater, Freshwater <br />
<a href="category/find/DOGS">
	<img src="<c:url value="/resources/images/${doggif}"/>" />
</a> <br />
Various Breeds <br />
<a href="category/find/CATS">
	<img src="<c:url value="/resources/images/test/${doggif}"/>" />
</a> <br />
Various Breeds, Exotic Varieties <br />
<a href="category/find/REPTILES">
	<img src="<c:url value="/resources/images/reptiles_icon.gif"/>" />
</a> <br />
Lizards, Turtles, Snakes <br />
<a href="category/find/BIRDS">
	<img src="<c:url value="/resources/images/birds_icon.gif"/>" />
</a> <br />
Exotic Varieties</div>
<br/><br/><br/>
<div><a href="validate/"> Validate Test</a></div>
</div>

<div id="MainImage">
<div id="MainImageContent">
  <map name="estoremap">
	<area alt="Birds" coords="72,2,280,250"
		href="Catalog.action?viewCategory=&categoryId=BIRDS" shape="RECT" />
	<area alt="Fish" coords="2,180,72,250"
		href="Catalog.action?viewCategory=&categoryId=FISH" shape="RECT" />
	<area alt="Dogs" coords="60,250,130,320"
		href="Catalog.action?viewCategory=&categoryId=DOGS" shape="RECT" />
	<area alt="Reptiles" coords="140,270,210,340"
		href="Catalog.action?viewCategory=&categoryId=REPTILES" shape="RECT" />
	<area alt="Cats" coords="225,240,295,310"
		href="Catalog.action?viewCategory=&categoryId=CATS" shape="RECT" />
	<area alt="Birds" coords="280,180,350,250"
		href="Catalog.action?viewCategory=&categoryId=BIRDS" shape="RECT" />
  </map> 
	<!-- use c:url to get the correct absolute path -->
  <img height="355" src="<c:url value="/resources/images/splash.gif" />" align="middle"	usemap="#estoremap" width="350" /></div>
	
</div>

<div id="Separator">&nbsp;</div>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
</form:form>
</body>
</html>
