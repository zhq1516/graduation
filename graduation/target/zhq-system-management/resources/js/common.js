
/**
 * 各类组件初始化
 */
function initPlugs() {

    // 日期组件初始化
    $(".date-picker").datepicker({
        format:"yyyy-mm-dd",
        endDate:new Date(),
        autoclose:true,
        todayHighlight:true,
        language:"zh-CN"
    }).next().on("click",function(e){
        $(this).prev().focus();
    });

}

/**
 * 表格初始化
 */
var dataTableInit = {
    "destroy":true,
    "bServerSide": true,
    "processing": true,
    "sScrollX": "100%",
    //表格的宽度
    //"sScrollY": "406px",
    "sScrollXInner": "100%",
    //表格的内容宽度
    "bScrollCollapse": false,
    //当显示的数据不足以支撑表格的默认的高度时，依然显示纵向的滚动条。(默认是false)
    "bPaginate": true,
    //是否显示分页
    "bLengthChange": true,
    //每页显示的记录数
    "bFilter": false,
    //搜索栏
    "bSort": false,
    //是否支持排序功能
    "bInfo": true,
    //显示表格信息
    "bAutoWidth": false,
    //自适应宽度
    "aLengthMenu": [15,25,50,100],
    //设置选择每页的条目数
    "iDisplayLength": 15,
    //默认显示条数
    "aaSorting": [[1, "asc"]],
    //给列表排序 ，第一个参数表示数组 (由0开始)。1 表示Browser列。第二个参数为 desc或是asc
    "bStateSave": false,
    //保存状态到cookie *************** 很重要 ， 当搜索的时候页面一刷新会导致搜索的消失。使用这个属性就可避免了
    "sPaginationType": "full_numbers",
    //分页，一共两种样式，full_numbers和two_button(默认)
    "oLanguage": {
        "sUrl": server_context + "resources/vendor/js/dataTables/de_DE.txt"
        //多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
    },
    "bJQueryUI": false,
    //可以添加 jqury的ui theme  需要添加css
    "fnServerData" : function(sSource, aoData, fnCallback) {
        $.ajax({
            type: "post",
            url: sSource,
            dataType: "json",
            data: {
                aoData: JSON.stringify(aoData)
            },
            success: function(resp) {
                if (resp.status != 200) {
                    alert(resp.msg);
                }else{
                    fnCallback(resp);
                }
            }
        });
    }
};

/**
 * 表单提交
 * @param form
 * @param url
 * @param table
 * @param callback
 * @returns {*|jQuery}
 */

function validateForm(form,url,table,callback) {
    var submitForm;
    // 改变form提交路径
    $(form).attr("action",server_context + url);
    // 自定义规则
    jQuery.validator.addMethod("isMobile", function(value, element) {
        var length = value.length;
        var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请正确填写您的手机号码");
    // 表单提交
    var validateSubmitForm = $(form).validate({
        // 检查规则
        rules:{

        },
        // 提示信息
        messages:{

        },
        // 忽略标志
        ignore:".ignore",
        // 错误提示位置
        errorPlacement:function(error,element) {
            if(element.siblings()[0] != null){
                error.insertAfter(element.parent());
            }else {
                error.appendTo(element.parent());
            }
        },
        // 错误提示类型
        errorElement: "span",
        // 表单提交
        submitHandler: function(form) {
            submitForm = $(form).ajaxSubmit({
                type: "post",
                dataType: "json",
                cache: false,
                success:function (res) {
                    if(res.status === 200){
                        alert("信息保存成功！");
                        if(callback){
                            callback(res.data);
                        }
                        if(table){
                            table.ajax.reload();
                        }
                    }
                },
                error:function () {
                    alert("信息保存失败！");
                }
            })
        }
    });
    return validateSubmitForm;
}

function fillTableData(form,data,callback) {
    for(var key in data){
        if(data[key] !== null && data[key] !== ""){
            $(form + " input[type='text'][name='"+key+"']").val(data[key]);
            $(form + " input[type='hidden'][name='"+key+"']").val(data[key]);
            $(form + " select[name='"+key+"']").selectpicker("val",data[key].toString().split(",")).selectpicker("refresh");
            $(form + " img[name='"+key+"']").attr("src",static_resource + data[key]);
        }
    }
    if(callback){
        callback();
    }
}