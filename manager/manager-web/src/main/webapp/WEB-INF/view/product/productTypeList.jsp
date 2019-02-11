<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="productTypeList" title="商品类型列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/productTypeController/getProductTypeList.do',method:'get',pageSize:20,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'typeId',checkbox:true"></th>
        	<th data-options="field:'typeName',width:200">分类名称</th>
            <th data-options="field:'sort',width:60">分类排序</th>
            <th data-options="field:'createTime',width:150,formatter:dateTimeFormatter">创建时间</th>
            <th data-options="field:'updateTime',width:150,formatter:dateTimeFormatter">修改时间</th>
        </tr>
    </thead>
</table>
<div id="productTypeAddWindow" class="easyui-window" title="新增商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/product/productTypeAdd.do'" style="width:30%;height:30%;padding:10px;"></div>
<div id="productTypeEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/product/productTypeEdit.do'" style="width:30%;height:30%;padding:10px;"></div>
<script>
    function getSelectionsIds(){
    	var productTypeList = $("#productTypeList");
    	var sels = productTypeList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].typeId);
    	}
    	ids = ids.join(",");
    	return ids;
    }

    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
            $("#productTypeAddWindow").window("open");
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个类型才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个类型!');
        		return ;
        	}

        	$("#productTypeEditWindow").window({
        		onLoad :function(){
                    //回显数据
                    var data = $("#productTypeList").datagrid("getSelections")[0];
                    $("#productTypeEditForm").form("load",data);
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中类型!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除该类型吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/productTypeController/deleteProductType.do",params, function(data){
            			if(data.code == 0){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#productTypeList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>