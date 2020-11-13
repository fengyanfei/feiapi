package com.fei.bean;

import java.io.Serializable;

public class BaseInfoKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_baseinfo.codeId
     *
     * @mbggenerated
     */
    private String codeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_baseinfo.codeKey
     *
     * @mbggenerated
     */
    private String codeKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table s_baseinfo
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_baseinfo.codeId
     *
     * @return the value of s_baseinfo.codeId
     *
     * @mbggenerated
     */
    public String getCodeId() {
        return codeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_baseinfo.codeId
     *
     * @param codeId the value for s_baseinfo.codeId
     *
     * @mbggenerated
     */
    public void setCodeId(String codeId) {
        this.codeId = codeId == null ? null : codeId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_baseinfo.codeKey
     *
     * @return the value of s_baseinfo.codeKey
     *
     * @mbggenerated
     */
    public String getCodeKey() {
        return codeKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_baseinfo.codeKey
     *
     * @param codeKey the value for s_baseinfo.codeKey
     *
     * @mbggenerated
     */
    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey == null ? null : codeKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_baseinfo
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
        BaseInfoKey other = (BaseInfoKey) that;
        return (this.getCodeId() == null ? other.getCodeId() == null : this.getCodeId().equals(other.getCodeId()))
            && (this.getCodeKey() == null ? other.getCodeKey() == null : this.getCodeKey().equals(other.getCodeKey()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_baseinfo
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCodeId() == null) ? 0 : getCodeId().hashCode());
        result = prime * result + ((getCodeKey() == null) ? 0 : getCodeKey().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_baseinfo
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", codeId=").append(codeId);
        sb.append(", codeKey=").append(codeKey);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}