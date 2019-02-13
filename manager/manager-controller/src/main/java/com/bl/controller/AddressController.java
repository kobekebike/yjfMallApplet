package com.bl.controller;

import com.bl.base.Response;
import com.bl.model.Address;
import com.bl.service.AddressService;
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
@RequestMapping("addressController")
public class AddressController {
    public static Logger log = LogManager.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    /**
     * 根据用户标识获取地址集合
     * @param req
     * @param res
     * @param userId    用户标识
     * @return
     */
    @RequestMapping("getAddressListByUserId.do")
    @ResponseBody
    public Response getAddressListByUserId(HttpServletRequest req, HttpServletResponse res,
                                                   @RequestParam(value = "userId", defaultValue = "0") Integer userId){
        return addressService.getAddressListByUserId(userId);
    }

    /**
     * 保存地址信息
     * @param req
     * @param res
     * @param address
     * @return
     */
    @RequestMapping("saveAddress.do")
    @ResponseBody
    public Response saveAddress(HttpServletRequest req, HttpServletResponse res,
                                    Address address){
        return addressService.saveProductType(address);
    }

    /**
     * 修改地址信息
     * @param req
     * @param res
     * @param address
     * @return
     */
    @RequestMapping("updateDefaultAddress.do")
    @ResponseBody
    public Response updateDefaultAddress(HttpServletRequest req, HttpServletResponse res,
                                         Address address){
        return addressService.updateDefaultAddress(address);
    }
}