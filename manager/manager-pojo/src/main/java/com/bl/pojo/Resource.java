package com.bl.pojo;

public class Resource {
    /**
     * 资源标志
     */
    private Integer resourceId;

    /**
     * 父亲资源标志
     */
    private Integer resourceParentId;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 
     */
    private String resourceUrl;

    /**
     * 资源类型 1菜单，2 按钮 3 服务
     */
    private Byte resourceTypeId;

    /**
     * 
     */
    private String service;

    /**
     * 关联的后台服务
     */
    private String method;

    /**
     * 
     */
    private Byte sort;

    /**
     * 
     */
    private Boolean isShow;

    /**
     * 
     */
    private Integer hasClassify;

    /**
     * 
     */
    private String classifyUrl;

    /**
     * 资源标志
     * @return resource_id 资源标志
     */
    public Integer getResourceId() {
        return resourceId;
    }

    /**
     * 资源标志
     * @param resourceId 资源标志
     */
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 父亲资源标志
     * @return resource_parent_id 父亲资源标志
     */
    public Integer getResourceParentId() {
        return resourceParentId;
    }

    /**
     * 父亲资源标志
     * @param resourceParentId 父亲资源标志
     */
    public void setResourceParentId(Integer resourceParentId) {
        this.resourceParentId = resourceParentId;
    }

    /**
     * 资源名称
     * @return resource_name 资源名称
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * 资源名称
     * @param resourceName 资源名称
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    /**
     * 
     * @return resource_url 
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * 
     * @param resourceUrl 
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    /**
     * 资源类型 1菜单，2 按钮 3 服务
     * @return resource_type_id 资源类型 1菜单，2 按钮 3 服务
     */
    public Byte getResourceTypeId() {
        return resourceTypeId;
    }

    /**
     * 资源类型 1菜单，2 按钮 3 服务
     * @param resourceTypeId 资源类型 1菜单，2 按钮 3 服务
     */
    public void setResourceTypeId(Byte resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    /**
     * 
     * @return service 
     */
    public String getService() {
        return service;
    }

    /**
     * 
     * @param service 
     */
    public void setService(String service) {
        this.service = service == null ? null : service.trim();
    }

    /**
     * 关联的后台服务
     * @return method 关联的后台服务
     */
    public String getMethod() {
        return method;
    }

    /**
     * 关联的后台服务
     * @param method 关联的后台服务
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * 
     * @return sort 
     */
    public Byte getSort() {
        return sort;
    }

    /**
     * 
     * @param sort 
     */
    public void setSort(Byte sort) {
        this.sort = sort;
    }

    /**
     * 
     * @return is_show 
     */
    public Boolean getIsShow() {
        return isShow;
    }

    /**
     * 
     * @param isShow 
     */
    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    /**
     * 
     * @return has_classify 
     */
    public Integer getHasClassify() {
        return hasClassify;
    }

    /**
     * 
     * @param hasClassify 
     */
    public void setHasClassify(Integer hasClassify) {
        this.hasClassify = hasClassify;
    }

    /**
     * 
     * @return classify_url 
     */
    public String getClassifyUrl() {
        return classifyUrl;
    }

    /**
     * 
     * @param classifyUrl 
     */
    public void setClassifyUrl(String classifyUrl) {
        this.classifyUrl = classifyUrl == null ? null : classifyUrl.trim();
    }
}