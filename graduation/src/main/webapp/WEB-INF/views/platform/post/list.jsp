<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
    <div class="page-content" style="display: block;">
        <!-- 操作栏 -->
        <div class="page-top">
            <div class="page-top-title">
                <span>推送管理</span>
            </div>
            <div class="page-top-btns">
                <button class="btn btn-primary btn-sm" id="search">查询</button>
                <button class="btn btn-primary btn-sm" id="reset">重置</button>
                <shiro:hasAnyRoles name="doctor">
                    <button class="btn btn-color btn-sm" id="addPost">新增</button>
                    <button class="btn btn-color btn-sm" id="modifyPost">修改</button>
                </shiro:hasAnyRoles>
                <button class="btn btn-color btn-sm" id="deletePost">删除</button>
                <shiro:hasAnyRoles name="admin">
                    <button class="btn btn-color btn-sm" id="checkPost">查看</button>
                    <button class="btn btn-color btn-sm" id="publishPost">推送</button>
                    <button class="btn btn-color btn-sm" id="cancelPublishPost">取消推送</button>
                </shiro:hasAnyRoles>
            </div>
        </div>
        <!-- 查询表单 -->
        <form action="" id="searchForm">

            <input type="hidden" name="userId" value="<shiro:principal type="com.platform.model.User" property="id"/>">
            <input type="hidden" name="role" value="<shiro:principal type="com.platform.model.User" property="role"/>">

            <div class="page-search panel-body form-horizontal">
                <div class="col-xs-4">
                    <div class="form-group">
                        <label for="posterName" class="col-xs-5 col-padding-none control-label">文章作者：</label>
                        <div class="col-xs-7 col-padding-none">
                            <input type="text" class="form-control" id="posterName" name="posterName" placeholder="请输入文章作者">
                        </div>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="form-group">
                        <label for="postTitle" class="col-xs-5 col-padding-none control-label">文章标题：</label>
                        <div class="col-xs-7 col-padding-none">
                            <input type="text" class="form-control" id="postTitle" name="postTitle" placeholder="请输入文章标题">
                        </div>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="form-group">
                        <label for="publishStatus" class="col-xs-5 col-padding-none control-label">文章状态：</label>
                        <div class="col-xs-7 col-padding-none">
                            <select class="form-control selectpicker" data-style="btn-white btn-select" title="请选择" name="publishStatus" id="publishStatus">
                                <option value=""></option>
                                <option value="0">未推送</option>
                                <option value="1">已推送</option>
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

    <div class="page-detail" style="display: none">
        <div class="page-top">
            <div class="page-top-title" id="operation">
                <span>推送管理 > 新增文章</span>
            </div>
            <div class="page-top-btns">
                <button class="btn btn-primary btn-sm pull-right" id="back">返回</button>
                <shiro:hasAnyRoles name="doctor">
                    <button class="btn btn-color btn-sm pull-right" id="save">保存</button>
                </shiro:hasAnyRoles>
            </div>
        </div>

        <div class="page-editor">
            <div class="row">
                <div class="col-md-12">
                    <!-- 标题等 -->
                    <form id="postForm">
                        <input type="hidden" name="id">
                        <input type="hidden" name="posterId" value="<shiro:principal type="com.platform.model.User" property="id"/>">
                        <input type="hidden" name="postImage">
                        <div class="col-md-3 panel-body form-horizontal">
                            <div class="form-group">
                                <label for="title" class="col-xs-3 col-padding-none control-label">文章标题：</label>
                                <div class="col-xs-9 col-padding-none">
                                    <input type="text" class="form-control" id="title" name="postTitle" placeholder="请输入文章标题">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="author" class="col-xs-3 col-padding-none control-label">文章作者：</label>
                                <div class="col-xs-9 col-padding-none">
                                    <input type="text" class="form-control" id="author" disabled name="posterName" placeholder="请输入文章作者" value="<shiro:principal type="com.platform.model.User" property="realName"/>">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3 col-padding-none control-label">文章配图：</label>
                                <input class="hidden" type="file" multiple id="chooseImage" accept="image/*">
                                <div class="col-xs-9 col-padding-none" style="display: flex">
                                    <div class="add-image" id="addImage">
                                        <i class="fa fa-plus fa-3x"></i>
                                        选择图片
                                    </div>
                                    <!--
                                    <div class="remove-image" id="removeImage">
                                        <i class="fa fa-minus fa-3x"></i>
                                        删除图片
                                    </div>
                                    -->
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3 col-padding-none control-label">图片预览：</label>
                                <div class="col-xs-9 col-padding-none" id="image-group"></div>
                            </div>
                        </div>
                    </form>

                    <!-- 文章编辑处 -->
                    <div class="col-md-9">
                        <!-- 工具栏 -->
                        <div class="btn-toolbar" style="margin-bottom: 10px" data-role="editor-toolbar" data-target="#editor">
                            <div class="btn-group">
                                <a class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" title="" data-original-title="字体">
                                    <i class="fa fa-font"></i>
                                    <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a data-edit="fontName Serif" style="font-family:'Serif'">Serif</a></li>
                                    <li><a data-edit="fontName Sans" style="font-family:'Sans'">Sans</a></li>
                                    <li><a data-edit="fontName Arial" style="font-family:'Arial'">Arial</a></li>
                                    <li><a data-edit="fontName Arial Black" style="font-family:'Arial Black'">Arial Black</a></li>
                                    <li><a data-edit="fontName Courier" style="font-family:'Courier'">Courier</a></li>
                                    <li><a data-edit="fontName Courier New" style="font-family:'Courier New'">Courier New</a></li>
                                    <li><a data-edit="fontName Comic Sans MS" style="font-family:'Comic Sans MS'">Comic Sans MS</a></li>
                                    <li><a data-edit="fontName Helvetica" style="font-family:'Helvetica'">Helvetica</a></li>
                                    <li><a data-edit="fontName Impact" style="font-family:'Impact'">Impact</a></li>
                                    <li><a data-edit="fontName Lucida Grande" style="font-family:'Lucida Grande'">Lucida Grande</a></li>
                                    <li><a data-edit="fontName Lucida Sans" style="font-family:'Lucida Sans'">Lucida Sans</a></li>
                                    <li><a data-edit="fontName Tahoma" style="font-family:'Tahoma'">Tahoma</a></li>
                                    <li><a data-edit="fontName Times" style="font-family:'Times'">Times</a></li>
                                    <li><a data-edit="fontName Times New Roman" style="font-family:'Times New Roman'">Times New Roman</a></li>
                                    <li><a data-edit="fontName Verdana" style="font-family:'Verdana'">Verdana</a></li>
                                </ul>
                            </div>
                            <div class="btn-group">
                                <a class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" title="" data-original-title="Font Size">
                                    <i class="fa fa-text-height"></i>&nbsp;
                                    <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a data-edit="fontSize 5">
                                            <span class="h2">大</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a data-edit="fontSize 3">
                                            <span class="h4">中</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a data-edit="fontSize 1">
                                            <span class="h6">小</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="btn-group">
                                <a class="btn btn-default btn-sm" data-edit="bold" title="" data-original-title="Bold (Ctrl/Cmd+B)">
                                    <i class="fa fa-bold"></i>
                                </a>
                                <a class="btn btn-default btn-sm" data-edit="italic" title="" data-original-title="Italic (Ctrl/Cmd+I)">
                                    <i class="fa fa-italic"></i>
                                </a>
                                <a class="btn btn-default btn-sm" data-edit="strikethrough" title="" data-original-title="Strikethrough">
                                    <i class="fa fa-strikethrough"></i>
                                </a>
                                <a class="btn btn-default btn-sm" data-edit="underline" title="" data-original-title="Underline (Ctrl/Cmd+U)">
                                    <i class="fa fa-underline"></i>
                                </a>
                            </div>
                            <div class="btn-group">
                                <a class="btn btn-default btn-sm" data-edit="insertunorderedlist" title="" data-original-title="Bullet list">
                                    <i class="fa fa-list-ul"></i>
                                </a>
                                <a class="btn btn-default btn-sm" data-edit="insertorderedlist" title="" data-original-title="Number list">
                                    <i class="fa fa-list-ol"></i>
                                </a>
                                <a class="btn btn-default btn-sm" data-edit="outdent" title="" data-original-title="Reduce indent (Shift+Tab)">
                                    <i class="fa fa-dedent"></i>
                                </a>
                                <a class="btn btn-default btn-sm" data-edit="indent" title="" data-original-title="Indent (Tab)">
                                    <i class="fa fa-indent"></i>
                                </a>
                            </div>
                            <div class="btn-group">
                                <a class="btn btn-default btn-sm btn-info" data-edit="justifyleft" title="" data-original-title="Align Left (Ctrl/Cmd+L)">
                                    <i class="fa fa-align-left"></i>
                                </a>
                                <a class="btn btn-default btn-sm" data-edit="justifycenter" title="" data-original-title="Center (Ctrl/Cmd+E)">
                                    <i class="fa fa-align-center"></i>
                                </a>
                                <a class="btn btn-default btn-sm" data-edit="justifyright" title="" data-original-title="Align Right (Ctrl/Cmd+R)">
                                    <i class="fa fa-align-right"></i>
                                </a>
                                <a class="btn btn-default btn-sm" data-edit="justifyfull" title="" data-original-title="Justify (Ctrl/Cmd+J)">
                                    <i class="fa fa-align-justify"></i>
                                </a>
                            </div>
                            <div class="btn-group">
                                <a class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" title="" data-original-title="Hyperlink">
                                    <i class="fa fa-link"></i>
                                </a>
                                <div class="dropdown-menu input-append">
                                    <input class="span2" placeholder="URL" type="text" data-edit="createLink">
                                    <button class="btn btn-default btn-sm" type="button">Add</button>
                                </div>
                                <a class="btn btn-default btn-sm" data-edit="unlink" title="" data-original-title="Remove Hyperlink">
                                    <i class="fa fa-cut"></i>
                                </a>
                            </div>
                            <div class="btn-group">
                                <a class="btn btn-default btn-sm" data-edit="undo" title="" data-original-title="Undo (Ctrl/Cmd+Z)">
                                    <i class="fa fa-undo"></i>
                                </a>
                                <a class="btn btn-default btn-sm" data-edit="redo" title="" data-original-title="Redo (Ctrl/Cmd+Y)">
                                    <i class="fa fa-repeat"></i>
                                </a>
                            </div>
                        </div>
                        <!-- 输入框 -->
                        <div id="editor" class="form-control" contenteditable="true" style="overflow:scroll;height: 400px"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/post/list.js"></script>
</body>
</html>
