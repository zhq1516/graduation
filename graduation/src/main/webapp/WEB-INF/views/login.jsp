<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录界面</title>
    <%@include file="include/publicCSS.jsp"%>
    <%@include file="include/publicJS.jsp"%>
</head>

<body class="bg-color center-wrapper">
    <div class="center-content">
        <div class="row">
            <div class="col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
                <section class="panel panel-default">
                    <header class="panel-heading">系统登录</header>
                    <div class="bg-white user pd-md">
                        <h6><strong>您好！</strong>请输入账号及密码登录系统</h6>
                        <div style="color: red"><p id="login_error_msg">${errorMessage} </p></div>
                        <form role="form" method="post" action="">
                            <input type="text" class="form-control mg-b-sm" placeholder="用户账号" id="username" name="username" autofocus>
                            <input type="password" class="form-control" placeholder="密码" id="password" name="password">
                            <button class="btn btn-info btn-block" style="margin-top: 10px" type="submit">登录</button>
                        </form>
                    </div>
                </section>
            </div>
        </div>
    </div>
</body>
</html>
