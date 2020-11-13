package com.fei.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.fei.bean.BuildingOld;
import com.fei.bean.BuildingOldExample;
import com.fei.vo.BuildingOldVo;

public interface BuildingOldMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_building_old
     *
     * @mbggenerated
     */
    int countByExample(BuildingOldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_building_old
     *
     * @mbggenerated
     */
    int deleteByExample(BuildingOldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_building_old
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String buildingOldId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_building_old
     *
     * @mbggenerated
     */
    int insert(BuildingOld record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_building_old
     *
     * @mbggenerated
     */
    int insertSelective(BuildingOld record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_building_old
     *
     * @mbggenerated
     */
    List<BuildingOld> selectByExample(BuildingOldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_building_old
     *
     * @mbggenerated
     */
    BuildingOld selectByPrimaryKey(String buildingOldId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_building_old
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") BuildingOld record, @Param("example") BuildingOldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_building_old
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") BuildingOld record, @Param("example") BuildingOldExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_building_old
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BuildingOld record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_building_old
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BuildingOld record);
    

    List<Map<String,Object>> getBuildingList(BuildingOldVo vo);
}