package com.ruoyi.module.service;

import com.ruoyi.module.domain.Prize;
import java.util.List;

/**
 * 奖品列 服务层
 * 
 * @author ruoyi
 * @date 2018-10-27
 */
public interface IPrizeService 
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
     * 删除奖品列信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePrizeByIds(String ids);
	
}
