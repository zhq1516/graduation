<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>微信用户管理</title>
</head>
<body>

    <div class="page-top">
        <div class="page-top-title">
            <span>微信用户管理</span>
        </div>
        <div class="page-top-btns">
            <button class="btn btn-primary btn-sm" id="search">查询</button>
            <button class="btn btn-primary btn-sm" id="reset">重置</button>
            <button class="btn btn-color btn-sm" id="deleteUser">删除</button>
        </div>
    </div>

    <form action="" id="searchForm">
        <div class="page-search panel-body form-horizontal">
            <div class="col-xs-4">
                <div class="form-group">
                    <label for="nickName" class="col-xs-5 col-padding-none control-label">用户昵称：</label>
                    <div class="col-xs-7 col-padding-none">
                        <input type="text" class="form-control" id="nickName" name="nickName" placeholder="请输入用户昵称">
                    </div>
                </div>
            </div>
            <div class="col-xs-4">
                <div class="form-group">
                    <label for="gender" class="col-xs-5 col-padding-none control-label">性别：</label>
                    <div class="col-xs-7 col-padding-none">
                        <select class="form-control selectpicker" data-style="btn-white btn-select" title="请选择" name="gender" id="gender">
                            <option value=""></option>
                            <option value="1">男</option>
                            <option value="2">女</option>
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
        <table class="table table-bordered table-hover" style="white-space: nowrap" id="dataTable"></table>
    </div>

    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/wxUser/list.js"></script>
</body>
</html>
