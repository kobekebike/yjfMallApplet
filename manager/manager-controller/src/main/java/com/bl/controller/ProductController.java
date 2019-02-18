package com.bl.controller;

import com.bl.base.BasicUtils;
import com.bl.base.EasyUIResult;
import com.bl.base.Response;
import com.bl.model.ProductWithBLOBs;
import com.bl.service.ProductService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
     * @param productWithBLOBs 对象
     * @param file 主图
     * @param productDetailText 商品详情
     * @return
     */
    @RequestMapping("saveProduct.do")
    @ResponseBody
    public Response saveProduct(HttpServletRequest req, HttpServletResponse res,
                                ProductWithBLOBs productWithBLOBs, @RequestParam(value = "productFile", required = false) MultipartFile file,
                                @RequestParam(value = "productDetailText", required = false) String productDetailText){
        try {
            return productService.saveProduct(productWithBLOBs, BasicUtils.getLoginInfo(req), file, productDetailText);
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }
        return Response.createFailResult("保存失败", null);
    }

    /**
     * 修改商品
     * @param req
     * @param res
     * @param productWithBLOBs
     * @return
     */
    @RequestMapping("updateProduct.do")
    @ResponseBody
    public Response updateProduct(HttpServletRequest req, HttpServletResponse res,
                                  ProductWithBLOBs productWithBLOBs, @RequestParam(value = "productFile", required = false) MultipartFile file,
                                  @RequestParam(value = "productDetailText", required = false) String productDetailText){
        return productService.updateProduct(productWithBLOBs, file, productDetailText);
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

    /**
     * 根据商品标识获取商品详情
     * @param req
     * @param res
     * @param productId
     * @return
     */
    @RequestMapping("getProductDetail.do")
    @ResponseBody
    public Response getProductDetail(HttpServletRequest req, HttpServletResponse res, Integer productId){
        return productService.getProductDetail(productId);
    }

    /**
     * 根据条件获取商品的集合
     * @param req
     * @param res
     * @return
     */
    @RequestMapping("getProductListByCriteria.do")
    @ResponseBody
    public Response getProductListByCriteria(HttpServletRequest req, HttpServletResponse res){
        //商品类型标识
        String searchText = req.getParameter("searchText");
        return productService.getProductListByCriteria(
                searchText);
    }

    /**
     * 修改商品的状态
     *      上下架
     * @param req
     * @param res
     * @param status
     * @param productId
     * @return
     */
    @RequestMapping("updateProductStatus.do")
    @ResponseBody
    public Response updateProductStatus(HttpServletRequest req, HttpServletResponse res,
                                        @RequestParam Integer status, @RequestParam Integer productId){
        return productService.updateProductStatus(status, productId);
    }
}
