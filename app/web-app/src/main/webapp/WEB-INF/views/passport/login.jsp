<%--
  Created by IntelliJ IDEA.
  User: imant
  Date: 2016/12/13
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>

<html>
<head>
    <title>login</title>
</head>
<body>
    用户名 <input type="text" id="username">
    <br>
    密码   <input type="password" id="password">&nbsp;<span id="error" style="display: none;"></span>
    <br>
    <button value="登录" id="submitBtn" />

    <script src="http://cdn.bootcss.com/jquery/2.2.0/jquery.min.js"></script>
    <script src="${staticsDomain}/js/lib/jquery/jquery.md5.js"></script>
    <script src="${staticsDomain}/js/passport/passport.js"></script>
</body>
</html>
