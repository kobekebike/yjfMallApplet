package com.bl.pojo;

/**
 * 微信数据
 */
public class WxUserInfoVo {
    /**
     * 包括敏感数据在内的完整用户信息的加密数据
     */
    private String encryptedData;
    /**
     * 加密算法的初始向量
     */
    private String iv;
    /**
     * 不包括敏感信息的原始数据字符串，用于计算签名
     */
    private String rawData;
    /**
     * 使用 sha1( rawData + sessionkey ) 得到字符串，用于校验用户信息
     */
    private String signature;

    /**
     * 用户登录凭证，用于换取openid和session_key等信息
     */
    private String loginCode;

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    @Override
    public String toString() {
        return "WxUserInfoVo{" +
                "encryptedData='" + encryptedData + '\'' +
                ", iv='" + iv + '\'' +
                ", rawData='" + rawData + '\'' +
                ", signature='" + signature + '\'' +
                ", loginCode='" + loginCode + '\'' +
                '}';
    }
}
