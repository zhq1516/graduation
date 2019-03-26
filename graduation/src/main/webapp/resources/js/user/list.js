// 数据表格
var table;
// 用户表格
var userForm;

$(document).ready(function (e) {

    // 初始化插件
    initPlugs();

    // 设置请求URL
    dataTableInit["sAjaxSource"] = server_context + "user/list";

    // 设置选中样式
    dataTableInit["select"] = {
        "style":"multi",
        "selector":"td"
    };

    // 设置列
    dataTableInit["aoColumns"] = [
        {"data":"status","sTitle":"请选择","sWidth":"40px"},
        {"data":"userName","sTitle":"用户名"},
        {"data":"loginAccount","sTitle":"登录账号"},
        {"data":"createTime","sTitle":"创建时间"},
        {"data":"updateTime","sTitle":"最近修改时间"},
        {"data":"roleName","sTitle":"系统角色"},
        {"data":"status","sTitle":"状态"}
    ];

    //
    dataTableInit["columnDefs"] = [
        {
            "defaultContent": "",
            "targets": "_all"
        },
        {
            "aTargets": 0,
            "className": "select-checkbox",
            "mRender":function (data,type,full) {
                return "";
            }
        },
        {
            "aTargets": 6,
            "mRender":function (data,type,full) {
                var result = data === 1 ? "启用":"禁用";
                return result;
            }
        }
    ];

    // 重写数据请求
    dataTableInit["fnServerData"] = function(sSource, aoData, fnCallback) {
        $.ajax({
            type: "post",
            url: sSource,
            dataType: "json",
            data: {
                aoData: JSON.stringify(aoData),
                formData: JSON.stringify($("#searchForm").serializeJSON())
            },
            success: function(resp) {
                if (resp.status !== 200) {
                    alert(resp.msg);
                }else{
                    fnCallback(resp);
                }
            }
        });
    };

    // 表格
    table = $("#dataTable").dataTable(dataTableInit).api();

    // 查询
    $("#search").on("click",function (e) {
       table.ajax.reload();
    });

    // 重置查询条件
    $("#reset").on("click",function (e) {
        document.getElementById("searchForm").reset();
        $(".selectpicker").selectpicker("refresh");
    });

    // 修改/查看用户信息
    $("#modifyUser").on("click",function (e) {
        // 获取所选记录
        var datas = table.rows(['.selected']).data();
        if(datas.length === 1){
            var data = datas[0];
            $("#userInfoForm button[name='formReset']").trigger("click");
            fillTableData("#userInfoForm",data);
            $("#userTable").modal("show");
        }else{
            alert("请选择一名用户！");
        }
    });

    // 新增用户
    $("#addUser").on("click",function (e) {
        $("#userInfoForm input[name='id']").val("");
        $("#userInfoForm button[name='formReset']").trigger("click");
        $("#userTable").modal("show");
    });

    // 删除用户
    $("#deleteUser").on("click",function (e) {
       var datas = table.rows(['.selected']).data();
       if(datas.length > 0){
           var ids = [];
           for(var i = 0; i < datas.length; ++i){
               ids.push(datas[i].id);
           }
           operationUser(1,ids,table);
       }else{
           alert("请选择至少一名用户！");
       }
    });

    // 禁用用户
    $("#forbidUser").on("click",function (e) {
        var datas = table.rows(['.selected']).data();
        if(datas.length > 0){
            var ids = [];
            for(var i = 0; i < datas.length; ++i){
                ids.push(datas[i].id);
            }
            operationUser(2,ids,table);
        }else{
            alert("请选择至少一名用户！");
        }
    });

});

// 批量操作用户
function operationUser(type,ids,table) {
    $.ajax({
        type: "post",
        url: server_context + "user/operation",
        dataType: "json",
        data: {
            "ids":ids,
            "type":type
        },
        success: function (res) {
            if(res.status === 200){
                alert("操作成功！");
                if(table){
                    table.ajax.reload();
                }
            }else{
                alert("操作失败！");
            }
        }
    });
}