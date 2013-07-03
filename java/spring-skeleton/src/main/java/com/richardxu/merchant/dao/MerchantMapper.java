package com.richardxu.merchant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.richardxu.merchant.domain.Merchant;
import com.richardxu.merchant.domain.MerchantExample;

public interface MerchantMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant
     *
     * @mbggenerated Tue Jun 04 10:39:15 CST 2013
     */
    int countByExample(MerchantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant
     *
     * @mbggenerated Tue Jun 04 10:39:15 CST 2013
     */
    int deleteByExample(MerchantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant
     *
     * @mbggenerated Tue Jun 04 10:39:15 CST 2013
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant
     *
     * @mbggenerated Tue Jun 04 10:39:15 CST 2013
     */
    int insert(Merchant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant
     *
     * @mbggenerated Tue Jun 04 10:39:15 CST 2013
     */
    int insertSelective(Merchant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant
     *
     * @mbggenerated Tue Jun 04 10:39:15 CST 2013
     */
    List<Merchant> selectByExample(MerchantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant
     *
     * @mbggenerated Tue Jun 04 10:39:15 CST 2013
     */
    Merchant selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant
     *
     * @mbggenerated Tue Jun 04 10:39:15 CST 2013
     */
    int updateByExampleSelective(@Param("record") Merchant record, @Param("example") MerchantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant
     *
     * @mbggenerated Tue Jun 04 10:39:15 CST 2013
     */
    int updateByExample(@Param("record") Merchant record, @Param("example") MerchantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant
     *
     * @mbggenerated Tue Jun 04 10:39:15 CST 2013
     */
    int updateByPrimaryKeySelective(Merchant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table merchant
     *
     * @mbggenerated Tue Jun 04 10:39:15 CST 2013
     */
    int updateByPrimaryKey(Merchant record);
    
    Merchant getMerchantByName(String nickname);
    
    public List<Merchant> getMerchantList(@Param("nickname") String nickname, @Param("limitStart") int limitStart, @Param("pageSize") int pageSize);
    
}