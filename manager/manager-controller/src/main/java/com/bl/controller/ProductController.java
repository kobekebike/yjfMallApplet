package com.bl.controller;

import com.bl.base.BasicUtils;
import com.bl.base.EasyUIResult;
import com.bl.base.Response;
import com.bl.model.Product;
import com.bl.service.ProductService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("productController")
public class ProductController {
    public static Logger log = LogManager.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    /**
     * 分页获取商品的集合
     * @param req
     * @param res
     * @param page
     * @Param rows
     * @return
     */
    @RequestMapping("getProductList.do")
    @ResponseBody
    public EasyUIResult getProductList(HttpServletRequest req, HttpServletResponse res,
                                       @RequestParam Integer page, @RequestParam Integer rows){
        EasyUIResult easyUIResult = new EasyUIResult();
        try {
            easyUIResult = productService.getProductList(page, rows);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return easyUIResult;
    }
    
    /**
     * 保存商品
     * @param req
     * @param res
     * @param product 对象
     * @return
     */
    @RequestMapping("saveProduct.do")
    @ResponseBody
    public Response saveProduct(HttpServletRequest req, HttpServletResponse res,
                                Product product){
        return productService.saveProduct(product, BasicUtils.getLoginInfo(req));
    }

    /**
     * 修改商品
     * @param req
     * @param res
     * @param product
     * @return
     */
    @RequestMapping("updateProduct.do")
    @ResponseBody
    public Response updateProduct(HttpServletRequest req, HttpServletResponse res,
                                  Product product){
        return productService.updateProduct(product);
    }

    /**
     * 删除商品
     * @param req
     * @param res
     * @param ids
     * @return
     */
    @RequestMapping("deleteProduct.do")
    @ResponseBody
    public Response deleteProduct(HttpServletRequest req, HttpServletResponse res,
                                      String ids){
        return productService.deleteProduct(ids);
    }
}
