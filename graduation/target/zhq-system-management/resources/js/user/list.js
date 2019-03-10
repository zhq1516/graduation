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
        {"data":"userName","sTitle":"姓名"},
        {"data":"loginAccount","sTitle":"登录账号"},
        {"data":"createTime","sTitle":"创建时间"},
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
            "aTargets": 5,
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
                aoData: JSON.stringify(aoData)
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
    var table = $("#dataTable").dataTable(dataTableInit).api();

    // 新增用户
    $("#addUser").on("click",function (e) {
        $("#userTable").modal("show");
    });

});