<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="padding:10px 10px 10px 10px">
	<form id="productTypeAddForm" class="productForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>分类名称:</td>
	            <td><input class="easyui-textbox" type="text" name="typeName" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
			<tr>
				<td>分类排序:</td>
				<td>
					<input class="easyui-numberbox" type="text" name="sort" data-options="min:1,max:99999999,required:true" />
				</td>
			</tr>
	    </table>
	    <input type="hidden" name="productParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton clicking" onclick="submitProductTypeForm()" id="submitProductTypeId">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearProductTypeForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	$(function(){
        clearProductTypeForm();
	});
	
	function submitProductTypeForm(){
		//表单校验
		if(!$('#productTypeAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!','error');
			return ;
		}
		var url = "/productTypeController/saveProductType.do";
		var data = ajaxFormSubmitOnce("productTypeAddForm","submitProductTypeId",url);
        $.messager.alert("提示",data.message);
		$("#submitProductTypeId").addClass("clicking");
		if(data.code == 0){
            clearProductTypeForm();
			$("#productTypeAddWindow").window("close");
			$('#productTypeList').datagrid('reload');
		}
	}

	function clearProductTypeForm(){
		$('#productTypeAddForm').form('reset');
	}
</script>
