package com.fei.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.fei.bean.Property;
import com.fei.bean.PropertyExample;

public interface PropertyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_property
     *
     * @mbggenerated
     */
    int countByExample(PropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_property
     *
     * @mbggenerated
     */
    int deleteByExample(PropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_property
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String propertyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_property
     *
     * @mbggenerated
     */
    int insert(Property record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_property
     *
     * @mbggenerated
     */
    int insertSelective(Property record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_property
     *
     * @mbggenerated
     */
    List<Property> selectByExample(PropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_property
     *
     * @mbggenerated
     */
    Property selectByPrimaryKey(String propertyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_property
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Property record, @Param("example") PropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_property
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Property record, @Param("example") PropertyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_property
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Property record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_property
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Property record);
}