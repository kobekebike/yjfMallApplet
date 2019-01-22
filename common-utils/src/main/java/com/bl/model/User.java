package com.bl.model;

import java.util.Date;

public class User {
    /**
     * 用户主键
     */
    private Integer userId;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 手机号码，可用于系统登录
     */
    private String userMobilephone;

    /**
     * 用户邮箱，可用于系统登录
     */
    private String userMail;

    /**
     * 公司id
     */
    private Integer companyId;

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 是否是超级管理员。0：否；1：是
     */
    private Boolean isAdministrator;

    /**
     * 
     */
    private Integer sort;

    /**
     * 
     */
    private String wxUserId;

    /**
     * 
     */
    private Integer loginState;

    /**
     * 0：正常，1：禁用，10：待删除
     */
    private Byte status;

    /**
     * 区分注册类型：0客户  1物业   2保安
     */
    private Integer customerType;

    /**
     * 区分注册用户来源:0服务号注册 1后台创建 2新增客户时自动创建
     */
    private Integer userSource;

    /**
     * 1:未审批,2:审批
     */
    private String approvalState;

    /**
     * 辅助公司管理员admin后缀
     */
    private String adminSuffix;

    /**
     * 用户主键
     * @return user_id 用户主键
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户主键
     * @param userId 用户主键
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 用户账号
     * @return user_account 用户账号
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * 用户账号
     * @param userAccount 用户账号
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    /**
     * 用户密码
     * @return user_password 用户密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 用户密码
     * @param userPassword 用户密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
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
     * 手机号码，可用于系统登录
     * @return user_mobilephone 手机号码，可用于系统登录
     */
    public String getUserMobilephone() {
        return userMobilephone;
    }

    /**
     * 手机号码，可用于系统登录
     * @param userMobilephone 手机号码，可用于系统登录
     */
    public void setUserMobilephone(String userMobilephone) {
        this.userMobilephone = userMobilephone == null ? null : userMobilephone.trim();
    }

    /**
     * 用户邮箱，可用于系统登录
     * @return user_mail 用户邮箱，可用于系统登录
     */
    public String getUserMail() {
        return userMail;
    }

    /**
     * 用户邮箱，可用于系统登录
     * @param userMail 用户邮箱，可用于系统登录
     */
    public void setUserMail(String userMail) {
        this.userMail = userMail == null ? null : userMail.trim();
    }

    /**
     * 公司id
     * @return company_id 公司id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 公司id
     * @param companyId 公司id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 部门id
     * @return dept_id 部门id
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 部门id
     * @param deptId 部门id
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 创建人
     * @return creator 创建人
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * 创建人
     * @param creator 创建人
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * 是否是超级管理员。0：否；1：是
     * @return is_administrator 是否是超级管理员。0：否；1：是
     */
    public Boolean getIsAdministrator() {
        return isAdministrator;
    }

    /**
     * 是否是超级管理员。0：否；1：是
     * @param isAdministrator 是否是超级管理员。0：否；1：是
     */
    public void setIsAdministrator(Boolean isAdministrator) {
        this.isAdministrator = isAdministrator;
    }

    /**
     * 
     * @return sort 
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 
     * @param sort 
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 
     * @return wx_user_id 
     */
    public String getWxUserId() {
        return wxUserId;
    }

    /**
     * 
     * @param wxUserId 
     */
    public void setWxUserId(String wxUserId) {
        this.wxUserId = wxUserId == null ? null : wxUserId.trim();
    }

    /**
     * 
     * @return login_state 
     */
    public Integer getLoginState() {
        return loginState;
    }

    /**
     * 
     * @param loginState 
     */
    public void setLoginState(Integer loginState) {
        this.loginState = loginState;
    }

    /**
     * 0：正常，1：禁用，10：待删除
     * @return status 0：正常，1：禁用，10：待删除
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 0：正常，1：禁用，10：待删除
     * @param status 0：正常，1：禁用，10：待删除
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 区分注册类型：0客户  1物业   2保安
     * @return customer_type 区分注册类型：0客户  1物业   2保安
     */
    public Integer getCustomerType() {
        return customerType;
    }

    /**
     * 区分注册类型：0客户  1物业   2保安
     * @param customerType 区分注册类型：0客户  1物业   2保安
     */
    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    /**
     * 区分注册用户来源:0服务号注册 1后台创建 2新增客户时自动创建
     * @return user_source 区分注册用户来源:0服务号注册 1后台创建 2新增客户时自动创建
     */
    public Integer getUserSource() {
        return userSource;
    }

    /**
     * 区分注册用户来源:0服务号注册 1后台创建 2新增客户时自动创建
     * @param userSource 区分注册用户来源:0服务号注册 1后台创建 2新增客户时自动创建
     */
    public void setUserSource(Integer userSource) {
        this.userSource = userSource;
    }

    /**
     * 1:未审批,2:审批
     * @return approval_state 1:未审批,2:审批
     */
    public String getApprovalState() {
        return approvalState;
    }

    /**
     * 1:未审批,2:审批
     * @param approvalState 1:未审批,2:审批
     */
    public void setApprovalState(String approvalState) {
        this.approvalState = approvalState == null ? null : approvalState.trim();
    }

    /**
     * 辅助公司管理员admin后缀
     * @return admin_suffix 辅助公司管理员admin后缀
     */
    public String getAdminSuffix() {
        return adminSuffix;
    }

    /**
     * 辅助公司管理员admin后缀
     * @param adminSuffix 辅助公司管理员admin后缀
     */
    public void setAdminSuffix(String adminSuffix) {
        this.adminSuffix = adminSuffix == null ? null : adminSuffix.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userName=").append(userName);
        sb.append(", userMobilephone=").append(userMobilephone);
        sb.append(", userMail=").append(userMail);
        sb.append(", companyId=").append(companyId);
        sb.append(", deptId=").append(deptId);
        sb.append(", createDate=").append(createDate);
        sb.append(", creator=").append(creator);
        sb.append(", isAdministrator=").append(isAdministrator);
        sb.append(", sort=").append(sort);
        sb.append(", wxUserId=").append(wxUserId);
        sb.append(", loginState=").append(loginState);
        sb.append(", status=").append(status);
        sb.append(", customerType=").append(customerType);
        sb.append(", userSource=").append(userSource);
        sb.append(", approvalState=").append(approvalState);
        sb.append(", adminSuffix=").append(adminSuffix);
        sb.append("]");
        return sb.toString();
    }
}