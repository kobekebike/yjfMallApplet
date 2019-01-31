package com.bl.model;

import java.util.Date;

public class UserInfo {
    /**
     * 唯一标识
     */
    private Integer id;

    /**
     * 渠道公司标识（最新下单公司）
     */
    private Integer userName;

    /**
     * 联系电话（暂时不用）
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
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 微信昵称
     */
    private String wechat;

    /**
     * 修改时间
     */
    private Date updateTime;

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
     * 渠道公司标识（最新下单公司）
     * @return user_name 渠道公司标识（最新下单公司）
     */
    public Integer getUserName() {
        return userName;
    }

    /**
     * 渠道公司标识（最新下单公司）
     * @param userName 渠道公司标识（最新下单公司）
     */
    public void setUserName(Integer userName) {
        this.userName = userName;
    }

    /**
     * 联系电话（暂时不用）
     * @return phone 联系电话（暂时不用）
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 联系电话（暂时不用）
     * @param phone 联系电话（暂时不用）
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
     * 用户密码
     * @return password 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 用户密码
     * @param password 用户密码
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
        sb.append(", createTime=").append(createTime);
        sb.append(", password=").append(password);
        sb.append(", wechat=").append(wechat);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}