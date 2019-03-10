
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