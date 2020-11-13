package com.fei.bean;

import java.io.Serializable;
import java.util.Date;

public class Mortgage implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_mortgage.mortgageId
     *
     * @mbggenerated
     */
    private String mortgageId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_mortgage.loanRate
     *
     * @mbggenerated
     */
    private Float loanRate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_mortgage.loanType
     *
     * @mbggenerated
     */
    private Integer loanType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_mortgage.loanDetal
     *
     * @mbggenerated
     */
    private String loanDetal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_mortgage.dataStatus
     *
     * @mbggenerated
     */
    private Integer dataStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_mortgage.createUser
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_mortgage.createTime
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_mortgage.updateUser
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_mortgage.updateTime
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_mortgage.deleteFlag
     *
     * @mbggenerated
     */
    private Integer deleteFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_mortgage.mortgageId
     *
     * @return the value of b_mortgage.mortgageId
     *
     * @mbggenerated
     */
    public String getMortgageId() {
        return mortgageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_mortgage.mortgageId
     *
     * @param mortgageId the value for b_mortgage.mortgageId
     *
     * @mbggenerated
     */
    public void setMortgageId(String mortgageId) {
        this.mortgageId = mortgageId == null ? null : mortgageId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_mortgage.loanRate
     *
     * @return the value of b_mortgage.loanRate
     *
     * @mbggenerated
     */
    public Float getLoanRate() {
        return loanRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_mortgage.loanRate
     *
     * @param loanRate the value for b_mortgage.loanRate
     *
     * @mbggenerated
     */
    public void setLoanRate(Float loanRate) {
        this.loanRate = loanRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_mortgage.loanType
     *
     * @return the value of b_mortgage.loanType
     *
     * @mbggenerated
     */
    public Integer getLoanType() {
        return loanType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_mortgage.loanType
     *
     * @param loanType the value for b_mortgage.loanType
     *
     * @mbggenerated
     */
    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_mortgage.loanDetal
     *
     * @return the value of b_mortgage.loanDetal
     *
     * @mbggenerated
     */
    public String getLoanDetal() {
        return loanDetal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_mortgage.loanDetal
     *
     * @param loanDetal the value for b_mortgage.loanDetal
     *
     * @mbggenerated
     */
    public void setLoanDetal(String loanDetal) {
        this.loanDetal = loanDetal == null ? null : loanDetal.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_mortgage.dataStatus
     *
     * @return the value of b_mortgage.dataStatus
     *
     * @mbggenerated
     */
    public Integer getDataStatus() {
        return dataStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_mortgage.dataStatus
     *
     * @param dataStatus the value for b_mortgage.dataStatus
     *
     * @mbggenerated
     */
    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_mortgage.createUser
     *
     * @return the value of b_mortgage.createUser
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_mortgage.createUser
     *
     * @param createUser the value for b_mortgage.createUser
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_mortgage.createTime
     *
     * @return the value of b_mortgage.createTime
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_mortgage.createTime
     *
     * @param createTime the value for b_mortgage.createTime
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_mortgage.updateUser
     *
     * @return the value of b_mortgage.updateUser
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_mortgage.updateUser
     *
     * @param updateUser the value for b_mortgage.updateUser
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_mortgage.updateTime
     *
     * @return the value of b_mortgage.updateTime
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_mortgage.updateTime
     *
     * @param updateTime the value for b_mortgage.updateTime
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_mortgage.deleteFlag
     *
     * @return the value of b_mortgage.deleteFlag
     *
     * @mbggenerated
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_mortgage.deleteFlag
     *
     * @param deleteFlag the value for b_mortgage.deleteFlag
     *
     * @mbggenerated
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Mortgage other = (Mortgage) that;
        return (this.getMortgageId() == null ? other.getMortgageId() == null : this.getMortgageId().equals(other.getMortgageId()))
            && (this.getLoanRate() == null ? other.getLoanRate() == null : this.getLoanRate().equals(other.getLoanRate()))
            && (this.getLoanType() == null ? other.getLoanType() == null : this.getLoanType().equals(other.getLoanType()))
            && (this.getLoanDetal() == null ? other.getLoanDetal() == null : this.getLoanDetal().equals(other.getLoanDetal()))
            && (this.getDataStatus() == null ? other.getDataStatus() == null : this.getDataStatus().equals(other.getDataStatus()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMortgageId() == null) ? 0 : getMortgageId().hashCode());
        result = prime * result + ((getLoanRate() == null) ? 0 : getLoanRate().hashCode());
        result = prime * result + ((getLoanType() == null) ? 0 : getLoanType().hashCode());
        result = prime * result + ((getLoanDetal() == null) ? 0 : getLoanDetal().hashCode());
        result = prime * result + ((getDataStatus() == null) ? 0 : getDataStatus().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_mortgage
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mortgageId=").append(mortgageId);
        sb.append(", loanRate=").append(loanRate);
        sb.append(", loanType=").append(loanType);
        sb.append(", loanDetal=").append(loanDetal);
        sb.append(", dataStatus=").append(dataStatus);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}