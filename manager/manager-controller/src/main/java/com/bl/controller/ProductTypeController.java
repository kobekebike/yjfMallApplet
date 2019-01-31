package com.bl.controller;

import com.bl.base.EasyUIResult;
import com.bl.base.Response;
import com.bl.model.ProductType;
import com.bl.service.ProductTypeService;
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
@RequestMapping("productTypeController")
public class ProductTypeController {
    public static Logger log = LogManager.getLogger(ProductTypeController.class);

    @Autowired
    private ProductTypeService productTypeService;

    /**
     * 分页获取商品类型的集合
     * @param req
     * @param res
     * @param page
     * @Param rows
     * @return
     */
    @RequestMapping("getProductTypeList.do")
    @ResponseBody
    public EasyUIResult getProductTypeList(HttpServletRequest req, HttpServletResponse res,
                                       @RequestParam Integer page, @RequestParam Integer rows){
        EasyUIResult easyUIResult = new EasyUIResult();
        try {
            easyUIResult = productTypeService.getProductTypeList(page, rows);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return easyUIResult;
    }

    /**
     * 保存商品类型
     * @param req
     * @param res
     * @param productType 对象
     * @return
     */
    @RequestMapping("saveProductType.do")
    @ResponseBody
    public Response saveProductType(HttpServletRequest req, HttpServletResponse res,
                                    ProductType productType){
        return productTypeService.saveProductType(productType);
    }

    /**
     * 修改商品类型
     * @param req
     * @param res
     * @param productType
     * @return
     */
    @RequestMapping("updateProductType.do")
    @ResponseBody
    public Response updateProductType(HttpServletRequest req, HttpServletResponse res,
                                      ProductType productType){
        return productTypeService.updateProductType(productType);
    }

    /**
     * 删除商品类型
     * @param req
     * @param res
     * @param ids
     * @return
     */
    @RequestMapping("deleteProductType.do")
    @ResponseBody
    public Response deleteProductType(HttpServletRequest req, HttpServletResponse res,
                                      String ids){
        return productTypeService.deleteProductType(ids);
    }
}
