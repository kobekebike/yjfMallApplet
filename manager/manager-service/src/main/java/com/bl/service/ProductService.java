package com.bl.service;

import com.bl.base.EasyUIResult;
import com.bl.base.LoginBean;
import com.bl.base.Response;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
        productCriteria.setOrderByClause("update_time desc");
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
    public Response saveProduct(ProductWithBLOBs productWithBLOBs, LoginBean loginBean, MultipartFile file, String productDetailText) {
        if(file != null){
            // 判断文件是否为空
            if (!file.isEmpty()) {
                if(FileUtil.isImageByNameSuffix(file)){
                    return Response.createFailResult("上传的主图不是图片", null);
                }
                String random = String.valueOf((int)((Math.random() * 9 + 1) * 100000));
                String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + random;
                String filePath = "/upload/mallImage/" + new SimpleDateFormat("yyyy/MM").format(new Date()) + "/" +
                        fileName + "." + file.getOriginalFilename().split("\\.")[1];
                File saveDir = new File("E:/workspace/ldhome" + filePath);
                if (!saveDir.getParentFile().exists()){
                    saveDir.getParentFile().mkdirs();
                }
                FileOutputStream output = null;
                try {
                    output = new FileOutputStream(saveDir);
                    IOUtils.copy(file.getInputStream(),output);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if(output != null){
                            output.close();
                        }
                    } catch (IOException e) {
                    }
                }
                productWithBLOBs.setProductFilePath(filePath);
            }
        }
        if(productDetailText != null){
            productWithBLOBs.setProductDetail(productDetailText.getBytes());
        }
        //TODO 商品编号没加,规则待定
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
                String random = String.valueOf((int)((Math.random() * 9 + 1) * 100000));
                String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + random;
                String filePath = "/upload/mallImage/" + new SimpleDateFormat("yyyy/MM").format(new Date()) + "/" +
                        fileName + "." + file.getOriginalFilename().split("\\.")[1];
                File saveDir = new File("E:/workspace/ldhome" + filePath);
                if (!saveDir.getParentFile().exists()){
                    saveDir.getParentFile().mkdirs();
                }
                FileOutputStream output = null;
                try {
                    output = new FileOutputStream(saveDir);
                    IOUtils.copy(file.getInputStream(),output);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if(output != null){
                            output.close();
                        }
                    } catch (IOException e) {
                    }
                }
                //原来有主图时，删除原来的主图，再修改
                if(StringUtils.isNotBlank(productWithBLOBs.getProductFilePath())){
                    new File("E:/workspace/ldhome" + productWithBLOBs.getProductFilePath()).delete();
                }
                productWithBLOBs.setProductFilePath(filePath);
            }
        }
        if(productDetailText != null){
            productWithBLOBs.setProductDetail(productDetailText.getBytes());
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
                        new File("E:/workspace/ldhome" + product.getProductFilePath()).delete();
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
            productDetail = new String(productWithBLOBs.getProductDetail());
        }
        return Response.createSuccessResult("获取商品详情", productDetail);
    }
}
