<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/IncludeTop.jsp"%>
<title><tiles:getAsString name="title"/></title>
</head>
<body>
<form action="<c:url value="/processLogin" />" method="post" >
<form:errors path="*" cssClass="errorblock" element="div" />
<div id ="Main">
	<p>Please enter your username and password.</p>
<p>
 <label for="j_username">Username</label>
 <input id="j_username" name="j_username" type="text" />
</p>

<p>
 <label for="j_password">Password</label>
 <input id="j_password" name="j_password" type="password" />
</p><input  type="submit" value="Login"/>

</div>
</form>
<%@ include file="../common/IncludeBottom.jsp"%>
</body>
</html>