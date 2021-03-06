package com.fei.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.fei.bean.Tourst;
import com.fei.bean.TourstExample;

public interface TourstMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tourist
     *
     * @mbggenerated
     */
    int countByExample(TourstExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tourist
     *
     * @mbggenerated
     */
    int deleteByExample(TourstExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tourist
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tourist
     *
     * @mbggenerated
     */
    int insert(Tourst record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tourist
     *
     * @mbggenerated
     */
    int insertSelective(Tourst record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tourist
     *
     * @mbggenerated
     */
    List<Tourst> selectByExample(TourstExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tourist
     *
     * @mbggenerated
     */
    Tourst selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tourist
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Tourst record, @Param("example") TourstExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tourist
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Tourst record, @Param("example") TourstExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tourist
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Tourst record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_tourist
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Tourst record);
}