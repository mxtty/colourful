<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="rb" uri="/WEB-INF/tlds/rainbow.tld"%>

<html>
<head>
<%@ include file="../common/IncludeTop.jsp"%>
</head>

<div class="errorblock" >
${errors}
</div>
<%@ include file="../common/IncludeBottom.jsp"%>
</html>