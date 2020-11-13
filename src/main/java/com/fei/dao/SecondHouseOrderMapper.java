package com.fei.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.fei.bean.SecondHouseOrder;
import com.fei.bean.SecondHouseOrderExample;

public interface SecondHouseOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_secondhouse_order
     *
     * @mbggenerated
     */
    int countByExample(SecondHouseOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_secondhouse_order
     *
     * @mbggenerated
     */
    int deleteByExample(SecondHouseOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_secondhouse_order
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String secOrderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_secondhouse_order
     *
     * @mbggenerated
     */
    int insert(SecondHouseOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_secondhouse_order
     *
     * @mbggenerated
     */
    int insertSelective(SecondHouseOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_secondhouse_order
     *
     * @mbggenerated
     */
    List<SecondHouseOrder> selectByExample(SecondHouseOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_secondhouse_order
     *
     * @mbggenerated
     */
    SecondHouseOrder selectByPrimaryKey(String secOrderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_secondhouse_order
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SecondHouseOrder record, @Param("example") SecondHouseOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_secondhouse_order
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SecondHouseOrder record, @Param("example") SecondHouseOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_secondhouse_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SecondHouseOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_secondhouse_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SecondHouseOrder record);
}