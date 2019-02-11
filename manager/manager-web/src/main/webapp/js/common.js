/**
 * 格式化日期
 * @param date
 * @returns {string}
 */
function dateTimeFormatter(date){
    date = new Date(date);
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    var h = date.getHours();
    var min = date.getMinutes();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d)+" "+(h<10?('0'+h):h)+":"+(min<10?('0'+min):min);
}
/**
 * add by ligz
 *ajax 提交form表单
 * @param formid
 * @param url
 */
function ajaxFormSubmit(formid,buttonId,url,async) {
    if(!$("#"+buttonId).hasClass("clicking")){
        return false;
    }
    var retResult;
    $("#"+formid).ajaxSubmit({
        url: url,
        async: async,//使用同步的方式,true为异步方式
        success:function(result) {
            retResult = result;
            $("#"+buttonId).removeClass("clicking");
        },
        error:function(XMLHttpRequest, textStatus, errorThrown) {
            alert("form表单提交失败");
            $("#"+buttonId).removeClass("clicking");
        }
    });
    return retResult;
}
/**
 * 提交表单，通过按钮提交时，控制提交次数，前提，按钮添加clicking样式
 *formid：表单id，bottonId：按钮id，url：请求地址
 */
function ajaxFormSubmitOnce(formid,buttonId,url){
    if(!$("#"+buttonId).hasClass("clicking")){
        return false;
    }
    var result;
    $.ajax({
        type: 'post',
        url: url,
        async: false,
        data:serializeForm($("#"+formid)),
        dataType: "json",
        success: function (datas) {
            result = datas;
            $("#"+buttonId).removeClass("clicking");
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("requestAjaxData请求失败");
            $("#"+buttonId).removeClass("clicking");
        }
    });
    return result;
}
//序列化表单
function serializeForm(form) {
    var o = {};
    $.each(form.serializeArray(), function(index) {
        if (o[this['name']]) {
            o[this['name']] = o[this['name']] + "," + this['value'];
        } else {
            o[this['name']] = this['value'];
        }
    });
    return o;
};
/**
 * add by ligz
 * ajax 请求获取数据
 * @param url
 * @param formdata
 * @param json
 * @returns
 */
function requestAjaxData(url, async, json) {
    var result;
    var dataType = "json";
    if(!json)
        dataType = "text";
    $.ajax({
        type: 'post',
        url: url,
        async: async,
        dataType: dataType,
        success: function (datas) {
            result = datas;
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("requestAjaxData请求失败");
        }
    });
    return result;
}