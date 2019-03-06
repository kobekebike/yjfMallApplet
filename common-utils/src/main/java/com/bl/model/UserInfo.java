package com.bl.model;

import java.util.Date;

public class UserInfo {
    /**
     * 唯一标识
     */
    private Integer id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 创建人
     */
    private String createName;

    /**
     * 创建人标识id
     */
    private Integer createId;

    /**
     * 用户密码（后台用户需要）
     */
    private String password;

    /**
     * 微信昵称
     */
    private String wechat;

    /**
     * 微信公众号用唯一标识
     */
    private String openId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 访问时间
     */
    private Date visitTime;

    /**
     * 唯一标识
     * @return id 唯一标识
     */
    public Integer getId() {
        return id;
    }

    /**
     * 唯一标识
     * @param id 唯一标识
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户名称
     * @return user_name 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名称
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 联系电话
     * @return phone 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 联系电话
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 创建人
     * @return create_name 创建人
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 创建人
     * @param createName 创建人
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * 创建人标识id
     * @return create_id 创建人标识id
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * 创建人标识id
     * @param createId 创建人标识id
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 用户密码（后台用户需要）
     * @return password 用户密码（后台用户需要）
     */
    public String getPassword() {
        return password;
    }

    /**
     * 用户密码（后台用户需要）
     * @param password 用户密码（后台用户需要）
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 微信昵称
     * @return wechat 微信昵称
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * 微信昵称
     * @param wechat 微信昵称
     */
    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    /**
     * 微信公众号用唯一标识
     * @return open_id 微信公众号用唯一标识
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 微信公众号用唯一标识
     * @param openId 微信公众号用唯一标识
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 访问时间
     * @return visit_time 访问时间
     */
    public Date getVisitTime() {
        return visitTime;
    }

    /**
     * 访问时间
     * @param visitTime 访问时间
     */
    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", phone=").append(phone);
        sb.append(", createName=").append(createName);
        sb.append(", createId=").append(createId);
        sb.append(", password=").append(password);
        sb.append(", wechat=").append(wechat);
        sb.append(", openId=").append(openId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", visitTime=").append(visitTime);
        sb.append("]");
        return sb.toString();
    }
}