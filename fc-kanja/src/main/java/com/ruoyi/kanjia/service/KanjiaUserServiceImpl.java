package com.ruoyi.kanjia.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kanjia.mapper.KanjiaUserMapper;
import com.ruoyi.kanjia.domain.KanjiaUser;
import com.ruoyi.kanjia.service.IKanjiaUserService;
import com.ruoyi.common.support.Convert;

/**
 * 报名 服务层实现
 * 
 * @author xkang
 * @date 2018-12-06
 */
@Service
public class KanjiaUserServiceImpl implements IKanjiaUserService 
{
	@Autowired
	private KanjiaUserMapper kanjiaUserMapper;

	/**
     * 查询报名信息
     * 
     * @param id 报名ID
     * @return 报名信息
     */
    @Override
	public KanjiaUser selectKanjiaUserById(Integer id)
	{
	    return kanjiaUserMapper.selectKanjiaUserById(id);
	}
	
	/**
     * 查询报名列表
     * 
     * @param kanjiaUser 报名信息
     * @return 报名集合
     */
	@Override
	public List<KanjiaUser> selectKanjiaUserList(KanjiaUser kanjiaUser)
	{
	    return kanjiaUserMapper.selectKanjiaUserList(kanjiaUser);
	}
	
    /**
     * 新增报名
     * 
     * @param kanjiaUser 报名信息
     * @return 结果
     */
	@Override
	public int insertKanjiaUser(KanjiaUser kanjiaUser)
	{
	    return kanjiaUserMapper.insertKanjiaUser(kanjiaUser);
	}
	
	/**
     * 修改报名
     * 
     * @param kanjiaUser 报名信息
     * @return 结果
     */
	@Override
	public int updateKanjiaUser(KanjiaUser kanjiaUser)
	{
	    return kanjiaUserMapper.updateKanjiaUser(kanjiaUser);
	}

	/**
     * 删除报名对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteKanjiaUserByIds(String ids)
	{
		return kanjiaUserMapper.deleteKanjiaUserByIds(Convert.toStrArray(ids));
	}
	
}
