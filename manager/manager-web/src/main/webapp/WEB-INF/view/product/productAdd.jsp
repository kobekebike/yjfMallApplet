<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String ctxPathName = request.getContextPath();
%>
<div style="padding:10px 10px 10px 10px">
	<form id="productAddForm" class="productForm" method="post" enctype="multipart/form-data">
	    <table border="0" cellpadding="0" cellspacing="1" class="formTable">
	        <tr>
	            <td class="labelTd">商品编号:</td>
	            <td class="inputTd"><input class="easyui-textbox" type="text" name="productCode" data-options="required:true" style="width:80%"/></td>
	            <td class="labelTd">商品标题:</td>
	            <td class="inputTd"><input class="easyui-textbox" type="text" name="productTitle" data-options="required:true" style="width:80%"/></td>
	        </tr>
			<tr>
				<td class="labelTd">商品类型:</td>
				<td class="inputTd">
					<input class="easyui-combobox" name="productTypeId" id="productTypeSelectId" data-options="required:true" style="width:80%"/>
				</td>
	            <td class="labelTd">商品价格:</td>
	            <td class="inputTd"><input class="easyui-numberbox" type="text" name="productPrice" data-options="min:1,max:99999999,precision:2,required:true" style="width:80%"/>
	            	<input type="hidden" name="price"/>
	            </td>
			</tr>
	        <tr>
	            <td class="labelTd">商品折扣:</td>
	            <td class="inputTd">
					<input class="easyui-numberbox" type="number" name="productDiscount" data-options="min:1,max:10" style="width:80%"/>折
	            </td>
				<td class="labelTd">商品排序:</td>
				<td class="inputTd">
					<input class="easyui-numberbox" type="number" name="productSort" data-options="min:1,max:99999999,required:true" style="width:80%"/>
				</td>
	        </tr>
	        <tr>
	            <td class="labelTd">已售数量:</td>
	            <td class="inputTd">
					<input class="easyui-numberbox" type="text" name="soldOutNum" data-options="min:0,max:99999999,required:true" style="width:80%" value="0"/>
	            </td>
	        </tr>
	    </table>
		<table border="0" cellpadding="0" cellspacing="1" class="formTable">
			<tr>
				<td class="labelTd">商品主图:</td>
				<td class="inputTd">
					<input style="width:50%" name="productFile" id="productFile" class="easyui-filebox" accept="image/*" data-options='onChange:change_photo'>
				</td>
			</tr>
			<tr id="previewPictureId" style="display: none">
				<td class="labelTd"><label>图片预览</label></td>
				<td class="inputTd"> <div id="Imgdiv"><img id="Img" width="200px" height="200px"/></div></td>
			</tr>
		</table>
		<table border="0" cellpadding="0" cellspacing="1" class="formTable">
			<tr>
				<td class="labelTd">商品描述:</td>
				<td class="inputTd">
					<input class="easyui-textbox" data-options="multiline:true" value="" style="width:100%;height:100px" name="productDescribe">
				</td>
			</tr>
		</table>
		<table border="0" cellpadding="0" cellspacing="1" class="formTable">
			<tr>
				<td class="labelTd">商品详情:</td>
				<td class="inputTd">
					<textarea id="editor" type="text/plain" style="width:100%;height:300px;" name="productDetailText"></textarea>
				</td>
			</tr>
		</table>
	    <input type="hidden" name="productType"/>
	    <input type="hidden" name="productId"/>
	    <input type="hidden" name="productFilePath"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton clicking" onclick="submitProductForm()" id="submitProductId" style="display: none;">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton clicking" onclick="updateProductForm()" id="updateProductId" style="display: none;">修改</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearProductForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
    /**
     * 编辑器资源文件根路径。它所表示的含义是：以编辑器实例化页面为当前路径，指向编辑器资源文件（即dialog等文件夹）的路径。
     * 鉴于很多同学在使用编辑器的时候出现的种种路径问题，此处强烈建议大家使用"相对于网站根目录的相对路径"进行配置。
     * "相对于网站根目录的相对路径"也就是以斜杠开头的形如"/myProject/ueditor/"这样的路径。
     * 如果站点中有多个不在同一层级的页面需要实例化编辑器，且引用了同一UEditor的时候，此处的URL可能不适用于每个页面的编辑器。
     * 因此，UEditor提供了针对不同页面的编辑器可单独配置的根路径，具体来说，在需要实例化编辑器的页面最顶部写上如下代码即可。当然，需要令此处的URL等于对应的配置。
     * window.UEDITOR_HOME_URL = "/xxxx/xxxx/";String ctxPathName = request.getContextPath();
     */
    window.UEDITOR_HOME_URL = "<%=ctxPathName%>/plugin/ueditor/";
