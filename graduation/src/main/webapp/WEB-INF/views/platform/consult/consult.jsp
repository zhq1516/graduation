<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>医生咨询界面</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/consult/consult.css">

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
        </div>
    </div>
    <!-- 查询表单 -->
    <form action="" id="searchForm">

        <input type="hidden" name="doctorId" value="<shiro:principal type="com.platform.model.User" property="id"/>">

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
    <div class="page-list" style="padding-bottom: 10px">

        <div class="row">
            <div class="col-xs-12">
                <!-- 对话列表 -->
                <div class="col-xs-4 conversation-list">
                    <div class="conversation-list-title">会话列表</div>
                    <div class="conversation-list-content">
                        <ul class="list-group no-radius pd-b-lg" id="consultList" style="margin: 0 -1px;"></ul>
                    </div>
                </div>
                <!-- 聊天区域 -->
                <div class="col-xs-8 chat-area">
                    <div class="chat-area-title" id="titleArea">
                        <span>标题栏</span>
                        <i class="fa fa-repeat pull-right"></i>
                    </div>
                    <div class="chat-area-content" id="messageArea"></div>
                    <form id="sendMegForm">
                        <div class="chat-area-tool">
                            <input type="text" class="form-control" id="addText" placeholder="在此输入文字">
                            <button type="button" class="btn btn-primary btn-sm" id="sendMessage">发送</button>
                            <button type="button" style="margin-left: 10px" class="btn btn-primary btn-sm" id="addPicture">添加图片</button>
                            <input class="hidden" type="file" accept="image/*" id="choosePicture" multiple>
                            <div id="picture-info"></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <!--
        <div class="row">
            <div class="col-xs-12">
                <div class="col-xs-4 conversation-list">
                    <div class="conversation-list-title">会话列表</div>
                    <div class="conversation-list-item">
                        <div class="conversation-list-item-avator"></div>
                        <div class="conversation-list-item-name">某某某</div>
                        <div class="conversation-list-item-date">2019-03-09 12:23:10</div>
                    </div>
                </div>
                <div class="col-xs-8" style="height: 300px;background-color: #1AADD1">

                </div>
            </div>
        </div>
        -->
    </div>
    </div>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/consult/consult.js"></script>
</body>
</html>
