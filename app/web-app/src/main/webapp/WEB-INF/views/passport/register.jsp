<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<html>
<head>
    <title>login</title>
</head>
<body>
    用户名 <input type="text" id="username">
    <br>
    密码   <input type="password" id="password">
    <br>
    密码   <input type="password" id="repassword">
    <br>
    <span id="error" style="display: none"></span>
    <br>
    <%--<button value="注册" id="registerBtn" onclick="passportJs.register();" />--%>
    <input type="button" value="注册" id="registerBtn" onclick="passportJs.register();" />

    <script src="http://cdn.bootcss.com/jquery/2.2.0/jquery.min.js"></script>
    <script src="${staticsDomain}/js/passport/passport.js"></script>
</body>
</html>
