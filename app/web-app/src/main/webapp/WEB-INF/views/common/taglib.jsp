<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page trimDirectiveWhitespaces="true" %>

<%-- Path --%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="staticsDomain" value="${pageContext.request.contextPath}/static"/>
<c:set var="userId" value="${sessionUserId}" />