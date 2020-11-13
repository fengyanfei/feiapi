package com.fei.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.fei.bean.AppsHis;
import com.fei.bean.AppsHisExample;

public interface AppsHisMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_appshis
     *
     * @mbggenerated
     */
    int countByExample(AppsHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_appshis
     *
     * @mbggenerated
     */
    int deleteByExample(AppsHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_appshis
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String appsHistoryId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_appshis
     *
     * @mbggenerated
     */
    int insert(AppsHis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_appshis
     *
     * @mbggenerated
     */
    int insertSelective(AppsHis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_appshis
     *
     * @mbggenerated
     */
    List<AppsHis> selectByExample(AppsHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_appshis
     *
     * @mbggenerated
     */
    AppsHis selectByPrimaryKey(String appsHistoryId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_appshis
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AppsHis record, @Param("example") AppsHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_appshis
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AppsHis record, @Param("example") AppsHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_appshis
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AppsHis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_appshis
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AppsHis record);
}