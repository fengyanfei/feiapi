package com.fei.bean;

import java.io.Serializable;
import java.util.Date;

public class Advert implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_advert.advertId
     *
     * @mbggenerated
     */
    private String advertId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_advert.advertUrl
     *
     * @mbggenerated
     */
    private String advertUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_advert.buildingId
     *
     * @mbggenerated
     */
    private String buildingId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_advert.advertType
     *
     * @mbggenerated
     */
    private Integer advertType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_advert.sequence
     *
     * @mbggenerated
     */
    private Integer sequence;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_advert.createUser
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_advert.createTime
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_advert.updateUser
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_advert.updateTime
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_advert.deleteFlag
     *
     * @mbggenerated
     */
    private Integer deleteFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_advert.enableFlag
     *
     * @mbggenerated
     */
    private Integer enableFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table b_advert
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_advert.advertId
     *
     * @return the value of b_advert.advertId
     *
     * @mbggenerated
     */
    public String getAdvertId() {
        return advertId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_advert.advertId
     *
     * @param advertId the value for b_advert.advertId
     *
     * @mbggenerated
     */
    public void setAdvertId(String advertId) {
        this.advertId = advertId == null ? null : advertId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_advert.advertUrl
     *
     * @return the value of b_advert.advertUrl
     *
     * @mbggenerated
     */
    public String getAdvertUrl() {
        return advertUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_advert.advertUrl
     *
     * @param advertUrl the value for b_advert.advertUrl
     *
     * @mbggenerated
     */
    public void setAdvertUrl(String advertUrl) {
        this.advertUrl = advertUrl == null ? null : advertUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_advert.buildingId
     *
     * @return the value of b_advert.buildingId
     *
     * @mbggenerated
     */
    public String getBuildingId() {
        return buildingId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_advert.buildingId
     *
     * @param buildingId the value for b_advert.buildingId
     *
     * @mbggenerated
     */
    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_advert.advertType
     *
     * @return the value of b_advert.advertType
     *
     * @mbggenerated
     */
    public Integer getAdvertType() {
        return advertType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_advert.advertType
     *
     * @param advertType the value for b_advert.advertType
     *
     * @mbggenerated
     */
    public void setAdvertType(Integer advertType) {
        this.advertType = advertType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_advert.sequence
     *
     * @return the value of b_advert.sequence
     *
     * @mbggenerated
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_advert.sequence
     *
     * @param sequence the value for b_advert.sequence
     *
     * @mbggenerated
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_advert.createUser
     *
     * @return the value of b_advert.createUser
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_advert.createUser
     *
     * @param createUser the value for b_advert.createUser
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_advert.createTime
     *
     * @return the value of b_advert.createTime
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_advert.createTime
     *
     * @param createTime the value for b_advert.createTime
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_advert.updateUser
     *
     * @return the value of b_advert.updateUser
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_advert.updateUser
     *
     * @param updateUser the value for b_advert.updateUser
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_advert.updateTime
     *
     * @return the value of b_advert.updateTime
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_advert.updateTime
     *
     * @param updateTime the value for b_advert.updateTime
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_advert.deleteFlag
     *
     * @return the value of b_advert.deleteFlag
     *
     * @mbggenerated
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_advert.deleteFlag
     *
     * @param deleteFlag the value for b_advert.deleteFlag
     *
     * @mbggenerated
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_advert.enableFlag
     *
     * @return the value of b_advert.enableFlag
     *
     * @mbggenerated
     */
    public Integer getEnableFlag() {
        return enableFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_advert.enableFlag
     *
     * @param enableFlag the value for b_advert.enableFlag
     *
     * @mbggenerated
     */
    public void setEnableFlag(Integer enableFlag) {
        this.enableFlag = enableFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_advert
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
        Advert other = (Advert) that;
        return (this.getAdvertId() == null ? other.getAdvertId() == null : this.getAdvertId().equals(other.getAdvertId()))
            && (this.getAdvertUrl() == null ? other.getAdvertUrl() == null : this.getAdvertUrl().equals(other.getAdvertUrl()))
            && (this.getBuildingId() == null ? other.getBuildingId() == null : this.getBuildingId().equals(other.getBuildingId()))
            && (this.getAdvertType() == null ? other.getAdvertType() == null : this.getAdvertType().equals(other.getAdvertType()))
            && (this.getSequence() == null ? other.getSequence() == null : this.getSequence().equals(other.getSequence()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()))
            && (this.getEnableFlag() == null ? other.getEnableFlag() == null : this.getEnableFlag().equals(other.getEnableFlag()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_advert
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdvertId() == null) ? 0 : getAdvertId().hashCode());
        result = prime * result + ((getAdvertUrl() == null) ? 0 : getAdvertUrl().hashCode());
        result = prime * result + ((getBuildingId() == null) ? 0 : getBuildingId().hashCode());
        result = prime * result + ((getAdvertType() == null) ? 0 : getAdvertType().hashCode());
        result = prime * result + ((getSequence() == null) ? 0 : getSequence().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        result = prime * result + ((getEnableFlag() == null) ? 0 : getEnableFlag().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_advert
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", advertId=").append(advertId);
        sb.append(", advertUrl=").append(advertUrl);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", advertType=").append(advertType);
        sb.append(", sequence=").append(sequence);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", enableFlag=").append(enableFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}