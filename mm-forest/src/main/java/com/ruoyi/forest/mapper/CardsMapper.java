package com.ruoyi.forest.mapper;

import com.ruoyi.forest.domian.Cards;
import java.util.List;	

/**
 * 首页卡片展示 数据层
 * 
 * @author ruoyi
 * @date 2018-10-25
 */
public interface CardsMapper 
{
	/**
     * 查询首页卡片展示信息
     * 
     * @param id 首页卡片展示ID
     * @return 首页卡片展示信息
     */
	public Cards selectCardsById(Integer id);
	
	/**
     * 查询首页卡片展示列表
     * 
     * @param cards 首页卡片展示信息
     * @return 首页卡片展示集合
     */
	public List<Cards> selectCardsList(Cards cards);
	
	/**
     * 新增首页卡片展示
     * 
     * @param cards 首页卡片展示信息
     * @return 结果
     */
	public int insertCards(Cards cards);
	
	/**
     * 修改首页卡片展示
     * 
     * @param cards 首页卡片展示信息
     * @return 结果
     */
	public int updateCards(Cards cards);
	
	/**
     * 删除首页卡片展示
     * 
     * @param id 首页卡片展示ID
     * @return 结果
     */
	public int deleteCardsById(Integer id);
	
	/**
     * 批量删除首页卡片展示
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCardsByIds(String[] ids);
	
}