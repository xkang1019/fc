package com.ruoyi.module.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.module.mapper.PrizeMapper;
import com.ruoyi.module.domain.Prize;
import com.ruoyi.module.service.IPrizeService;
import com.ruoyi.common.support.Convert;

/**
 * 奖品列 服务层实现
 * 
 * @author ruoyi
 * @date 2018-10-27
 */
@Service
public class PrizeServiceImpl implements IPrizeService 
{
	@Autowired
	private PrizeMapper prizeMapper;

	/**
     * 查询奖品列信息
     * 
     * @param id 奖品列ID
     * @return 奖品列信息
     */
    @Override
	public Prize selectPrizeById(Integer id)
	{
	    return prizeMapper.selectPrizeById(id);
	}
	
	/**
     * 查询奖品列列表
     * 
     * @param prize 奖品列信息
     * @return 奖品列集合
     */
	@Override
	public List<Prize> selectPrizeList(Prize prize)
	{
	    return prizeMapper.selectPrizeList(prize);
	}
	
    /**
     * 新增奖品列
     * 
     * @param prize 奖品列信息
     * @return 结果
     */
	@Override
	public int insertPrize(Prize prize)
	{
	    return prizeMapper.insertPrize(prize);
	}
	
	/**
     * 修改奖品列
     * 
     * @param prize 奖品列信息
     * @return 结果
     */
	@Override
	public int updatePrize(Prize prize)
	{
	    return prizeMapper.updatePrize(prize);
	}

	/**
     * 删除奖品列对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePrizeByIds(String ids)
	{
		return prizeMapper.deletePrizeByIds(Convert.toStrArray(ids));
	}
	
}
