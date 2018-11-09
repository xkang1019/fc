package com.ruoyi.fc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fc.mapper.LunboMapper;
import com.ruoyi.fc.domain.Lunbo;
import com.ruoyi.fc.service.ILunboService;
import com.ruoyi.common.support.Convert;

/**
 * 中奖轮播 服务层实现
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
@Service
public class LunboServiceImpl implements ILunboService 
{
	@Autowired
	private LunboMapper lunboMapper;

	/**
     * 查询中奖轮播信息
     * 
     * @param id 中奖轮播ID
     * @return 中奖轮播信息
     */
    @Override
	public Lunbo selectLunboById(Integer id)
	{
	    return lunboMapper.selectLunboById(id);
	}
	
	/**
     * 查询中奖轮播列表
     * 
     * @param lunbo 中奖轮播信息
     * @return 中奖轮播集合
     */
	@Override
	public List<Lunbo> selectLunboList(Lunbo lunbo)
	{
	    return lunboMapper.selectLunboList(lunbo);
	}
	
    /**
     * 新增中奖轮播
     * 
     * @param lunbo 中奖轮播信息
     * @return 结果
     */
	@Override
	public int insertLunbo(Lunbo lunbo)
	{
	    return lunboMapper.insertLunbo(lunbo);
	}
	
	/**
     * 修改中奖轮播
     * 
     * @param lunbo 中奖轮播信息
     * @return 结果
     */
	@Override
	public int updateLunbo(Lunbo lunbo)
	{
	    return lunboMapper.updateLunbo(lunbo);
	}

	/**
     * 删除中奖轮播对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLunboByIds(String ids)
	{
		return lunboMapper.deleteLunboByIds(Convert.toStrArray(ids));
	}
	
}
