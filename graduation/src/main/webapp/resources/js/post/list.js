// 数据表格
var table;
// 文章表单
var postForm;

$(document).ready(function (e) {

    // 初始化插件
    initPlugs();

    // 设置请求URL
    dataTableInit["sAjaxSource"] = server_context + "post/list";

    // 设置选中样式
    dataTableInit["select"] = {
        "style":"multi",
        "selector":"td"
    };

    // 设置列
    dataTableInit["aoColumns"] = [
        {"data":"status","sTitle":"请选择","sWidth":"40px"},
        {"data":"postTitle","sTitle":"文章标题"},
        {"data":"posterName","sTitle":"作者姓名"},
        {"data":"createTime","sTitle":"创建时间"},
        {"data":"updateTime","sTitle":"最近修改时间"},
        {"data":"publishTime","sTitle":"最近推送时间"},
        {"data":"readNumber","sTitle":"阅读量"},
        {"data":"collectNumber","sTitle":"收藏量"},
        {"data":"commentNumber","sTitle":"评论数"},
        {"data":"upNumber","sTitle":"点赞数"},
        {"data":"publishStatus","sTitle":"推送状态"},
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
            "aTargets": 10,
            "mRender":function (data,type,full) {
                var result = data === 1 ? "已推送":"未推送";
                return result;
            }
        },
        {
            "aTargets": 11,
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

    // 新增文章
    $("#addPost").on("click",function (e) {
       $(".page-detail").css("display","block");
       $(".page-content").css("display","none");
       $("#operation span").html("推送管理 > 新增文章");
       resetPostForm();
    });

    // 查看文章
    $("#checkPost").on("click",function (e) {
        var datas = table.rows(['.selected']).data();
        if(datas.length === 1){
            var data = datas[0];
            $(".page-detail").css("display","block");
            $(".page-content").css("display","none");
            $("#operation span").html("推送管理 > 查看文章");
            resetPostForm();
            fillTableData("#postForm",data,null);
            if(data.postImage !== ""){
                var image = data.postImage.split(",");
                for(var i = 0; i < image.length; ++i) {
                    var result = "<div class='col-xs-9 image-item'></div><img src='" + static_resource + image[i] + "' alt=''></div>";
                    $("#image-group").append(result);
                }
            }
            if(data.postContent !== ""){
                $("#editor").html(data.postContent);
            }
        }else{
            alert("请选择一篇文章！");
        }
    });

    // 修改文章
    $("#modifyPost").on("click",function (e) {
        var datas = table.rows(['.selected']).data();
        if(datas.length === 1){
            var data = datas[0];
            $(".page-detail").css("display","block");
            $(".page-content").css("display","none");
            $("#operation span").html("推送管理 > 修改文章");
            resetPostForm();
            fillTableData("#postForm",data,null);
            if(data.postImage !== ""){
                var image = data.postImage.split(",");
                for(var i = 0; i < image.length; ++i) {
                    var result = "<div class='col-xs-9 image-item'></div><img src='" + static_resource + image[i] + "' alt=''></div>";
                    $("#image-group").append(result);
                }
            }
            if(data.postContent !== ""){
                $("#editor").html(data.postContent);
            }
        }else{
            alert("请选择一篇文章！");
        }
    });


    /**
     * 文章编辑
     */
    $("#editor").wysiwyg();

    // 选择图片
    $("#addImage").on("click",function (e) {
        $("#postForm input[name='postImage']").val("");
        $("#chooseImage").click();
    });

    // 触发文件选择
    $("#chooseImage").on("change",function (e) {
        // 获取所选文件
        var files = $("#chooseImage")[0].files;
        $("#image-group").html("");
        for(var i = 0;i < files.length; ++i){
            // 创建读取对象
            var reader = new FileReader();
            // 读取文件
            reader.readAsDataURL(files[i]);
            // 读取成功后执行
            reader.onload = function (ev) {
                var result = "<div class='col-xs-9 image-item'></div><img src='"+ ev.target.result +"' alt=''></div>"
                $("#image-group").append(result);
            }
        }
    });

    // 保存文章
    $("#save").on("click",function (e) {
        var form = document.getElementById("postForm");
        var formData = new FormData(form);
        formData.append("postContent",$("#editor").html());
        var fileList = $("#chooseImage")[0].files;
        for(var i = 0;i < fileList.length;++i) {
            formData.append("imageFiles",fileList[i]);
        }
        var xhr = new XMLHttpRequest();
        xhr.open("POST", server_context + "post/save");
        xhr.onload = function() {
            if(xhr.status === 200){
                alert("保存成功！");

            }else{
                alert("保存失败！");
            }
        };
        xhr.send(formData);
    });

    // 返回
    $("#back").on("click",function (e) {
        $(".page-detail").css("display","none");
        $(".page-content").css("display","block");
        table.ajax.reload();
    });

    /**
     * 批量操作
     */
    // 批量删除
    $("#deletePost").on("click",function (e) {
        var datas = table.rows(['.selected']).data();
        if(datas.length > 0){
            var ids = [];
            for(var i = 0; i < datas.length; ++i){
                ids.push(datas[i].id);
            }
            batchOperation("post/operation",3,ids,table);
        }else{
            alert("请选择至少一篇文章！");
        }
    });

    // 批量推送
    $("#publishPost").on("click",function (e) {
        var datas = table.rows(['.selected']).data();
        if(datas.length > 0){
            var ids = [];
            for(var i = 0; i < datas.length; ++i){
                ids.push(datas[i].id);
            }
            batchOperation("post/operation",1,ids,table);
        }else{
            alert("请选择至少一篇文章！");
        }
    });

    // 批量取消推送
    $("#cancelPublishPost").on("click",function (e) {
        var datas = table.rows(['.selected']).data();
        if(datas.length > 0){
            var ids = [];
            for(var i = 0; i < datas.length; ++i){
                ids.push(datas[i].id);
            }
            batchOperation("post/operation",2,ids,table);
        }else{
            alert("请选择至少一篇文章！");
        }
    })

});

function resetPostForm() {
    document.getElementById("postForm").reset();
    $("#image-group").html("");
    $("#editor").html("");
}