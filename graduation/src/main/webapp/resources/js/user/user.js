$(document).ready(function () {

    // 添加头像
    $("#chooseAvator").on("change",function (e) {
        // 获取所选文件
        var file = $("#chooseAvator")[0].files[0];
        // 创建用来读取此文件的对象
        var reader = new FileReader();
        // 使用该对象读取file文件
        reader.readAsDataURL(file);
        // 读取文件成功后执行的方法函数
        reader.onload = function(e){
            //读取成功后返回的一个参数e，整个的一个进度事件
            console.log(e);
            //选择所要显示图片的img，要赋值给img的src就是e中target下result里面的base64编码格式的地址
            $("#showAvator").get(0).src = e.target.result;
        }
    });

    // 点击头像框添加头像
    $("#addAvator").on("click",function (e) {
        $("#chooseAvator").trigger("click");
    });

});