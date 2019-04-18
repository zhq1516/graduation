
$(document).ready(function (e) {

    var currentConsult;
    var currentConsultId;
    var isFinish = 0;

    // 初始化插件
    initPlugs();

    // 查询
    $("#search").on("click",function (e) {
        var formData = JSON.stringify($("#searchForm").serializeJSON());
        $.ajax({
            type: "post",
            url: server_context + "consult/doctor/list",
            dataType: "json",
            contentType:"application/json;charset=utf-8",
            data: formData,
            success: function(res) {
                if(res.status === 200){
                    refreshConsultList(res.data);
                }
            }
        });
        resetChatArea();
        currentConsultId = undefined;
    });

    // 重置查询条件
    $("#reset").on("click",function (e) {
        document.getElementById("searchForm").reset();
        $(".selectpicker").selectpicker("refresh");
    });

    // 点击获取会话内容
    $("#consultList").on("click","li",function (e) {
        clearInterval(currentConsult);
        $("#consultList li").removeClass("selected");
        $(this).addClass("selected");
        currentConsultId = parseInt($(this).attr("data-idx"));
        isFinish = parseInt($(this).attr("data-finish"));
        if(isFinish === 1){
            $(".chat-area-tool").css("display","none");
            $("#titleArea span").text("已结束");
        }else{
            $(".chat-area-tool").css("display","flex");
            $("#titleArea span").text("进行中");
        }
        getMessageList(currentConsultId);
    });

    // 发送消息
    $("#sendMessage").on("click",function () {
        var formData = new FormData();
        var text = $("#addText").val();
        var pictures = $("#choosePicture")[0].files;
        formData.append("content",text);
        formData.append("consultId",currentConsultId);
        formData.append("userId",18);
        formData.append("userType","DOCTOR");
        for(var i = 0; i < pictures.length; ++i){
            formData.append("imageArray",pictures[i])
        }
        var xhr = new XMLHttpRequest();
        xhr.open("POST", server_context + "consult/message/send");
        xhr.onload = function(event) {
            document.getElementById("sendMegForm").reset();
            $("#picture-info").html("");
            getMessageList(currentConsultId);
        };
        xhr.send(formData);
    });

    $("#addText").bind("keydown",function (e) {
        if(e.keyCode == "13"){
            $("#sendMessage").trigger("click");
            return false;
        }
    });

    // 添加图片
    $("#addPicture").on("click",function (e) {
        $("#choosePicture").trigger("click");
    });

    // 选择图片
    $("#choosePicture").on("change",function (e) {
        // 获取所选文件
        var files = $("#choosePicture")[0].files;
        $("#picture-info").html("");
        if(files.length > 0){
            $("#picture-info").append("已选择"+ files.length +"张图片")
        }
    });

    // 结束咨询
    $("#finish").on("click",function (e) {
        if(currentConsultId !== undefined){
            var data = [];
            data.push(currentConsultId);
            batchOperation("consult/operation",2,data,null,function (e) {
               $("#search").trigger("click");
            });
        }else{
            alert("请选择会话");
        }
    });

    // 刷新
    $("#titleArea").on("click","i",function (e) {
        getMessageList(currentConsultId);
    });

    $("#search").trigger("click");

});

// 刷新对话列表
function refreshConsultList(data){
    $("#consultList").html("");
    for(var i = 0;i < data.length; ++i){
        var item = "<li class='list-group-item' data-finish='"+ data[i].isFinish +"' data-idx='"+data[i].id+"'><span class='no-margin center-block'>"+data[i].wxUserName+"<small class='pull-right'>"+data[i].createTime+"</small></span><p class='no-margin'>"+data[i].question+"</p></li>";
        $("#consultList").append(item);
    }
}

// 获取消息列表
function getMessageList(currentId){
    $.ajax({
        type: "post",
        url: server_context + "consult/message/list",
        dataType: "json",
        contentType:"application/json;charset=utf-8",
        data: JSON.stringify({
            "consultId": currentId
        }),
        success: function(res) {
            if(res.status === 200){
                refreshChatArea(res.data);
            }
        }
    })
}

// 刷新聊天区域
function refreshChatArea(data) {
    $("#messageArea").html("");
    for(var i = 0;i < data.length; ++i){
        if(data[i].userType ===  'USER') {
            var result = "<div class='user-ask'>" +
                "<div>" +
                "<div class='left-triangle'></div>" +
                "<span>" + data[i].content + "</span>";
            if(data[i].image !== ""){
                var images = data[i].image.split(",");
                for(var j = 0; j < images.length;++j){
                    result += "<img class='user-ask-picture' src='"+ static_resource + images[j] +"'>";
                }
            }
            result += "</div></div>";
            $("#messageArea").append(result);
        }
        if(data[i].userType === 'DOCTOR'){
            var result = "<div class='doctor-answer'>" +
                "<div>" +
                "<span>"+ data[i].content +"</span>";
            if(data[i].image !== ""){
                var images = data[i].image.split(",");
                for(var j = 0; j < images.length;++j){
                    result += "<img class='doctor-answer-picture' src='"+ static_resource + images[j] +"'>";
                }
            }
            result += "<div class='right-triangle'></div></div></div>";
            $("#messageArea").append(result);
        }
    }
    $("#messageArea")[0].scrollTop =$("#messageArea")[0].scrollHeight;
}

// 重置
function resetChatArea() {
    $("#messageArea").html("");
    document.getElementById("sendMegForm").reset();
    $("#picture-info").html("");
    $("#titleArea span").text("");
}
