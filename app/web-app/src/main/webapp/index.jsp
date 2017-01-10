<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<html>
<body>
<header>
    <%@ include file="/WEB-INF/views/common/meta.jsp"%>
    <link href="${staticsDomain}/css/index.css" rel="stylesheet" type="text/css">
</header>
<div class="index-div">
    <input id="userId" type="hidden" value="${userId}">

    <div class="module">
        <h3>登录注册</h3>
        <div class="content">
            <li onclick="indexJs.login()">登录</li>
            <li onclick="indexJs.register()">注册</li>
        </div>
    </div>
    <div class="module">
        <h3>restful</h3>
        <div class="content">
            <li onclick="indexJs.restGet()">get</li>
            <li onclick="indexJs.restGet()">post</li>
            <li onclick="indexJs.restDel()">delete</li>
        </div>
    </div>
</div>

<script type="text/javascript" src="${staticsDomain}/js/passport/passport.js"></script>
<script type="text/javascript" src="${staticsDomain}/js/index/index.js"></script>

</body>
</html>
