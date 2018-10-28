package com.ruoyi.forest.server.impl;

import java.util.List;

import com.ruoyi.forest.domian.Cards;
import com.ruoyi.forest.mapper.CardsMapper;
import com.ruoyi.forest.server.ICardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.support.Convert;

/**
 * 首页卡片展示 服务层实现
 * 
 * @author ruoyi
 * @date 2018-10-25
 */
@Service
public class CardsServiceImpl implements ICardsService
{
	@Autowired
	private CardsMapper cardsMapper;

	/**
     * 查询首页卡片展示信息
     * 
     * @param id 首页卡片展示ID
     * @return 首页卡片展示信息
     */
    @Override
	public Cards selectCardsById(Integer id)
	{
	    return cardsMapper.selectCardsById(id);
	}
	
	/**
     * 查询首页卡片展示列表
     * 
     * @param cards 首页卡片展示信息
     * @return 首页卡片展示集合
     */
	@Override
	public List<Cards> selectCardsList(Cards cards)
	{
	    return cardsMapper.selectCardsList(cards);
	}
	
    /**
     * 新增首页卡片展示
     * 
     * @param cards 首页卡片展示信息
     * @return 结果
     */
	@Override
	public int insertCards(Cards cards)
	{
	    return cardsMapper.insertCards(cards);
	}
	
	/**
     * 修改首页卡片展示
     * 
     * @param cards 首页卡片展示信息
     * @return 结果
     */
	@Override
	public int updateCards(Cards cards)
	{
	    return cardsMapper.updateCards(cards);
	}

	/**
     * 删除首页卡片展示对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCardsByIds(String ids)
	{
		return cardsMapper.deleteCardsByIds(Convert.toStrArray(ids));
	}
	
}
