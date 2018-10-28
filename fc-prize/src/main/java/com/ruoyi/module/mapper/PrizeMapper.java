package com.ruoyi.module.mapper;

import com.ruoyi.module.domain.Prize;
import java.util.List;	

/**
 * 奖品列 数据层
 * 
 * @author ruoyi
 * @date 2018-10-27
 */
public interface PrizeMapper 
{
	/**
     * 查询奖品列信息
     * 
     * @param id 奖品列ID
     * @return 奖品列信息
     */
	public Prize selectPrizeById(Integer id);
	
	/**
     * 查询奖品列列表
     * 
     * @param prize 奖品列信息
     * @return 奖品列集合
     */
	public List<Prize> selectPrizeList(Prize prize);
	
	/**
     * 新增奖品列
     * 
     * @param prize 奖品列信息
     * @return 结果
     */
	public int insertPrize(Prize prize);
	
	/**
     * 修改奖品列
     * 
     * @param prize 奖品列信息
     * @return 结果
     */
	public int updatePrize(Prize prize);
	
	/**
     * 删除奖品列
     * 
     * @param id 奖品列ID
     * @return 结果
     */
	public int deletePrizeById(Integer id);
	
	/**
     * 批量删除奖品列
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePrizeByIds(String[] ids);
	
}