</script>
<script src="/plugin/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
<script src="/plugin/ueditor/ueditor.all.min.js" type="text/javascript" charset="utf-8"> </script>
<script src="/plugin/ueditor/lang/zh-cn/zh-cn.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    var type = "<%=request.getParameter("type")%>";
    var ue;
	$(function(){
        //实例化编辑器
        ue = UE.getEditor('editor');
        UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
        UE.Editor.prototype.getActionUrl = function(action){
            if(action == "uploadimage" || action == "uploadscrawl"){
                return "/ueditorUploadController/uploadUEditorImage.do";
            }else if(action == "listimage"){
                return "/ueditorUploadController/uploadUEditorImage.do";
            }else {
                return this._bkGetActionUrl.call(this, action);
            }
        }

        //显示商品类型
        showProductType();
	});

	//查询商品类型
	function showProductType() {
		var url = "/productTypeController/getAllProductTypeList.do";
		var data = requestAjaxData(url,false,true);
		if(data.code == "0"){
		    var result = data.data;
		    if(result && result.length > 0 && result[0]){
		        //unshift() 方法可向数组的开头添加一个或更多元素，并返回新的长度。
		        result.unshift({typeId:'',typeName:'请选择'});
				$("#productTypeSelectId").combobox({
					data:result,
					valueField:'typeId',
					textField:'typeName',
					panelHeight:'auto'
				});
			}
		}
    }
	//保存商品
	function submitProductForm(){

		//表单校验
		if(!$('#productAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		if($("#productTypeSelectId").combobox("getText") != "请选择"){
        	$("#productAddForm [name=productType]").val($("#productTypeSelectId").combobox("getText"));
		}else{
            $.messager.alert('提示','请选择类型');
            return ;
		}
        //获取httml内容
		// $("#productAddForm [name=productDetailText]").val(ue.getContent());

        var url = "/productController/saveProduct.do";
        var data = ajaxFormSubmit('productAddForm', "submitProductId", url, false);
        $.messager.alert("提示",data.message);
        if(data.code == 0){
            clearProductForm();
            $("#productAddAndEditWindow").window("close");
            $('#productList').datagrid('reload');
        }
		$("#submitProductId").addClass("clicking");
	}
	
	function clearProductForm(){
		$('#productAddForm').form('reset');
        ue.setContent('');
	}

    function change_photo(){
        PreviewImage($("input[name='productFile']")[0], 'Img', 'Imgdiv');
    }

    function PreviewImage(fileObj,imgPreviewId,divPreviewId){
        var allowExtention=".jpg,.bmp,.gif,.png";//允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
        var extention=fileObj.value.substring(fileObj.value.lastIndexOf(".")+1).toLowerCase();
        var browserVersion= window.navigator.userAgent.toUpperCase();
        if(allowExtention.indexOf(extention)>-1){
            if(fileObj.files){//HTML5实现预览，兼容chrome、火狐7+等
                if(window.FileReader){
                    var reader = new FileReader();
                    reader.onload = function(e){
                        document.getElementById(imgPreviewId).setAttribute("src",e.target.result);
                    }
                    reader.readAsDataURL(fileObj.files[0]);
                }else if(browserVersion.indexOf("SAFARI")>-1){
                    alert("不支持Safari6.0以下浏览器的图片预览!");
                }
            }else if (browserVersion.indexOf("MSIE")>-1){
                if(browserVersion.indexOf("MSIE 6")>-1){//ie6
                    document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);
                }else{//ie[7-9]
                    fileObj.select();
                    if(browserVersion.indexOf("MSIE 9")>-1)
                        fileObj.blur();//不加上document.selection.createRange().text在ie9会拒绝访问
                    var newPreview =document.getElementById(divPreviewId+"New");
                    if(newPreview==null){
                        newPreview =document.createElement("div");
                        newPreview.setAttribute("id",divPreviewId+"New");
                        newPreview.style.width = document.getElementById(imgPreviewId).width+"px";
                        newPreview.style.height = document.getElementById(imgPreviewId).height+"px";
                        newPreview.style.border="solid 1px #d2e2e2";
                    }
                    newPreview.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + document.selection.createRange().text + "')";
                    var tempDivPreview=document.getElementById(divPreviewId);
                    tempDivPreview.parentNode.insertBefore(newPreview,tempDivPreview);
                    tempDivPreview.style.display="none";
                }
            }else if(browserVersion.indexOf("FIREFOX")>-1){//firefox
                var firefoxVersion= parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);
                if(firefoxVersion<7){//firefox7以下版本
                    document.getElementById(imgPreviewId).setAttribute("src",fileObj.files[0].getAsDataURL());
                }else{//firefox7.0+
                    document.getElementById(imgPreviewId).setAttribute("src",window.URL.createObjectURL(fileObj.files[0]));
                }
            }else{
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);
            }
            $("#previewPictureId").show();
        }else{
            alert("仅支持"+allowExtention+"为后缀名的文件!");
            fileObj.value="";//清空选中文件
            if(browserVersion.indexOf("MSIE")>-1){
                fileObj.select();
                document.selection.clear();
            }
            fileObj.outerHTML=fileObj.outerHTML;
            $("#previewPictureId").hide();
        }
    }
	//修改商品
    function updateProductForm(){
		//表单校验
        if(!$('#productAddForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        if($("#productTypeSelectId").combobox("getText") != "请选择"){
            $("#productAddForm [name=productType]").val($("#productTypeSelectId").combobox("getText"));
        }else{
            $.messager.alert('提示','请选择类型');
            return ;
        }
        var url = "/productController/updateProduct.do";
        var data = ajaxFormSubmit('productAddForm', "submitProductId", url, false);
        $.messager.alert("提示",data.message);
        if(data.code == 0){
            clearProductForm();
            $("#submitProductId").addClass("clicking")
            $("#productAddAndEditWindow").window("close");
            $('#productList').datagrid('reload');
        }
	}
</script>
