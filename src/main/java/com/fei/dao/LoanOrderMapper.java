package com.fei.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.fei.bean.LoanOrder;
import com.fei.bean.LoanOrderExample;

public interface LoanOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_order
     *
     * @mbggenerated
     */
    int countByExample(LoanOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_order
     *
     * @mbggenerated
     */
    int deleteByExample(LoanOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_order
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String loanOrderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_order
     *
     * @mbggenerated
     */
    int insert(LoanOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_order
     *
     * @mbggenerated
     */
    int insertSelective(LoanOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_order
     *
     * @mbggenerated
     */
    List<LoanOrder> selectByExample(LoanOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_order
     *
     * @mbggenerated
     */
    LoanOrder selectByPrimaryKey(String loanOrderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_order
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") LoanOrder record, @Param("example") LoanOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_order
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") LoanOrder record, @Param("example") LoanOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(LoanOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LoanOrder record);
}