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

    <div class="page-content">
        <div class="page-top">
            <div class="page-top-title">
                <span>推送管理</span>
            </div>
            <div class="page-top-btns">
                <button class="btn btn-primary btn-sm" id="search">查询</button>
                <button class="btn btn-primary btn-sm" id="reset">重置</button>
                <button class="btn btn-danger btn-sm">新增文章类型</button>
                <button class="btn btn-color btn-sm" id="addArticle">新增</button>
                <button class="btn btn-color btn-sm" id="modifyArticle">修改</button>
                <button class="btn btn-color btn-sm">删除</button>
                <button class="btn btn-color btn-sm">推送</button>
                <button class="btn btn-color btn-sm">取消推送</button>
            </div>
        </div>

        <form id="searchForm">
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
                                <option value="1">未推送</option>
                                <option value="2">正在推送</option>
                                <option value="3">已推送</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </form>

        <div class="page-list">
            <table class="table table-bordered table-striped table-hover" style="white-space: nowrap" id="dataTable"></table>
        </div>
    </div>

    <div class="page-detail" style="display: none">

        <div class="row">
            <div class="col-md-12">
                <div class="col-md-3" style="height: 300px;background-color: #324321"></div>
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
                        <div class="btn-group pull-left">
                            <a class="btn btn-default btn-sm" title="" id="pictureBtn" data-original-title="Insert picture (or just drag &amp; drop)">
                                <i class="fa fa-picture-o"></i>
                            </a>
                            <input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" style="opacity: 0; position: absolute; top: 0px; left: 0px; width: 35px; height: 30px;">
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
        <!--
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"></span>
                <input type="text" placeholder="标题" name="title" class="form-control">
            </div>
            <button class="btn btn-primary btn-sm pull-right" id="back">返回</button>
            <button class="btn btn-color btn-sm pull-right" id="save">保存</button>
        </div>
        -->
    </div>

    <%@include file="articleTable.jsp"%>

    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/article/list.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/article/editor.js"></script>

</body>
</html>
