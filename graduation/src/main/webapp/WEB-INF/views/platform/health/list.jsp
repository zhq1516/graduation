<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>知识条目管理</title>
</head>
<body>

    <div class="page-top">
        <div class="page-top-title">
            <span>知识条目管理</span>
        </div>
        <div class="page-top-btns">
            <button class="btn btn-primary btn-sm" id="search">查询</button>
            <button class="btn btn-primary btn-sm" id="reset">重置</button>
            <button class="btn btn-color btn-sm" id="setInVisible">设置不可见</button>
            <button class="btn btn-color btn-sm" id="setVisible">设置可见</button>
        </div>
    </div>

    <form action="" id="searchForm">

        <input type="hidden" name="from">

        <div class="page-search panel-body form-horizontal">
            <div class="col-xs-4">
                <div class="form-group">
                    <label for="name" class="col-xs-5 col-padding-none control-label">条目名称：</label>
                    <div class="col-xs-7 col-padding-none">
                        <input type="text" class="form-control" id="name" name="name" placeholder="请输入条目名称">
                    </div>
                </div>
            </div>
            <div class="col-xs-4">
                <div class="form-group">
                    <label for="type" class="col-xs-5 col-padding-none control-label">类型：</label>
                    <div class="col-xs-7 col-padding-none">
                        <select class="form-control selectpicker" data-style="btn-white btn-select" title="请选择" name="type" id="type">
                            <option value=""></option>
                            <option value="1">内科</option>
                            <option value="2">外科</option>
                            <option value="3">妇产科</option>
                            <option value="4">儿科</option>
                            <option value="5">男科</option>
                            <option value="6">皮肤性病</option>
                            <option value="7">五官科</option>
                            <option value="8">肿瘤科</option>
                            <option value="9">传染科</option>
                            <option value="10">精神科</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-xs-4">
                <div class="form-group">
                    <label for="status" class="col-xs-5 col-padding-none control-label">是否可见：</label>
                    <div class="col-xs-7 col-padding-none">
                        <select class="form-control selectpicker" data-style="btn-white btn-select" title="请选择" name="status" id="status">
                            <option value=""></option>
                            <option value="1">可见</option>
                            <option value="0">不可见</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-xs-4">
                <div class="form-group">
                    <label for="updateTimeS" class="col-xs-5 col-padding-none control-label">更新时间（起）：</label>
                    <div class="col-xs-7 col-padding-none">
                        <div class="input-group input-group-sm">
                            <input type="text" class="date-picker form-control" id="updateTimeS" name="updateTimeS"/>
                            <span class="input-group-addon">
                                <span class="fa fa-calendar"></span>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-4">
                <div class="form-group">
                    <label for="updateTimeE" class="col-xs-5 col-padding-none control-label">更新时间（终）：</label>
                    <div class="col-xs-7 col-padding-none">
                        <div class="input-group input-group-sm">
                            <input type="text" class="date-picker form-control" id="updateTimeE" name="updateTimeE"/>
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

    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/health/list.js"></script>

</body>
</html>
