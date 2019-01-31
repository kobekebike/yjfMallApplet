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