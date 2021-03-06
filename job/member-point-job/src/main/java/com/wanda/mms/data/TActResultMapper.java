package com.wanda.mms.data;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TActResultMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_RESULT
     *
     * @mbggenerated Thu Sep 26 14:35:44 CST 2013
     */
    int countByExample(TActResultExample example);
    
    List<TActResult> selectByStatus(String status);
   
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_RESULT
     *
     * @mbggenerated Thu Sep 26 14:35:44 CST 2013
     */
    int deleteByExample(TActResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_RESULT
     *
     * @mbggenerated Thu Sep 26 14:35:44 CST 2013
     */
    int deleteByPrimaryKey(BigDecimal actResultId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_RESULT
     *
     * @mbggenerated Thu Sep 26 14:35:44 CST 2013
     */
    int insert(TActResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_RESULT
     *
     * @mbggenerated Thu Sep 26 14:35:44 CST 2013
     */
    int insertSelective(TActResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_RESULT
     *
     * @mbggenerated Thu Sep 26 14:35:44 CST 2013
     */
    List<TActResult> selectByExample(TActResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_RESULT
     *
     * @mbggenerated Thu Sep 26 14:35:44 CST 2013
     */
    TActResult selectByPrimaryKey(BigDecimal actResultId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_RESULT
     *
     * @mbggenerated Thu Sep 26 14:35:44 CST 2013
     */
    int updateByExampleSelective(@Param("record") TActResult record, @Param("example") TActResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_RESULT
     *
     * @mbggenerated Thu Sep 26 14:35:44 CST 2013
     */
    int updateByExample(@Param("record") TActResult record, @Param("example") TActResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_RESULT
     *
     * @mbggenerated Thu Sep 26 14:35:44 CST 2013
     */
    int updateByPrimaryKeySelective(TActResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ACT_RESULT
     *
     * @mbggenerated Thu Sep 26 14:35:44 CST 2013
     */
    int updateByPrimaryKey(TActResult record);
}