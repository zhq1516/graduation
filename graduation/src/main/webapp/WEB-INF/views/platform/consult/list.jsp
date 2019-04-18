<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>咨询管理</title>
</head>
<body>

    <div class="page-content" style="display: block;">
        <!-- 操作栏 -->
        <div class="page-top">
            <div class="page-top-title">
                <span>咨询管理</span>
            </div>
            <div class="page-top-btns">
                <button class="btn btn-primary btn-sm" id="search">查询</button>
                <button class="btn btn-primary btn-sm" id="reset">重置</button>
                <button class="btn btn-color btn-sm" id="finish">结束会话</button>
                <button class="btn btn-color btn-sm" id="delete">删除</button>
            </div>
        </div>
        <!-- 查询表单 -->
        <form action="" id="searchForm">
            <div class="page-search panel-body form-horizontal">
                <div class="col-xs-4">
                    <div class="form-group">
                        <label for="wxUserName" class="col-xs-5 col-padding-none control-label">咨询者昵称：</label>
                        <div class="col-xs-7 col-padding-none">
                            <input type="text" class="form-control" id="wxUserName" name="wxUserName" placeholder="请输入咨询者昵称">
                        </div>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="form-group">
                        <label for="doctorName" class="col-xs-5 col-padding-none control-label">咨询医生：</label>
                        <div class="col-xs-7 col-padding-none">
                            <input type="text" class="form-control" id="doctorName" name="doctorName" placeholder="请输入咨询医生姓名">
                        </div>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="form-group">
                        <label for="question" class="col-xs-5 col-padding-none control-label">咨询问题：</label>
                        <div class="col-xs-7 col-padding-none">
                            <input type="text" class="form-control" id="question" name="question" placeholder="请输入咨询问题">
                        </div>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="form-group">
                        <label for="isFinish" class="col-xs-5 col-padding-none control-label">咨询状态：</label>
                        <div class="col-xs-7 col-padding-none">
                            <select class="form-control selectpicker" data-style="btn-white btn-select" title="请选择" name="isFinish" id="isFinish">
                                <option value=""></option>
                                <option value="1">已结束</option>
                                <option value="0">进行中</option>
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
        <!-- 数据展示 -->
        <div class="page-list">
            <table class="table table-bordered" style="white-space: nowrap" id="dataTable"></table>
        </div>
    </div>

    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/consult/list.js"></script>
</body>
</html>
