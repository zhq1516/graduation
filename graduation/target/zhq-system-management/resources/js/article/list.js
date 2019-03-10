$(document).ready(function (e) {

    // 初始化插件
    initPlugs();

    // 设置请求URL
    dataTableInit["sAjaxSource"] = server_context + "article/list";

    // 设置选中样式
    dataTableInit["select"] = {
        "style":"multi",
        "selector":"td"
    };

    // 设置列
    dataTableInit["aoColumns"] = [
        {"data":"id","sTitle":"请选择"},
        {"data":"title","sTitle":"文章标题"},
        {"data":"authorName","sTitle":"文章作者"},
        {"data":"createTime","sTitle":"创建时间"},
        {"data":"updateTime","sTitle":"最近修改时间"},
        {"data":"publishTime","sTitle":"最近推送时间"},
        {"data":"collectNumber","sTitle":"收藏次数"},
        {"data":"upNumber","sTitle":"点赞次数"},
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
            "aTargets": 8,
            "mRender":function (data,type,full) {
                var result = data === 1 ? "正在推送":(data === 2 ? "已推送":"未推送");
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


});