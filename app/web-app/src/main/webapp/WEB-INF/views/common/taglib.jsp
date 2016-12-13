<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- Path --%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="staticsDomain" value="${pageContext.request.contextPath}/statics"/>

<script type="text/javascript" src="${staticsDomain}/js/base/base.js"></script>
<script>
    baseJs.contextPath = '${ctx}';
</script>