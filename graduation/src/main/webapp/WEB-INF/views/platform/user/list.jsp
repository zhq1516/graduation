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
            <button class="btn btn-primary btn-sm" id="search">查询</button>
            <button class="btn btn-primary btn-sm" id="reset">重置</button>
            <button class="btn btn-color btn-sm" id="addUser">新增</button>
            <button class="btn btn-color btn-sm" id="modifyUser">修改</button>
            <button class="btn btn-color btn-sm" id="deleteUser">删除</button>
            <button class="btn btn-color btn-sm" id="forbidUser">禁用</button>
            <button class="btn btn-color btn-sm" id="unForbidUser">启用</button>
        </div>
    </div>

    <form action="" id="searchForm">
        <div class="page-search panel-body form-horizontal">
            <div class="col-xs-4">
                <div class="form-group">
                    <label for="userName" class="col-xs-5 col-padding-none control-label">用户名：</label>
                    <div class="col-xs-7 col-padding-none">
                        <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入用户名">
                    </div>
                </div>
            </div>
            <div class="col-xs-4">
                <div class="form-group">
                    <label for="phone" class="col-xs-5 col-padding-none control-label">联系方式：</label>
                    <div class="col-xs-7 col-padding-none">
                        <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入手机号码">
                    </div>
                </div>
            </div>
            <div class="col-xs-4">
                <div class="form-group">
                    <label for="realName" class="col-xs-5 col-padding-none control-label">医生姓名：</label>
                    <div class="col-xs-7 col-padding-none">
                        <input type="text" class="form-control" id="realName" name="realName" placeholder="请输入医生姓名">
                    </div>
                </div>
            </div>
            <div class="col-xs-4">
                <div class="form-group">
                    <label for="userRole" class="col-xs-5 col-padding-none control-label">用户类型：</label>
                    <div class="col-xs-7 col-padding-none">
                        <select class="form-control selectpicker" data-style="btn-white btn-select" title="请选择" name="userRole" id="userRole">
                            <option value=""></option>
                            <option value="1">管理员</option>
                            <option value="2">医生</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-xs-4">
                <div class="form-group">
                    <label for="createTimeS" class="col-xs-5 col-padding-none control-label">创建时间（起）：</label>
                    <div class="col-xs-7 col-padding-none">
                        <div class="input-group input-group-sm">
                            <input type="text" class="date-picker form-control" id="createTimeS" name="createTimeS"/>
                            <span class="input-group-addon">
                                <span class="fa fa-calendar"></span>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-4">
                <div class="form-group">
                    <label for="createTimeE" class="col-xs-5 col-padding-none control-label">创建时间（终）：</label>
                    <div class="col-xs-7 col-padding-none">
                        <div class="input-group input-group-sm">
                            <input type="text" class="date-picker form-control" id="createTimeE" name="createTimeE"/>
                            <span class="input-group-addon">
                                <span class="fa fa-calendar"></span>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>

    <div class="page-list">
        <table class="table table-bordered" style="white-space: nowrap" id="dataTable"></table>
    </div>

    <%@include file="userTable.jsp"%>

    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/user/list.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/user/user.js"></script>
</body>
</html>
