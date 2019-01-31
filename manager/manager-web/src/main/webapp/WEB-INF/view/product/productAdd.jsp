<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="padding:10px 10px 10px 10px">
	<form id="productAddForm" class="productForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>商品标题:</td>
	            <td><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
			<tr>
				<td>商品类型:</td>
				<td>
					<select class="easyui-combobox" name="language">
						<option value="uk">Ukrainian</option>
						<option value="vi">Vietnamese</option>
					</select>
				</td>
			</tr>
	        <tr>
	            <td>商品价格:</td>
	            <td><input class="easyui-numberbox" type="text" name="priceView" data-options="min:1,max:99999999,precision:2,required:true" />
	            	<input type="hidden" name="price"/>
	            </td>
	        </tr>
	        <tr>
	            <td>商品折扣:</td>
	            <td><input class="easyui-numberbox" type="text" name="" data-options="min:1,max:99999999" />
	            	<input type="hidden" name=""/>
	            </td>
	        </tr>
			<tr>
				<td>商品排序:</td>
				<td>
					<input class="easyui-numberbox" type="text" name="" data-options="min:1,max:99999999" />
				</td>
			</tr>
	        <tr>
	            <td>商品主图:</td>
	            <td>
					<input class="easyui-numberbox" type="text" name="" />
	            </td>
	        </tr>
			<tr>
				<td>商品描述:</td>
				<td>
					<input class="easyui-textbox" data-options="multiline:true" value="" style="width:50%;height:100px" name="productDescribe">
				</td>
			</tr>
			<tr>
				<td style="width:6%;">商品详情:</td>
				<td>
					<textarea id="editor" type="text/plain" style="width:90%;height:300px;" name="productDetail"></textarea>
				</td>
			</tr>
	    </table>
	    <input type="hidden" name="productParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
    /**
     * 编辑器资源文件根路径。它所表示的含义是：以编辑器实例化页面为当前路径，指向编辑器资源文件（即dialog等文件夹）的路径。
     * 鉴于很多同学在使用编辑器的时候出现的种种路径问题，此处强烈建议大家使用"相对于网站根目录的相对路径"进行配置。
     * "相对于网站根目录的相对路径"也就是以斜杠开头的形如"/myProject/ueditor/"这样的路径。
     * 如果站点中有多个不在同一层级的页面需要实例化编辑器，且引用了同一UEditor的时候，此处的URL可能不适用于每个页面的编辑器。
     * 因此，UEditor提供了针对不同页面的编辑器可单独配置的根路径，具体来说，在需要实例化编辑器的页面最顶部写上如下代码即可。当然，需要令此处的URL等于对应的配置。
     * window.UEDITOR_HOME_URL = "/xxxx/xxxx/";
     */
    window.UEDITOR_HOME_URL = "../../../plugin/ueditor/";
</script>
<script src="/plugin/ueditor/ueditor.config.js" type="text/javascript" charset="utf-8"></script>
<script src="/plugin/ueditor/ueditor.all.min.js" type="text/javascript" charset="utf-8"> </script>
<script src="/plugin/ueditor/lang/zh-cn/zh-cn.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
        //实例化编辑器
        var ue = UE.getEditor('editor');
        UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
        UE.Editor.prototype.getActionUrl = function(action){
            if(action == "uploadimage" || action == "uploadscrawl" || action == "uploadimage"){
                return ctxPathName + "/view/docinfo.do?method=uploadUEditorImage";
            }else if(action == "listimage"){
                return ctxPathName + "/view/docinfo.do?method=uploadUEditorImage";
            }else {
                return this._bkGetActionUrl.call(this, action);
            }
        }
	});
	
	function submitForm(){
		//表单校验
		if(!$('#productAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
	}
	
	function clearForm(){
		$('#productAddForm').form('reset');
		productAddEditor.html('');
	}
</script>
