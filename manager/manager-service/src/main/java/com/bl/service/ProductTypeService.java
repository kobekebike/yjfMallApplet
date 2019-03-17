package com.bl.service;

import com.bl.base.EasyUIResult;
import com.bl.base.Response;
import com.bl.dao.ProductTypeMapper;
import com.bl.model.ProductType;
import com.bl.model.ProductTypeCriteria;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    /**
     * 分页获取商品类型的集合
     * @param page
     * @param rows
     * @return
     */
    public EasyUIResult getProductTypeList(Integer page, Integer rows){
        ProductTypeCriteria productTypeCriteria = new ProductTypeCriteria();
        productTypeCriteria.setLimitStart((page - 1) * rows);
        productTypeCriteria.setLimitEnd(rows);
        productTypeCriteria.setOrderByClause("update_time desc");
        List<ProductType> list = productTypeMapper.selectByExample(productTypeCriteria);
        return new EasyUIResult(list.size(), list);
    }

    /**
     * 保存商品类型
     * @param productType
     * @return
     */
    public Response saveProductType(ProductType productType){
        //查询类型排序有没有重复
        if (checkSort(productType)) return Response.createFailResult("分类排序重复,请重新输入", null);

        productType.setCreateTime(new Date());
        productType.setUpdateTime(new Date());
        if(productTypeMapper.insertSelective(productType) == 1){
            return Response.createSuccessResult("保存成功", null);
        }else{
            return Response.createFailResult("保存失败", null);
        }
    }

    /**
     * 查询类型排序有没有重复
     * @param productType
     * @return
     */
    public boolean checkSort(ProductType productType) {
        ProductTypeCriteria productTypeCriteria = new ProductTypeCriteria();
        productTypeCriteria.createCriteria().andSortEqualTo(productType.getSort());
        List<ProductType> list = productTypeMapper.selectByExample(productTypeCriteria);
        if(list != null && !list.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * 修改商品类型
     * @param productType
     * @return
     */
    public Response updateProductType(ProductType productType){
        //查询类型排序有没有重复
        if (checkSort(productType)) return Response.createFailResult("分类排序重复,请重新输入", null);

        productType.setUpdateTime(new Date());
        if(productTypeMapper.updateByPrimaryKeySelective(productType) == 1){
            return Response.createSuccessResult("保存成功", null);
        }else{
            return Response.createFailResult("保存失败", null);
        }
    }

    /**
     * 删除商品类型
     * @param ids
     * @return
     */
    public Response deleteProductType(String ids) {
        String[] idArr = ids.split(",");
        List<Integer> intList = new ArrayList<>();
        for(String id : idArr){
            if(StringUtils.isNotBlank(id)){
                intList.add(Integer.valueOf(id));
            }
        }
        if(intList != null && !intList.isEmpty()){
            ProductTypeCriteria productTypeCriteria = new ProductTypeCriteria();
            productTypeCriteria.createCriteria().andTypeIdIn(intList);
            int i = productTypeMapper.deleteByExample(productTypeCriteria);
            if(i > 0){
                return Response.createSuccessResult("删除成功", null);
            }
        }
        return Response.createFailResult("删除失败", null);
    }

    /**
     * 获取所有的类型
     * @return
     */
    public Response getAllProductTypeList() {
        ProductTypeCriteria productTypeCriteria = new ProductTypeCriteria();
        productTypeCriteria.setOrderByClause("sort");
        return Response.createSuccessResult("查询成功", productTypeMapper.selectByExample(productTypeCriteria));
    }
}
