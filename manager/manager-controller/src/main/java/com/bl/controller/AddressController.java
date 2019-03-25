package com.bl.controller;

import com.bl.base.Response;
import com.bl.model.Address;
import com.bl.service.AddressService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("addressController")
public class AddressController {
    public static Logger log = LogManager.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    /**
     * 根据用户标识获取地址集合
     *      传入第二个字段,获取默认的地址
     * @param req
     * @param res
     * @param userId    用户标识
     * @param isDefault     是否是默认地址
     * @return
     */
    @RequestMapping("getAddressListByUserId.do")
    @ResponseBody
    public Response getAddressListByUserId(HttpServletRequest req, HttpServletResponse res,
                                                   @RequestParam(value = "userId", defaultValue = "0") Integer userId,
                                           @RequestParam(value = "isDefault", defaultValue = "false", required = false) boolean isDefault){
        return addressService.getAddressListByUserId(userId, isDefault);
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
                                   Address address) throws UnsupportedEncodingException {
        res.setCharacterEncoding("utf-8");
        res.setContentType("text/json;charset=utf-8");
        String cityName = new String(req.getParameter("cityName").getBytes("iso-8859-1"),"utf-8");
        String detailAddress = new String(req.getParameter("detailAddress").getBytes("iso-8859-1"),"utf-8");
        String addressee = new String(req.getParameter("addressee").getBytes("iso-8859-1"),"utf-8");
        address.setCityName(cityName);
        address.setAddressee(addressee);
        address.setDetailAddress(detailAddress);
        return addressService.saveAddress(address);
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
                                         Address address) throws UnsupportedEncodingException{
        res.setCharacterEncoding("utf-8");
        res.setContentType("text/json;charset=utf-8");
        String cityName = new String(req.getParameter("cityName").getBytes("iso-8859-1"),"utf-8");
        String detailAddress = new String(req.getParameter("detailAddress").getBytes("iso-8859-1"),"utf-8");
        String addressee = new String(req.getParameter("addressee").getBytes("iso-8859-1"),"utf-8");
        address.setCityName(cityName);
        address.setAddressee(addressee);
        address.setDetailAddress(detailAddress);
        return addressService.updateDefaultAddress(address);
    }

    /**
     * 删除地址
     * @param req
     * @param res
     * @param addressId
     * @return
     */
    @RequestMapping("deleteAddress.do")
    @ResponseBody
    public Response deleteAddress(HttpServletRequest req, HttpServletResponse res,Integer addressId){
        return addressService.deleteAddress(addressId);
    }
}
