<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>主页</title>
    <%@include file="WEB-INF/views/include/publicCSS.jsp"%>
</head>
<body>

<div class="app" data-sidebar="locked">
    <!-- 顶部 -->
    <%@include file="WEB-INF/views/include/navbar.jsp"%>
    <!-- 整体 -->
    <section class="layout">
        <%@include file="WEB-INF/views/include/sidebar.jsp"%>
        <!-- 右侧 -->
        <section class="main-content">
            <div class="content-wrap">
            </div>
        </section>
    </section>
</div>

<%@include file="WEB-INF/views/include/publicJS.jsp"%>

</body>
</html>
