package com.bl.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductCriteria {
    /**
     * product
     */
    protected String orderByClause;

    /**
     * product
     */
    protected boolean distinct;

    /**
     * product
     */
    protected List<Criteria> oredCriteria;

    /**
     * product
     */
    protected int limitStart = -1;

    /**
     * product
     */
    protected int limitEnd = -1;

    public ProductCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
    }

    /**
     * product 2019-03-23
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductDescribeIsNull() {
            addCriterion("product_describe is null");
            return (Criteria) this;
        }

        public Criteria andProductDescribeIsNotNull() {
            addCriterion("product_describe is not null");
            return (Criteria) this;
        }

        public Criteria andProductDescribeEqualTo(String value) {
            addCriterion("product_describe =", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeNotEqualTo(String value) {
            addCriterion("product_describe <>", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeGreaterThan(String value) {
            addCriterion("product_describe >", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("product_describe >=", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeLessThan(String value) {
            addCriterion("product_describe <", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeLessThanOrEqualTo(String value) {
            addCriterion("product_describe <=", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeLike(String value) {
            addCriterion("product_describe like", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeNotLike(String value) {
            addCriterion("product_describe not like", value, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeIn(List<String> values) {
            addCriterion("product_describe in", values, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeNotIn(List<String> values) {
            addCriterion("product_describe not in", values, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeBetween(String value1, String value2) {
            addCriterion("product_describe between", value1, value2, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductDescribeNotBetween(String value1, String value2) {
            addCriterion("product_describe not between", value1, value2, "productDescribe");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNull() {
            addCriterion("product_price is null");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNotNull() {
            addCriterion("product_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductPriceEqualTo(BigDecimal value) {
            addCriterion("product_price =", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotEqualTo(BigDecimal value) {
            addCriterion("product_price <>", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThan(BigDecimal value) {
            addCriterion("product_price >", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_price >=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThan(BigDecimal value) {
            addCriterion("product_price <", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_price <=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceIn(List<BigDecimal> values) {
            addCriterion("product_price in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotIn(List<BigDecimal> values) {
            addCriterion("product_price not in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_price between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_price not between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNull() {
            addCriterion("create_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNotNull() {
            addCriterion("create_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("create_name =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("create_name <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("create_name >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_name >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThan(String value) {
            addCriterion("create_name <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("create_name <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLike(String value) {
            addCriterion("create_name like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotLike(String value) {
            addCriterion("create_name not like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("create_name in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("create_name not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("create_name between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("create_name not between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(Integer value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(Integer value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(Integer value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(Integer value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<Integer> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<Integer> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(Integer value1, Integer value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_id not between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andProductStatusIsNull() {
            addCriterion("product_status is null");
            return (Criteria) this;
        }

        public Criteria andProductStatusIsNotNull() {
            addCriterion("product_status is not null");
            return (Criteria) this;
        }

        public Criteria andProductStatusEqualTo(Integer value) {
            addCriterion("product_status =", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusNotEqualTo(Integer value) {
            addCriterion("product_status <>", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusGreaterThan(Integer value) {
            addCriterion("product_status >", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_status >=", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusLessThan(Integer value) {
            addCriterion("product_status <", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusLessThanOrEqualTo(Integer value) {
            addCriterion("product_status <=", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusIn(List<Integer> values) {
            addCriterion("product_status in", values, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusNotIn(List<Integer> values) {
            addCriterion("product_status not in", values, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusBetween(Integer value1, Integer value2) {
            addCriterion("product_status between", value1, value2, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("product_status not between", value1, value2, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNull() {
            addCriterion("product_type is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("product_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(String value) {
            addCriterion("product_type =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(String value) {
            addCriterion("product_type <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(String value) {
            addCriterion("product_type >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(String value) {
            addCriterion("product_type >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(String value) {
            addCriterion("product_type <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(String value) {
            addCriterion("product_type <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLike(String value) {
            addCriterion("product_type like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotLike(String value) {
            addCriterion("product_type not like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<String> values) {
            addCriterion("product_type in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<String> values) {
            addCriterion("product_type not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(String value1, String value2) {
            addCriterion("product_type between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(String value1, String value2) {
            addCriterion("product_type not between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIsNull() {
            addCriterion("product_type_id is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIsNotNull() {
            addCriterion("product_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdEqualTo(Integer value) {
            addCriterion("product_type_id =", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotEqualTo(Integer value) {
            addCriterion("product_type_id <>", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdGreaterThan(Integer value) {
            addCriterion("product_type_id >", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_type_id >=", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdLessThan(Integer value) {
            addCriterion("product_type_id <", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_type_id <=", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIn(List<Integer> values) {
            addCriterion("product_type_id in", values, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotIn(List<Integer> values) {
            addCriterion("product_type_id not in", values, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("product_type_id between", value1, value2, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_type_id not between", value1, value2, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductDiscountIsNull() {
            addCriterion("product_discount is null");
            return (Criteria) this;
        }

        public Criteria andProductDiscountIsNotNull() {
            addCriterion("product_discount is not null");
            return (Criteria) this;
        }

        public Criteria andProductDiscountEqualTo(Integer value) {
            addCriterion("product_discount =", value, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountNotEqualTo(Integer value) {
            addCriterion("product_discount <>", value, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountGreaterThan(Integer value) {
            addCriterion("product_discount >", value, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_discount >=", value, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountLessThan(Integer value) {
            addCriterion("product_discount <", value, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("product_discount <=", value, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountIn(List<Integer> values) {
            addCriterion("product_discount in", values, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountNotIn(List<Integer> values) {
            addCriterion("product_discount not in", values, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountBetween(Integer value1, Integer value2) {
            addCriterion("product_discount between", value1, value2, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("product_discount not between", value1, value2, "productDiscount");
            return (Criteria) this;
        }

        public Criteria andProductTitleIsNull() {
            addCriterion("product_title is null");
            return (Criteria) this;
        }

        public Criteria andProductTitleIsNotNull() {
            addCriterion("product_title is not null");
            return (Criteria) this;
        }

        public Criteria andProductTitleEqualTo(String value) {
            addCriterion("product_title =", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleNotEqualTo(String value) {
            addCriterion("product_title <>", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleGreaterThan(String value) {
            addCriterion("product_title >", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleGreaterThanOrEqualTo(String value) {
            addCriterion("product_title >=", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleLessThan(String value) {
            addCriterion("product_title <", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleLessThanOrEqualTo(String value) {
            addCriterion("product_title <=", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleLike(String value) {
            addCriterion("product_title like", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleNotLike(String value) {
            addCriterion("product_title not like", value, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleIn(List<String> values) {
            addCriterion("product_title in", values, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleNotIn(List<String> values) {
            addCriterion("product_title not in", values, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleBetween(String value1, String value2) {
            addCriterion("product_title between", value1, value2, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductTitleNotBetween(String value1, String value2) {
            addCriterion("product_title not between", value1, value2, "productTitle");
            return (Criteria) this;
        }

        public Criteria andProductFilePathIsNull() {
            addCriterion("product_file_path is null");
            return (Criteria) this;
        }

        public Criteria andProductFilePathIsNotNull() {
            addCriterion("product_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andProductFilePathEqualTo(String value) {
            addCriterion("product_file_path =", value, "productFilePath");
            return (Criteria) this;
        }

        public Criteria andProductFilePathNotEqualTo(String value) {
            addCriterion("product_file_path <>", value, "productFilePath");
            return (Criteria) this;
        }

        public Criteria andProductFilePathGreaterThan(String value) {
            addCriterion("product_file_path >", value, "productFilePath");
            return (Criteria) this;
        }

        public Criteria andProductFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("product_file_path >=", value, "productFilePath");
            return (Criteria) this;
        }

        public Criteria andProductFilePathLessThan(String value) {
            addCriterion("product_file_path <", value, "productFilePath");
            return (Criteria) this;
        }

        public Criteria andProductFilePathLessThanOrEqualTo(String value) {
            addCriterion("product_file_path <=", value, "productFilePath");
            return (Criteria) this;
        }

        public Criteria andProductFilePathLike(String value) {
            addCriterion("product_file_path like", value, "productFilePath");
            return (Criteria) this;
        }

        public Criteria andProductFilePathNotLike(String value) {
            addCriterion("product_file_path not like", value, "productFilePath");
            return (Criteria) this;
        }

        public Criteria andProductFilePathIn(List<String> values) {
            addCriterion("product_file_path in", values, "productFilePath");
            return (Criteria) this;
        }

        public Criteria andProductFilePathNotIn(List<String> values) {
            addCriterion("product_file_path not in", values, "productFilePath");
            return (Criteria) this;
        }

        public Criteria andProductFilePathBetween(String value1, String value2) {
            addCriterion("product_file_path between", value1, value2, "productFilePath");
            return (Criteria) this;
        }

        public Criteria andProductFilePathNotBetween(String value1, String value2) {
            addCriterion("product_file_path not between", value1, value2, "productFilePath");
            return (Criteria) this;
        }

        public Criteria andProductSortIsNull() {
            addCriterion("product_sort is null");
            return (Criteria) this;
        }

        public Criteria andProductSortIsNotNull() {
            addCriterion("product_sort is not null");
            return (Criteria) this;
        }

        public Criteria andProductSortEqualTo(Integer value) {
            addCriterion("product_sort =", value, "productSort");
            return (Criteria) this;
        }

        public Criteria andProductSortNotEqualTo(Integer value) {
            addCriterion("product_sort <>", value, "productSort");
            return (Criteria) this;
        }

        public Criteria andProductSortGreaterThan(Integer value) {
            addCriterion("product_sort >", value, "productSort");
            return (Criteria) this;
        }

        public Criteria andProductSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_sort >=", value, "productSort");
            return (Criteria) this;
        }

        public Criteria andProductSortLessThan(Integer value) {
            addCriterion("product_sort <", value, "productSort");
            return (Criteria) this;
        }

        public Criteria andProductSortLessThanOrEqualTo(Integer value) {
            addCriterion("product_sort <=", value, "productSort");
            return (Criteria) this;
        }

        public Criteria andProductSortIn(List<Integer> values) {
            addCriterion("product_sort in", values, "productSort");
            return (Criteria) this;
        }

        public Criteria andProductSortNotIn(List<Integer> values) {
            addCriterion("product_sort not in", values, "productSort");
            return (Criteria) this;
        }

        public Criteria andProductSortBetween(Integer value1, Integer value2) {
            addCriterion("product_sort between", value1, value2, "productSort");
            return (Criteria) this;
        }

        public Criteria andProductSortNotBetween(Integer value1, Integer value2) {
            addCriterion("product_sort not between", value1, value2, "productSort");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("product_code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("product_code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("product_code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("product_code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("product_code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("product_code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("product_code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("product_code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("product_code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("product_code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("product_code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("product_code not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andSoldOutNumIsNull() {
            addCriterion("sold_out_num is null");
            return (Criteria) this;
        }

        public Criteria andSoldOutNumIsNotNull() {
            addCriterion("sold_out_num is not null");
            return (Criteria) this;
        }

        public Criteria andSoldOutNumEqualTo(Integer value) {
            addCriterion("sold_out_num =", value, "soldOutNum");
            return (Criteria) this;
        }

        public Criteria andSoldOutNumNotEqualTo(Integer value) {
            addCriterion("sold_out_num <>", value, "soldOutNum");
            return (Criteria) this;
        }

        public Criteria andSoldOutNumGreaterThan(Integer value) {
            addCriterion("sold_out_num >", value, "soldOutNum");
            return (Criteria) this;
        }

        public Criteria andSoldOutNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sold_out_num >=", value, "soldOutNum");
            return (Criteria) this;
        }

        public Criteria andSoldOutNumLessThan(Integer value) {
            addCriterion("sold_out_num <", value, "soldOutNum");
            return (Criteria) this;
        }

        public Criteria andSoldOutNumLessThanOrEqualTo(Integer value) {
            addCriterion("sold_out_num <=", value, "soldOutNum");
            return (Criteria) this;
        }

        public Criteria andSoldOutNumIn(List<Integer> values) {
            addCriterion("sold_out_num in", values, "soldOutNum");
            return (Criteria) this;
        }

        public Criteria andSoldOutNumNotIn(List<Integer> values) {
            addCriterion("sold_out_num not in", values, "soldOutNum");
            return (Criteria) this;
        }

        public Criteria andSoldOutNumBetween(Integer value1, Integer value2) {
            addCriterion("sold_out_num between", value1, value2, "soldOutNum");
            return (Criteria) this;
        }

        public Criteria andSoldOutNumNotBetween(Integer value1, Integer value2) {
            addCriterion("sold_out_num not between", value1, value2, "soldOutNum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * product 2019-03-23
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}