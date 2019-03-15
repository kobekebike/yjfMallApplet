<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" style="width:1000px;height:650px" id="mallOrderList" title="订单列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/mallOrderController/getMallOrderList.do',method:'get',pageSize:20,toolbar:toolbar">
    <thead>
        <tr>
        	<%--<th data-options="field:'orderId',checkbox:true"></th>--%>
        	<th data-options="field:'orderNum',width:120">订单编号</th>
        	<th data-options="field:'orderAmount',width:60">订单金额</th>
        	<th data-options="field:'productTitle',width:100">商品名称</th>
        	<th data-options="field:'productNum',width:60">商品数量</th>
        	<th data-options="field:'orderStatus',width:60,formatter:showOrderStatusFormatter">订单状态</th>
        	<th data-options="field:'addressee',width:60">收件人</th>
        	<th data-options="field:'expressCompany',width:100">快递公司</th>
        	<th data-options="field:'expressNum',width:100">快递单号</th>
        	<th data-options="field:'remark',width:100">备注</th>
            <th data-options="field:'createTime',width:120,formatter:dateTimeFormatter">创建时间</th>
        </tr>
    </thead>
</table>
<div id="updateOrderStatusWindow" class="easyui-window" title="填写快递信息" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/order/orderStatusEdit.do'" style="width:30%;height:30%;padding:10px;"></div>
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

    function showOrderStatusFormatter(value, row){
        var orderStatusText = "";
        if(value == 1){
            orderStatusText = "未付款";
        }else if(value == 2){
            orderStatusText = "<a href='javascript:void(0)' onclick=\"updateOrderStatus("+row.orderId+")\" style='color: blue;'>已付款</a>";
        }else if(value == 3){
            orderStatusText = "已发货";
        }else if(value == 4){
            orderStatusText = "取消";
        }
        return orderStatusText;
    }
    //修改订单状态
    function updateOrderStatus(orderId){
        $("#updateOrderStatusWindow").window({
            onLoad :function(){
                //回显数据
				$("#mallOrderStatusEditForm input[name=orderId]").val(orderId);
            }
        }).window("open");
	}
</script>