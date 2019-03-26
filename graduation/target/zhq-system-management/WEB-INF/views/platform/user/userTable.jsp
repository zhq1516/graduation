<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户编辑表格</title>
</head>
<body>
    <div id="userTable" class="modal bootstrap-dialog fade" tabindex="-2" role="dialog" aria-labelledby="userTableModalLabel" aria-hidden="true" data-backdrop="static">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- 标题 -->
                <div class="modal-header form-header">
                    <div class="bootstrap-dialog-header">
                        <div class="bootstrap-dialog-close-button" style="display: block">
                            <button class="close" aria-label="close" data-dismiss="modal" aria-hidden="true" style="font-size: 21px">x</button>
                        </div>
                        <div class="bootstrap-dialog-title" id="wifePhysiqueInfoTableModalLabel">用户信息</div>
                    </div>
                </div>
                <!-- 内容 -->
                <div class="modal-body">
                    <div class="bootstrap-dialog-body">
                        <div class="bootstrap-dialog-message">
                            <div>
                                <div class="panel panel-default" style="border-radius: 0">
                                    <form id="userInfoForm" enctype="multipart/form-data">
                                        <input type="hidden" name="id">
                                        <div class="panel-body form-horizontal">
                                            <div class="col-xs-12">
                                                <div class="form-group">
                                                    <label class="col-xs-4 control-label required">登录账号：</label>
                                                    <div class="col-xs-6">
                                                        <input type="text" class="form-control" name="loginAccount" placeholder="请输入手机号或邮箱">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="form-group">
                                                    <label class="col-xs-4 control-label ">用户名：</label>
                                                    <div class="col-xs-6">
                                                        <input type="text" autocomplete="false" class="form-control" name="userName" placeholder="请输入用户名称">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="form-group">
                                                    <label class="col-xs-4 control-label ">密码：</label>
                                                    <div class="col-xs-6">
                                                        <input type="password" autocomplete="false" class="form-control" name="password" placeholder="请输入密码">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="form-group">
                                                    <label class="col-xs-4 control-label ">用户角色：</label>
                                                    <div class="col-xs-6">
                                                        <select class="form-control selectpicker" data-style="btn-white btn-select" title="请选择" name="role">
                                                            <option value=""></option>
                                                            <option value="1">管理员</option>
                                                            <option value="2">医生</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="form-group">
                                                    <label class="col-xs-4 control-label ">用户头像：</label>
                                                    <div class="col-xs-6 avatar-area">
                                                        <input class="hidden" type="file" id="chooseAvator" name="avatorFile" accept="image/*">
                                                        <div class="avatar-box" id="addAvator">
                                                            <img id="showAvator" name="avator" src="" alt="">
                                                        </div>
                                                        <span>点击添加头像</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="panel-footer text-center">
                                            <button class="btn btn-color btn-sm" type="submit" name="formSubmit">保存</button>
                                            <button class="btn btn-color btn-sm" type="button" name="formReset">重置</button>
                                            <button class="btn btn-color btn-sm" type="button" name="formClose" data-dismiss="modal">关闭</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>