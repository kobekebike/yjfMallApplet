package com.bl.service;

import com.bl.base.EasyUIResult;
import com.bl.base.LoginBean;
import com.bl.base.Response;
import com.bl.dao.ProductMapper;
import com.bl.model.Product;
import com.bl.model.ProductCriteria;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 分页获取商品的集合
     * @param page
     * @param rows
     * @return
     */
    public EasyUIResult getProductList(Integer page, Integer rows){
        ProductCriteria productCriteria = new ProductCriteria();
        productCriteria.setLimitStart((page - 1) * rows);
        productCriteria.setLimitEnd(rows);
        productCriteria.setOrderByClause("update_time desc");
        List<Product> list = productMapper.selectByExample(productCriteria);
        return new EasyUIResult(list.size(), list);
    }

    /**
     * 保存商品
     * @param product
     * @return
     */
    public Response saveProduct(Product product, LoginBean loginBean) {
        product.setCreateId(loginBean.getUserId());
        product.setCreateName(loginBean.getUserName());
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        if(productMapper.insertSelective(product) == 1){
            return Response.createSuccessResult("保存成功", null);
        }else{
            return Response.createFailResult("保存失败", null);
        }
    }

    /**
     * 修改商品
     * @param product
     * @return
     */
    public Response updateProduct(Product product) {
        product.setUpdateTime(new Date());
        if(productMapper.updateByPrimaryKeySelective(product) == 1){
            return Response.createSuccessResult("保存成功", null);
        }else{
            return Response.createFailResult("保存失败", null);
        }
    }

    /**
     * 删除商品
     * @param ids
     * @return
     */
    public Response deleteProduct(String ids) {
        String[] idArr = ids.split(",");
        List<Integer> intList = new ArrayList<>();
        for(String id : idArr){
            if(StringUtils.isNotBlank(id)){
                intList.add(Integer.valueOf(id));
            }
        }
        if(intList != null && !intList.isEmpty()){
            ProductCriteria productCriteria = new ProductCriteria();
            productCriteria.createCriteria().andProductIdIn(intList);
            int i = productMapper.deleteByExample(productCriteria);
            if(i > 0){
                return Response.createSuccessResult("删除成功", null);
            }
        }
        return Response.createFailResult("删除失败", null);
    }
}
