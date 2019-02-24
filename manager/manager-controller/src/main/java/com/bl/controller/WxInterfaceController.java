package com.bl.controller;

import com.alibaba.fastjson.JSON;
import com.bl.pojo.WxUserInfoVo;
import com.bl.utils.PropertiesUtil;
import com.bl.utils.httpUtils.RequestServiceImpl;
import com.bl.utils.securityUtils.SHA1;
import com.bl.utils.securityUtils.WXCore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("wxInterfaceController")
public class WxInterfaceController {

    /**
     * value有
     *      openid  用户唯一标识
     *      session_key     会话密钥
     *      unionid     用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回
     */
    private static volatile Map<String, Object> wxSessionMap = null;

    /**
     * 微信小程序登录时，获取code，调用code2Session请求，获取session_key密钥
     * @param req
     * @param res
     * @param code
     */
    @RequestMapping("getWxLoginInfo.do")
    @ResponseBody
    public void getWxLoginInfo(HttpServletRequest req, HttpServletResponse res,
                               @RequestParam(value = "code", required = true)String code){
        try {
            wxSessionMap = JSON.parseObject(new RequestServiceImpl().get("https://api.weixin.qq.com/sns/jscode2session?grant_type=authorization_code&appid="
                    + PropertiesUtil.getAppId() + "&secret=" + PropertiesUtil.getSecret() + "&js_code="+code, null), Map.class);
            System.err.println(wxSessionMap.get("openid"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 开放数据校验与解密
     * @param req
     * @param res
     * @param wxUserInfoVo
     */
    @RequestMapping("decodeUserInfo.do")
    @ResponseBody
    public void decodeUserInfo(HttpServletRequest req, HttpServletResponse res, WxUserInfoVo wxUserInfoVo){
        /*
        数据签名校验
        为了确保开放接口返回用户数据的安全性，微信会对明文数据进行签名。开发者可以根据业务需要对数据包进行签名校验，确保数据的完整性。
         */
        if(SHA1.getDigestOfString(wxUserInfoVo.getRawData()+(String)wxSessionMap.get("session_key")).toLowerCase().equals(wxUserInfoVo.getSignature())){
            Map<String, Object> map = JSON.parseObject(
                    WXCore.decrypt(PropertiesUtil.getAppId(),
                    wxUserInfoVo.getEncryptedData().replaceAll(" ", "+"),
                    (String)wxSessionMap.get("session_key"),
                    wxUserInfoVo.getIv().replaceAll(" ", "+"))
            );
            System.err.println(map);
        }else{
            //TODO
        }
    }
}
