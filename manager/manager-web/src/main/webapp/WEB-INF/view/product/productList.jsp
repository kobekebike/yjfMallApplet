<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="productList" title="商品列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/productController/getProductList.do',method:'get',pageSize:20,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'productId',checkbox:true"></th>
        	<th data-options="field:'productCode',width:60">商品编号</th>
            <th data-options="field:'productTitle',width:200">商品标题</th>
            <th data-options="field:'productType',width:100">商品类型</th>
            <th data-options="field:'productPrice',width:100">商品价格</th>
            <th data-options="field:'productSort',width:70">商品排序</th>
            <th data-options="field:'createTime',width:150,formatter:dateTimeFormatter">创建时间</th>
            <th data-options="field:'updateTime',width:150,formatter:dateTimeFormatter">修改时间</th>
        </tr>
    </thead>
</table>
<div id="productAddAndEditWindow" class="easyui-window" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:80%;height:80%;padding:10px;"></div>
<script type="text/javascript">

    function getSelectionsIds(){
    	var productList = $("#productList");
    	var sels = productList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].productId);
    	}
    	ids = ids.join(",");
    	return ids;
    }

    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
            $("#productAddAndEditWindow").window({
                href:'/product/productAdd.do?type=1',
                title:"新增商品",
                onLoad :function(){
                    $("#submitProductId").show();
                    $("#updateProductId").hide();
                    $('#productAddForm').form('reset');
                }
            }).window("open");
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个商品才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个商品!');
        		return ;
        	}
            $("#productAddAndEditWindow").window({
                href:'/product/productAdd.do',
                title:"编辑商品",
                onLoad :function(){
                    $("#updateProductId").show();
                    $("#submitProductId").hide();
                    //回显数据
                    var data = $("#productList").datagrid("getSelections")[0];
                    $("#productAddForm").form("load",data);

                    // 加载商品详情
                    var productDetail = requestAjaxData("/productController/getProductDetail.do?productId="+data.productId, false, true);
                    ue.ready(function() {//编辑器初始化完成再赋值
                        ue.setContent(productDetail.data);
                    });
                    //加载主图
                    if(data.productFilePath){
                        $("#Img").attr("src","http://image.jfy.com"+data.productFilePath);
                        $("#previewPictureId").show();
                    }
                }
            }).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除该商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/productController/deleteProduct.do",params, function(data){
            			if(data.code == 0){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#productList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }/*,'-',{
        text:'下架',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定下架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/product/instock",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','下架商品成功!',undefined,function(){
            					$("#productList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },{
        text:'上架',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定上架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/product/reshelf",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','上架商品成功!',undefined,function(){
            					$("#productList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }*/];
</script>