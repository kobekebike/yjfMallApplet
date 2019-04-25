package com.bl.service;

import com.bl.base.EasyUIResult;
import com.bl.base.LoginBean;
import com.bl.base.Response;
import com.bl.constants.Constant;
import com.bl.dao.ProductMapper;
import com.bl.model.Product;
import com.bl.model.ProductCriteria;
import com.bl.model.ProductKey;
import com.bl.model.ProductWithBLOBs;
import com.bl.utils.FileUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
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
        productCriteria.setOrderByClause("product_sort");
        List<Product> list = productMapper.selectByExample(productCriteria);
        return new EasyUIResult(list.size(), list);
    }

    /**
     * 保存商品
     * @param productWithBLOBs
     * @param file
     * @param productDetailText
     * @return
     */
    public Response saveProduct(ProductWithBLOBs productWithBLOBs, LoginBean loginBean, MultipartFile file, String productDetailText) throws Exception{
        if(file != null){
            // 判断文件是否为空
            if (!file.isEmpty()) {
                if(FileUtil.isImageByNameSuffix(file)){
                    return Response.createFailResult("上传的主图不是图片", null);
                }
                String filePath = saveMainImage(file);
                productWithBLOBs.setProductFilePath(filePath);
            }
        }
        if(productDetailText != null){
            try {
                productWithBLOBs.setProductDetail(productDetailText.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        //已售数量没有则默认为0
        if(productWithBLOBs.getSoldOutNum() == null){
            productWithBLOBs.setSoldOutNum(0);
        }
        //商品折扣没有则默认为0
        if(productWithBLOBs.getProductDiscount() == null){
            productWithBLOBs.setProductDiscount(0);
        }
        //商品状态:原始状态为下架(1下架,2上架)
        productWithBLOBs.setProductStatus(1);
        productWithBLOBs.setCreateId(loginBean.getUserId());
        productWithBLOBs.setCreateName(loginBean.getUserName());
        productWithBLOBs.setCreateTime(new Date());
        productWithBLOBs.setUpdateTime(new Date());
        if(productMapper.insertSelective(productWithBLOBs) == 1){
            return Response.createSuccessResult("保存成功", null);
        }else{
            return Response.createFailResult("保存失败", null);
        }
    }

    /**
     * 保存主图
     * @param file
     * @return
     */
    private String saveMainImage(MultipartFile file) {
        String yjfHome = System.getProperty("yjf_home");
        if(StringUtils.isBlank(yjfHome)){
            yjfHome = Constant.YJF_HOME;
        }

        String random = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + random;
        String filePath = "/upload/mallImage/" + new SimpleDateFormat("yyyy/MM").format(new Date()) + "/" +
                fileName + "." + file.getOriginalFilename().split("\\.")[1];
        File saveDir = new File(yjfHome + filePath);
        if (!saveDir.getParentFile().exists()) {
            saveDir.getParentFile().mkdirs();
        }
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(saveDir);
            IOUtils.copy(file.getInputStream(), output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
            }
        }
        return filePath;
    }

    /**
     * 修改商品
     * @param productWithBLOBs
     * @return
     */
    public Response updateProduct(ProductWithBLOBs productWithBLOBs, MultipartFile file, String productDetailText) {
        if(file != null){
            // 判断文件是否为空
            if (!file.isEmpty()) {
                if(FileUtil.isImageByNameSuffix(file)){
                    return Response.createFailResult("上传的主图不是图片", null);
                }
                String filePath = saveMainImage(file);
                //原来有主图时，删除原来的主图，再修改
                if(StringUtils.isNotBlank(productWithBLOBs.getProductFilePath())){
                    String yjfHome = System.getProperty("yjf_home");
                    if(StringUtils.isBlank(yjfHome)){
                        yjfHome = Constant.YJF_HOME;
                    }
                    new File(yjfHome + productWithBLOBs.getProductFilePath()).delete();
                }
                productWithBLOBs.setProductFilePath(filePath);
            }
        }
        if(productDetailText != null){
            try {
                productWithBLOBs.setProductDetail(productDetailText.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        productWithBLOBs.setUpdateTime(new Date());
        if(productMapper.updateByPrimaryKeySelective(productWithBLOBs) == 1){
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
        String yjfHome = System.getProperty("yjf_home");
        if(StringUtils.isBlank(yjfHome)){
            yjfHome = Constant.YJF_HOME;
        }
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

            List<Product> list = productMapper.selectByExample(productCriteria);
            if(list != null && !list.isEmpty()){
                for(Product product : list){
                    //有主图时，删除主图
                    if(StringUtils.isNotBlank(product.getProductFilePath())){
                        new File(yjfHome + product.getProductFilePath()).delete();
                    }
                }
            }

            int i = productMapper.deleteByExample(productCriteria);
            if(i > 0){
                return Response.createSuccessResult("删除成功", null);
            }
        }
        return Response.createFailResult("删除失败", null);
    }

    /**
     * 根据商品标识获取商品详情
     * @param productId
     * @return
     */
    public Response getProductDetail(Integer productId){
        String productDetail = "";
        ProductKey productKey = new ProductKey();
        productKey.setProductId(productId);
        ProductWithBLOBs productWithBLOBs = productMapper.selectByPrimaryKey(productKey);
        if(productWithBLOBs != null){
            try {
                productDetail = new String(productWithBLOBs.getProductDetail(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return Response.createSuccessResult("获取商品详情", productDetail);
    }

    /**
     * 根据条件获取商品的集合
     * @Param searchText 搜索内容
     * @return
     */
    public Response getProductListByCriteria(String searchText){
        ProductCriteria productCriteria = new ProductCriteria();
        productCriteria.setOrderByClause("product_sort");
        if(StringUtils.isNotBlank(searchText)){
            productCriteria.createCriteria()
                    .andProductTitleLike("%"+searchText+"%").andProductStatusEqualTo(2);
            ProductCriteria.Criteria criteria = productCriteria.createCriteria();
            criteria.andProductStatusEqualTo(2);
                criteria.andProductCodeLike("%"+searchText+"%");
            productCriteria.or(criteria);
        }else{
            productCriteria.createCriteria().andProductStatusEqualTo(2);
        }
        return Response.createSuccessResult("根据条件获取商品列表", productMapper.selectByExample(productCriteria));
    }

    /**
     * 修改商品的状态
     *      上下架
     * @param status
     * @param productId
     * @return
     */
    public Response updateProductStatus(Integer status, Integer productId) {
        ProductWithBLOBs productWithBLOBs = new ProductWithBLOBs();
        productWithBLOBs.setProductStatus(status);
        productWithBLOBs.setProductId(productId);
        productWithBLOBs.setUpdateTime(new Date());
        if(productMapper.updateByPrimaryKeySelective(productWithBLOBs) == 1){
            return Response.createSuccessResult("修改成功", null);
        }else{
            return Response.createFailResult("修改失败", null);
        }
    }
}
