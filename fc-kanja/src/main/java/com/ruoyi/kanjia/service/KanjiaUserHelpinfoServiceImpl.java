package com.ruoyi.kanjia.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kanjia.mapper.KanjiaUserHelpinfoMapper;
import com.ruoyi.kanjia.domain.KanjiaUserHelpinfo;
import com.ruoyi.kanjia.service.IKanjiaUserHelpinfoService;
import com.ruoyi.common.support.Convert;

/**
 * 砍价 服务层实现
 * 
 * @author xkang
 * @date 2018-12-06
 */
@Service
public class KanjiaUserHelpinfoServiceImpl implements IKanjiaUserHelpinfoService 
{
	@Autowired
	private KanjiaUserHelpinfoMapper kanjiaUserHelpinfoMapper;

	/**
     * 查询砍价信息
     * 
     * @param id 砍价ID
     * @return 砍价信息
     */
    @Override
	public KanjiaUserHelpinfo selectKanjiaUserHelpinfoById(Integer id)
	{
	    return kanjiaUserHelpinfoMapper.selectKanjiaUserHelpinfoById(id);
	}
	
	/**
     * 查询砍价列表
     * 
     * @param kanjiaUserHelpinfo 砍价信息
     * @return 砍价集合
     */
	@Override
	public List<KanjiaUserHelpinfo> selectKanjiaUserHelpinfoList(KanjiaUserHelpinfo kanjiaUserHelpinfo)
	{
	    return kanjiaUserHelpinfoMapper.selectKanjiaUserHelpinfoList(kanjiaUserHelpinfo);
	}
	
    /**
     * 新增砍价
     * 
     * @param kanjiaUserHelpinfo 砍价信息
     * @return 结果
     */
	@Override
	public int insertKanjiaUserHelpinfo(KanjiaUserHelpinfo kanjiaUserHelpinfo)
	{

	    return kanjiaUserHelpinfoMapper.insertKanjiaUserHelpinfo(kanjiaUserHelpinfo);
	}
	
	/**
     * 修改砍价
     * 
     * @param kanjiaUserHelpinfo 砍价信息
     * @return 结果
     */
	@Override
	public int updateKanjiaUserHelpinfo(KanjiaUserHelpinfo kanjiaUserHelpinfo)
	{
	    return kanjiaUserHelpinfoMapper.updateKanjiaUserHelpinfo(kanjiaUserHelpinfo);
	}

	/**
     * 删除砍价对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteKanjiaUserHelpinfoByIds(String ids)
	{
		return kanjiaUserHelpinfoMapper.deleteKanjiaUserHelpinfoByIds(Convert.toStrArray(ids));
	}

	@Override
	public Double selToUserKanjiaMoneySum(Long uid) {
		return kanjiaUserHelpinfoMapper.selToUserKanjiaMoneySum(uid);
	}

}
