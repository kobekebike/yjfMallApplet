package com.bl.model;

import java.util.Date;

public class Address {
    /**
     * 唯一标识
     */
    private Integer addressId;

    /**
     * 关联用户标识
     */
    private Integer userId;

    /**
     * 所在地区编码
     */
    private String cityCode;

    /**
     * 所在地区名称
     */
    private String cityName;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 详细地址
     */
    private String detailAddress;

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
     * 是否默认地址
     */
    private Boolean isDefault;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 唯一标识
     * @return address_id 唯一标识
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * 唯一标识
     * @param addressId 唯一标识
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    /**
     * 关联用户标识
     * @return user_id 关联用户标识
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 关联用户标识
     * @param userId 关联用户标识
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 所在地区编码
     * @return city_code 所在地区编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 所在地区编码
     * @param cityCode 所在地区编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 所在地区名称
     * @return city_name 所在地区名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 所在地区名称
     * @param cityName 所在地区名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
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
     * 详细地址
     * @return detail_address 详细地址
     */
    public String getDetailAddress() {
        return detailAddress;
    }

    /**
     * 详细地址
     * @param detailAddress 详细地址
     */
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
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
     * 是否默认地址
     * @return is_default 是否默认地址
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * 是否默认地址
     * @param isDefault 是否默认地址
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
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
        sb.append(", addressId=").append(addressId);
        sb.append(", userId=").append(userId);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", cityName=").append(cityName);
        sb.append(", phone=").append(phone);
        sb.append(", detailAddress=").append(detailAddress);
        sb.append(", createName=").append(createName);
        sb.append(", createId=").append(createId);
        sb.append(", createTime=").append(createTime);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}