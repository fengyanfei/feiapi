package com.fei.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.fei.bean.BankRate;
import com.fei.bean.BankRateExample;

public interface BankRateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_bank_rate
     *
     * @mbggenerated
     */
    int countByExample(BankRateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_bank_rate
     *
     * @mbggenerated
     */
    int deleteByExample(BankRateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_bank_rate
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String bankId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_bank_rate
     *
     * @mbggenerated
     */
    int insert(BankRate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_bank_rate
     *
     * @mbggenerated
     */
    int insertSelective(BankRate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_bank_rate
     *
     * @mbggenerated
     */
    List<BankRate> selectByExample(BankRateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_bank_rate
     *
     * @mbggenerated
     */
    BankRate selectByPrimaryKey(String bankId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_bank_rate
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") BankRate record, @Param("example") BankRateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_bank_rate
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") BankRate record, @Param("example") BankRateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_bank_rate
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BankRate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_bank_rate
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BankRate record);
}