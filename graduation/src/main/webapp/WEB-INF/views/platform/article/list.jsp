<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>推送管理</title>
</head>
<body>

    <div class="page-top">
        <div class="page-top-title">
            <span>推送管理</span>
        </div>
        <div class="page-top-btns">
            <button class="btn btn-primary btn-sm">查询</button>
            <button class="btn btn-primary btn-sm">重置</button>
            <button class="btn btn-danger btn-sm">新增文章类型</button>
            <button class="btn btn-color btn-sm">新增</button>
            <button class="btn btn-color btn-sm">修改</button>
            <button class="btn btn-color btn-sm">删除</button>
            <button class="btn btn-color btn-sm">发布</button>
            <button class="btn btn-color btn-sm">取消发布</button>
        </div>
    </div>

    <div class="page-search panel-body form-horizontal">
        <div class="col-xs-4">
            <div class="form-group">
                <label for="title" class="col-xs-5 col-padding-none control-label">文章标题：</label>
                <div class="col-xs-7 col-padding-none">
                    <input type="text" class="form-control" id="title" name="title" placeholder="请输入文章标题">
                </div>
            </div>
        </div>
        <div class="col-xs-4">
            <div class="form-group">
                <label for="author" class="col-xs-5 col-padding-none control-label">文章作者：</label>
                <div class="col-xs-7 col-padding-none">
                    <input type="text" class="form-control" id="author" name="author" placeholder="请输入文章作者">
                </div>
            </div>
        </div>
        <div class="col-xs-4">
            <div class="form-group">
                <label for="type" class="col-xs-5 col-padding-none control-label">文章类型：</label>
                <div class="col-xs-7 col-padding-none">
                    <select class="form-control selectpicker" data-style="btn-white btn-select" title="请选择" name="type" id="type">
                        <option value=""></option>
                        <option value="1">医疗类</option>
                        <option value="2">健康类</option>
                        <option value="3">日常类</option>
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
        <div class="col-xs-4">
            <div class="form-group">
                <label for="status" class="col-xs-5 col-padding-none control-label">文章状态：</label>
                <div class="col-xs-7 col-padding-none">
                    <select class="form-control selectpicker" data-style="btn-white btn-select" title="请选择" name="status" id="status">
                        <option value=""></option>
                        <option value="0">未推送</option>
                        <option value="1">正在推送</option>
                        <option value="2">已推送</option>
                    </select>
                </div>
            </div>
        </div>
    </div>

    <div class="page-list">
        <table class="table table-bordered table-striped table-hover" style="white-space: nowrap" id="dataTable"></table>
    </div>

    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/article/list.js"></script>
</body>
</html>
