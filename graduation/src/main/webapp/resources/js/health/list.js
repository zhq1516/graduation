// 数据表格
var table;

$(document).ready(function (e) {

    // 初始化插件
    initPlugs();

    // 设置请求URL
    dataTableInit["sAjaxSource"] = server_context + "health/list";

    // 设置选中样式
    dataTableInit["select"] = {
        "style":"multi",
        "selector":"td"
    };

    // 设置列
    dataTableInit["aoColumns"] = [
        {"data":"status","sTitle":"请选择","sWidth":"40px"},
        {"data":"name","sTitle":"条目名称"},
        {"data":"updateTime","sTitle":"最近修改时间"},
        {"data":"status","sTitle":"状态"},
        {"data":"typeName","sTitle":"类型"},
        {"data":"isYiBao","sTitle":"是否属于医保"},
        {"data":"otherName","sTitle":"别名"},
        {"data":"location","sTitle":"发病部位"},
        {"data":"infectivity","sTitle":"感染性"},
        {"data":"population","sTitle":"感染人群"},
        {"data":"symptom","sTitle":"症状"},
        {"data":"concurrentDisease","sTitle":"并发疾病"},
        {"data":"department","sTitle":"就诊科室"},
        {"data":"cost","sTitle":"治疗费用"},
        {"data":"treatmentRate","sTitle":"治疗率"},
        {"data":"treatmentCycle","sTitle":"治疗周期"},
        {"data":"therapeuticMethod","sTitle":"治疗方法"},
        {"data":"correlationCheck","sTitle":"相关检查"}
    ];

    //
    dataTableInit["columnDefs"] = [
        {
            "defaultContent": "无",
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
                var result = data === 1 ? "可见":"不可见";
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

    // 设置不可见
    $("#setInVisible").on("click",function (e) {
        var datas = table.rows(['.selected']).data();
        if(datas.length > 0){
            var ids = [];
            for(var i = 0; i < datas.length; ++i){
                ids.push(datas[i].id);
            }
            batchOperation("health/operation",1,ids,table);
        }else{
            alert("请选择至少一条记录！");
        }
    });

    // 设置可见
    $("#setVisible").on("click",function (e) {
        var datas = table.rows(['.selected']).data();
        if(datas.length > 0){
            var ids = [];
            for(var i = 0; i < datas.length; ++i){
                ids.push(datas[i].id);
            }
            batchOperation("health/operation",2,ids,table);
        }else{
            alert("请选择至少一条记录！");
        }
    });

});
