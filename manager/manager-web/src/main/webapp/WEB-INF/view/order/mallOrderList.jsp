<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="mallOrderList" title="订单列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/mallOrderController/getMallOrderList.do',method:'get',pageSize:20,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'orderId',checkbox:true"></th>
        	<th data-options="field:'orderNum',width:100">订单编号</th>
        	<th data-options="field:'orderAmount',width:60">订单金额</th>
            <th data-options="field:'createTime',width:150,formatter:dateTimeFormatter">创建时间</th>
            <th data-options="field:'updateTime',width:150,formatter:dateTimeFormatter">修改时间</th>
        </tr>
    </thead>
</table>
<div id="productAddAndEditWindow" class="easyui-window" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:80%;height:80%;padding:10px;"></div>
<script type="text/javascript">

    function getSelectionsMallOrderIds(){
    	var userInfoList = $("#mallOrderList");
    	var sels = userInfoList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].orderId);
    	}
    	ids = ids.join(",");
    	return ids;
    }

    var toolbar = [];
</script>