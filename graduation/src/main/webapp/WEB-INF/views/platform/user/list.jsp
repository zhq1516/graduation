<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户管理</title>
</head>
<body>

    <div class="page-top">
        <div class="page-top-title">
            <span>用户管理</span>
        </div>
        <div class="page-top-btns">
            <button class="btn btn-primary btn-sm">查询</button>
            <button class="btn btn-primary btn-sm">重置</button>
            <button class="btn btn-color btn-sm" id="addUser">新增</button>
            <button class="btn btn-color btn-sm">修改</button>
            <button class="btn btn-color btn-sm">删除</button>
        </div>
    </div>

    <div class="page-search panel-body form-horizontal">
        <div class="">
            <div class="">
                <div class="col-xs-4">
                    <div class="form-group">
                        <label for="userName" class="col-xs-5 col-padding-none control-label">用户姓名：</label>
                        <div class="col-xs-7 col-padding-none">
                            <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入用户姓名">
                        </div>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="form-group">
                        <label for="userType" class="col-xs-5 col-padding-none control-label">用户类型：</label>
                        <div class="col-xs-7 col-padding-none">
                            <select class="form-control selectpicker" data-style="btn-white btn-select" title="请选择" name="userType" id="userType">
                                <option value=""></option>
                                <option value="1">管理员</option>
                                <option value="2">医生</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="form-group">
                        <label for="createTime" class="col-xs-5 col-padding-none control-label">创建时间：</label>
                        <div class="col-xs-7 col-padding-none">
                            <div class="input-group input-group-sm">
                                <input type="text" class="date-picker form-control" id="createTime" name="createTime"/>
                                <span class="input-group-addon">
                                    <span class="fa fa-calendar"></span>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="page-list">
        <table class="table table-bordered table-striped table-hover" style="white-space: nowrap" id="dataTable"></table>
    </div>

    <%@include file="userTable.jsp"%>

    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/user/list.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/user/user.js"></script>
</body>
</html>
