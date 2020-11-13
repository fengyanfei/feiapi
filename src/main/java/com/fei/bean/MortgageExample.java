package com.fei.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MortgageExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    public MortgageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table b_mortgage
     *
     * @mbggenerated
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

        public Criteria andMortgageIdIsNull() {
            addCriterion("mortgageId is null");
            return (Criteria) this;
        }

        public Criteria andMortgageIdIsNotNull() {
            addCriterion("mortgageId is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageIdEqualTo(String value) {
            addCriterion("mortgageId =", value, "mortgageId");
            return (Criteria) this;
        }

        public Criteria andMortgageIdNotEqualTo(String value) {
            addCriterion("mortgageId <>", value, "mortgageId");
            return (Criteria) this;
        }

        public Criteria andMortgageIdGreaterThan(String value) {
            addCriterion("mortgageId >", value, "mortgageId");
            return (Criteria) this;
        }

        public Criteria andMortgageIdGreaterThanOrEqualTo(String value) {
            addCriterion("mortgageId >=", value, "mortgageId");
            return (Criteria) this;
        }

        public Criteria andMortgageIdLessThan(String value) {
            addCriterion("mortgageId <", value, "mortgageId");
            return (Criteria) this;
        }

        public Criteria andMortgageIdLessThanOrEqualTo(String value) {
            addCriterion("mortgageId <=", value, "mortgageId");
            return (Criteria) this;
        }

        public Criteria andMortgageIdLike(String value) {
            addCriterion("mortgageId like", value, "mortgageId");
            return (Criteria) this;
        }

        public Criteria andMortgageIdNotLike(String value) {
            addCriterion("mortgageId not like", value, "mortgageId");
            return (Criteria) this;
        }

        public Criteria andMortgageIdIn(List<String> values) {
            addCriterion("mortgageId in", values, "mortgageId");
            return (Criteria) this;
        }

        public Criteria andMortgageIdNotIn(List<String> values) {
            addCriterion("mortgageId not in", values, "mortgageId");
            return (Criteria) this;
        }

        public Criteria andMortgageIdBetween(String value1, String value2) {
            addCriterion("mortgageId between", value1, value2, "mortgageId");
            return (Criteria) this;
        }

        public Criteria andMortgageIdNotBetween(String value1, String value2) {
            addCriterion("mortgageId not between", value1, value2, "mortgageId");
            return (Criteria) this;
        }

        public Criteria andLoanRateIsNull() {
            addCriterion("loanRate is null");
            return (Criteria) this;
        }

        public Criteria andLoanRateIsNotNull() {
            addCriterion("loanRate is not null");
            return (Criteria) this;
        }

        public Criteria andLoanRateEqualTo(Float value) {
            addCriterion("loanRate =", value, "loanRate");
            return (Criteria) this;
        }

        public Criteria andLoanRateNotEqualTo(Float value) {
            addCriterion("loanRate <>", value, "loanRate");
            return (Criteria) this;
        }

        public Criteria andLoanRateGreaterThan(Float value) {
            addCriterion("loanRate >", value, "loanRate");
            return (Criteria) this;
        }

        public Criteria andLoanRateGreaterThanOrEqualTo(Float value) {
            addCriterion("loanRate >=", value, "loanRate");
            return (Criteria) this;
        }

        public Criteria andLoanRateLessThan(Float value) {
            addCriterion("loanRate <", value, "loanRate");
            return (Criteria) this;
        }

        public Criteria andLoanRateLessThanOrEqualTo(Float value) {
            addCriterion("loanRate <=", value, "loanRate");
            return (Criteria) this;
        }

        public Criteria andLoanRateIn(List<Float> values) {
            addCriterion("loanRate in", values, "loanRate");
            return (Criteria) this;
        }

        public Criteria andLoanRateNotIn(List<Float> values) {
            addCriterion("loanRate not in", values, "loanRate");
            return (Criteria) this;
        }

        public Criteria andLoanRateBetween(Float value1, Float value2) {
            addCriterion("loanRate between", value1, value2, "loanRate");
            return (Criteria) this;
        }

        public Criteria andLoanRateNotBetween(Float value1, Float value2) {
            addCriterion("loanRate not between", value1, value2, "loanRate");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNull() {
            addCriterion("loanType is null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNotNull() {
            addCriterion("loanType is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeEqualTo(Integer value) {
            addCriterion("loanType =", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotEqualTo(Integer value) {
            addCriterion("loanType <>", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThan(Integer value) {
            addCriterion("loanType >", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("loanType >=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThan(Integer value) {
            addCriterion("loanType <", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThanOrEqualTo(Integer value) {
            addCriterion("loanType <=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIn(List<Integer> values) {
            addCriterion("loanType in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotIn(List<Integer> values) {
            addCriterion("loanType not in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeBetween(Integer value1, Integer value2) {
            addCriterion("loanType between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("loanType not between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanDetalIsNull() {
            addCriterion("loanDetal is null");
            return (Criteria) this;
        }

        public Criteria andLoanDetalIsNotNull() {
            addCriterion("loanDetal is not null");
            return (Criteria) this;
        }

        public Criteria andLoanDetalEqualTo(String value) {
            addCriterion("loanDetal =", value, "loanDetal");
            return (Criteria) this;
        }

        public Criteria andLoanDetalNotEqualTo(String value) {
            addCriterion("loanDetal <>", value, "loanDetal");
            return (Criteria) this;
        }

        public Criteria andLoanDetalGreaterThan(String value) {
            addCriterion("loanDetal >", value, "loanDetal");
            return (Criteria) this;
        }

        public Criteria andLoanDetalGreaterThanOrEqualTo(String value) {
            addCriterion("loanDetal >=", value, "loanDetal");
            return (Criteria) this;
        }

        public Criteria andLoanDetalLessThan(String value) {
            addCriterion("loanDetal <", value, "loanDetal");
            return (Criteria) this;
        }

        public Criteria andLoanDetalLessThanOrEqualTo(String value) {
            addCriterion("loanDetal <=", value, "loanDetal");
            return (Criteria) this;
        }

        public Criteria andLoanDetalLike(String value) {
            addCriterion("loanDetal like", value, "loanDetal");
            return (Criteria) this;
        }

        public Criteria andLoanDetalNotLike(String value) {
            addCriterion("loanDetal not like", value, "loanDetal");
            return (Criteria) this;
        }

        public Criteria andLoanDetalIn(List<String> values) {
            addCriterion("loanDetal in", values, "loanDetal");
            return (Criteria) this;
        }

        public Criteria andLoanDetalNotIn(List<String> values) {
            addCriterion("loanDetal not in", values, "loanDetal");
            return (Criteria) this;
        }

        public Criteria andLoanDetalBetween(String value1, String value2) {
            addCriterion("loanDetal between", value1, value2, "loanDetal");
            return (Criteria) this;
        }

        public Criteria andLoanDetalNotBetween(String value1, String value2) {
            addCriterion("loanDetal not between", value1, value2, "loanDetal");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNull() {
            addCriterion("dataStatus is null");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNotNull() {
            addCriterion("dataStatus is not null");
            return (Criteria) this;
        }

        public Criteria andDataStatusEqualTo(Integer value) {
            addCriterion("dataStatus =", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotEqualTo(Integer value) {
            addCriterion("dataStatus <>", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThan(Integer value) {
            addCriterion("dataStatus >", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("dataStatus >=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThan(Integer value) {
            addCriterion("dataStatus <", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThanOrEqualTo(Integer value) {
            addCriterion("dataStatus <=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusIn(List<Integer> values) {
            addCriterion("dataStatus in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotIn(List<Integer> values) {
            addCriterion("dataStatus not in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusBetween(Integer value1, Integer value2) {
            addCriterion("dataStatus between", value1, value2, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("dataStatus not between", value1, value2, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("createUser is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("createUser is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("createUser =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("createUser <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("createUser >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("createUser >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("createUser <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("createUser <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("createUser like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("createUser not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("createUser in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("createUser not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("createUser between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("createUser not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("updateUser is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("updateUser is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("updateUser =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("updateUser <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("updateUser >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("updateUser >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("updateUser <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("updateUser <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("updateUser like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("updateUser not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("updateUser in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("updateUser not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("updateUser between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("updateUser not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("deleteFlag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("deleteFlag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Integer value) {
            addCriterion("deleteFlag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Integer value) {
            addCriterion("deleteFlag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Integer value) {
            addCriterion("deleteFlag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleteFlag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Integer value) {
            addCriterion("deleteFlag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
            addCriterion("deleteFlag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Integer> values) {
            addCriterion("deleteFlag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Integer> values) {
            addCriterion("deleteFlag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
            addCriterion("deleteFlag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("deleteFlag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table b_mortgage
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table b_mortgage
     *
     * @mbggenerated
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