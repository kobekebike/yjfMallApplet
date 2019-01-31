<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>管理员登录</title>
    <jsp:include page="/commons/common-css.jsp"></jsp:include>
</head>
<body style="background-color: #F3F3F3">
    <div class="easyui-dialog" title="管理员登录" data-options="closable:false,draggable:false" style="width:400px;height:300px;padding:10px;">
<form id="loginform" method="post">
        <div style="margin-left: 50px;margin-top: 50px;">
            <div style="margin-bottom:20px;">
                <div>
                    用户名:
                    <input name="username" class="easyui-textbox" data-options="required:true" style="width:200px;height:32px" value="" type="text"/>
                </div>
            </div>
            <div style="margin-bottom:20px">
                <div>
                    密&nbsp;&nbsp;&nbsp;&nbsp;码: <input name="password" class="easyui-textbox" type="password" data-options="required:true" style="width:200px;height:32px" data-options="" value=""/>
                </div>
            </div>
            <div>
                <a id="login" class="easyui-linkbutton clicking" iconCls="icon-ok" style="width:100px;height:32px;margin-left: 50px">登录</a>
            </div>
        </div>
</form>
    </div>
<%@include file="commons/common-js.jsp"%>
<script type="text/javascript">
    var flag = true;
    $(function(){
        document.onkeydown = function(e){
            var ev = document.all ? window.event : e;
            if(ev.keyCode==13) {
                if(flag){
                    doLogin();
                    flag = false;
                }else{
                    if ($(".window").css("display") == "none" && $(".messager-window").css("display") != "block") {
                        $("#searchbtn").click();
                    }
                    else if ($(".window").css("display") == "block" || $(".messager-window").css("display") == "block") {
                        var object = $(".window").find(".icon-ok")[0];
                        var messobject = $(".messager-window").find(".messager-button").find(".l-btn-text");
                        if(messobject.length<=0){
                            object.click();
                        }else{
                            messobject[0].click();
                        }
                    }
                    flag = true;
                    return false;
                }
            }
        }

        $("#_easyui_textbox_input1").focus();
    });
    $("#login").click(function(){
        doLogin();
    });
    function doLogin(){
        var username = $("[name=username]").val().trim();
        var password = $("[name=password]").val().trim();

        if(!username){
            $.messager.alert('错误','用户名不能为空','error');
            flag = false;
            return ;
        }
        if(!password){
            $.messager.alert('错误','密码不能为空','error');
            flag = false;
            return ;
        }
        var url = "/login.do?method=doLogin";
        var result = ajaxFormSubmitOnce("loginform","login",url);
        if(result.code == 0){
            window.location.href = "/home.do";
        }else if(result.code == 1){
            $.messager.alert('错误',result.message,'error');
            $("#login").addClass("clicking");
        }
    }
</script>
</body>
</html>