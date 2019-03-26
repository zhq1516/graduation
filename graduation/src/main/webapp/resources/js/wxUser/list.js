// 数据表格
var table;
// 用户表格
var userForm;

$(document).ready(function (e) {

    // 初始化插件
    initPlugs();

    // 设置请求URL
    dataTableInit["sAjaxSource"] = server_context + "wx/user/list";

    // 设置选中样式
    dataTableInit["select"] = {
        "style":"multi",
        "selector":"td"
    };

    // 设置列
    dataTableInit["aoColumns"] = [
        {"data":"status","sTitle":"请选择","sWidth":"40px"},
        {"data":"openId","sTitle":"OPEN_ID"},
        {"data":"nickName","sTitle":"用户昵称"},
        {"data":"gender","sTitle":"性别"},
        {"data":"createTime","sTitle":"创建时间"},
        {"data":"updateTime","sTitle":"最近修改时间"},
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
            "aTargets": 3,
            "mRender":function (data,type,full) {
                var result = data === 1 ? "男":(data === 2 ? "女":"性别不明");
                return result;
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

});