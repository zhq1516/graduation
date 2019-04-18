// 数据表格
var table;
// 用户表格
var userForm;

$(document).ready(function (e) {

    // 初始化插件
    initPlugs();

    // 设置请求URL
    dataTableInit["sAjaxSource"] = server_context + "consult/list";

    // 设置选中样式
    dataTableInit["select"] = {
        "style":"multi",
        "selector":"td"
    };

    // 设置列
    dataTableInit["aoColumns"] = [
        {"data":"status","sTitle":"请选择","sWidth":"40px"},
        {"data":"wxUserName","sTitle":"微信用户昵称"},
        {"data":"doctorName","sTitle":"咨询医生"},
        {"data":"question","sTitle":"问题简介"},
        {"data":"createTime","sTitle":"发起时间"},
        {"data":"latestTime","sTitle":"最近回复时间"},
        {"data":"isFinish","sTitle":"是否已结束"}
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
                var result = data === 1 ? "已结束":"进行中";
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

    // 批量删除
    $("#delete").on("click",function (e) {
        var datas = table.rows(['.selected']).data();
        if(datas.length > 0){
            var ids = [];
            for(var i = 0; i < datas.length; ++i){
                ids.push(datas[i].id);
            }
            batchOperation("consult/operation",1,ids,table);
        }else{
            alert("请选择至少一条记录！");
        }
    });

    // 批量结束
    $("#finish").on("click",function (e) {
        var datas = table.rows(['.selected']).data();
        if(datas.length > 0){
            var ids = [];
            for(var i = 0; i < datas.length; ++i){
                ids.push(datas[i].id);
            }
            batchOperation("consult/operation",2,ids,table);
        }else{
            alert("请选择至少一条记录！");
        }
    });

});

