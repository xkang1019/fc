package com.ruoyi.fc.service;

import com.ruoyi.fc.domain.Lunbo;
import java.util.List;

/**
 * 中奖轮播 服务层
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
public interface ILunboService 
{
	/**
     * 查询中奖轮播信息
     * 
     * @param id 中奖轮播ID
     * @return 中奖轮播信息
     */
	public Lunbo selectLunboById(Integer id);
	
	/**
     * 查询中奖轮播列表
     * 
     * @param lunbo 中奖轮播信息
     * @return 中奖轮播集合
     */
	public List<Lunbo> selectLunboList(Lunbo lunbo);
	
	/**
     * 新增中奖轮播
     * 
     * @param lunbo 中奖轮播信息
     * @return 结果
     */
	public int insertLunbo(Lunbo lunbo);
	
	/**
     * 修改中奖轮播
     * 
     * @param lunbo 中奖轮播信息
     * @return 结果
     */
	public int updateLunbo(Lunbo lunbo);
		
	/**
     * 删除中奖轮播信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteLunboByIds(String ids);
	
}
