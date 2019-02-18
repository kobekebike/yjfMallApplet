<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid"  style="width:1000px;height:650px" id="productList" title="商品列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/productController/getProductList.do',
                    method:'get',pageSize:20,toolbar:toolbar,fitColumns:true">
    <thead>
        <tr>
        	<th data-options="field:'productId',checkbox:true"></th>
        	<th data-options="field:'productCode',width:100">商品编号</th>
            <th data-options="field:'productTitle',formatter:showProductInfo,width:200">商品标题</th>
            <th data-options="field:'productType',width:100">商品类型</th>
            <th data-options="field:'productPrice',width:100">商品价格</th>
            <th data-options="field:'productStatus',formatter:productStatusFormatter,width:100">商品状态</th>
            <th data-options="field:'createTime',width:150,formatter:dateTimeFormatter">创建时间</th>
            <th data-options="field:'updateTime',width:150,formatter:dateTimeFormatter">修改时间</th>
            <th data-options="field:'productSort',width:70">商品排序</th>
            <th data-options="field:'operater',width:100,formatter:operation">操作</th>
        </tr>
    </thead>
</table>
<div id="productAddAndEditWindow" class="easyui-window" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:60%;height:60%;padding:10px;"></div>
<script type="text/javascript">

    function getSelectionsProductIds(){
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
        	var ids = getSelectionsProductIds();
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
                    console.log(data)
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
        	var ids = getSelectionsProductIds();
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
    }];

    function showProductInfo(value,row){
        return "<a href='javascript:void(0)' onclick=\"showProductEdit("+JSON.stringify(row).replace(/"/g, '&quot;')+")\" style='color: blue;'>"+value+"</a>";
    }
    function productStatusFormatter(value,row){
        if(value == 1){
            return "已下架"
        }else if(value == 2){
            return "已上架";
        }
    }

    function showProductEdit(obj){
        $("#productAddAndEditWindow").window({
            href:'/product/productAdd.do',
            title:"编辑商品",
            onLoad :function(){
                $("#updateProductId").show();
                $("#submitProductId").hide();
                //回显数据
                $("#productAddForm").form("load",obj);

                // 加载商品详情
                var productDetail = requestAjaxData("/productController/getProductDetail.do?productId="+obj.productId, false, true);
                ue.ready(function() {//编辑器初始化完成再赋值
                    ue.setContent(productDetail.data);
                });
                //加载主图
                if(obj.productFilePath){
                    $("#Img").attr("src","http://image.jfy.com"+obj.productFilePath);
                    $("#previewPictureId").show();
                }
            }
        }).window("open");
        //阻止冒泡
        event.stopPropagation();
    }

    function operation(value,row){
        var statusText = "";
        if(row.productStatus == 1){
            statusText = "上 架";
        }else if(row.productStatus == 2){
            statusText = "下 架";
        }
        return '<input type="button" value="'+statusText+'" onclick="updateProductStatus(\'' + row.productStatus + "','" + row.productId +'\')"/>';
    }
    function updateProductStatus(status, productId){
        var statusText = "";
        var updateStatus = "";
        if(status == 1){
            statusText = "上架";
            updateStatus = 2;
        }else if(status == 2){
            statusText = "下架";
            updateStatus = 1;
        }
        $.messager.confirm('确认','确定' + statusText + '该商品吗？',function(r){
            if (r){
                var params = {"status":updateStatus,"productId":productId};
                $.post("/productController/updateProductStatus.do",params, function(data){
                    if(data.code == 0){
                        $.messager.alert('提示',statusText + '商品成功!',undefined,function(){
                            $("#productList").datagrid("reload");
                        });
                    }
                });
            }
        });
        event.stopPropagation();
    }
</script>