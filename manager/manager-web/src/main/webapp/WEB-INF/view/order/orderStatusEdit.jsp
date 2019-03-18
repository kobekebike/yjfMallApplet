<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="padding:10px 10px 10px 10px">
	<form id="mallOrderStatusEditForm" class="productForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>订单状态:</td>
	            <td><input readonly value="已发货" class="easyui-textbox" type="text" name="" data-options="required:true"/></td>
	        </tr>
			<tr>
				<td>快递公司:</td>
				<td>
					<input class="easyui-textbox" type="text" name="expressCompany" data-options="required:true" style="width: 280px;"/>
				</td>
			</tr>
			<tr>
				<td>快递单号:</td>
				<td>
					<input class="easyui-textbox" type="text" name="expressNum" data-options="required:true" style="width: 280px;"/>
				</td>
			</tr>
	    </table>
	    <input type="hidden" name="orderIds"/>
		<input type="hidden" name="orderStatus" value="3">
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton clicking" onclick="submitProductTypeEditForm()" id="submitEditOrderStatusId">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearProductTypeEditForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	$(function(){
	});
	
	function submitProductTypeEditForm(){
		//表单校验
		if(!$('#mallOrderStatusEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!','error');
			return ;
		}
		var url = "/mallOrderController/updateOrderStatus.do";
		var data = ajaxFormSubmitOnce("mallOrderStatusEditForm","submitEditOrderStatusId",url);
        $.messager.alert("提示",data.message);
		if(data.code == 0){
            clearProductTypeEditForm();
            $("#submitEditProductTypeId").addClass("clicking");
            $("#updateOrderStatusWindow").window("close");
            $('#mallOrderList').datagrid('reload');
		}
	}

	function clearProductTypeEditForm(){
		$('#mallOrderStatusEditForm').form('reset');
	}
</script>
