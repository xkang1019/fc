package com.ruoyi.kanjia.mapper;

import com.ruoyi.kanjia.domain.KanjiaUser;
import java.util.List;	

/**
 * 报名 数据层
 * 
 * @author xkang
 * @date 2018-12-06
 */
public interface KanjiaUserMapper 
{
	/**
     * 查询报名信息
     * 
     * @param id 报名ID
     * @return 报名信息
     */
	public KanjiaUser selectKanjiaUserById(Integer id);
	
	/**
     * 查询报名列表
     * 
     * @param kanjiaUser 报名信息
     * @return 报名集合
     */
	public List<KanjiaUser> selectKanjiaUserList(KanjiaUser kanjiaUser);
	
	/**
     * 新增报名
     * 
     * @param kanjiaUser 报名信息
     * @return 结果
     */
	public int insertKanjiaUser(KanjiaUser kanjiaUser);
	
	/**
     * 修改报名
     * 
     * @param kanjiaUser 报名信息
     * @return 结果
     */
	public int updateKanjiaUser(KanjiaUser kanjiaUser);
	
	/**
     * 删除报名
     * 
     * @param id 报名ID
     * @return 结果
     */
	public int deleteKanjiaUserById(Integer id);
	
	/**
     * 批量删除报名
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteKanjiaUserByIds(String[] ids);
	
}