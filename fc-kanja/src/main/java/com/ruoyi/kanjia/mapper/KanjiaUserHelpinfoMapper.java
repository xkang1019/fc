package com.ruoyi.kanjia.mapper;

import com.ruoyi.kanjia.domain.KanjiaUserHelpinfo;
import java.util.List;	

/**
 * 砍价 数据层
 * 
 * @author xkang
 * @date 2018-12-06
 */
public interface KanjiaUserHelpinfoMapper 
{
	/**
     * 查询砍价信息
     * 
     * @param id 砍价ID
     * @return 砍价信息
     */
	public KanjiaUserHelpinfo selectKanjiaUserHelpinfoById(Integer id);
	
	/**
     * 查询砍价列表
     * 
     * @param kanjiaUserHelpinfo 砍价信息
     * @return 砍价集合
     */
	public List<KanjiaUserHelpinfo> selectKanjiaUserHelpinfoList(KanjiaUserHelpinfo kanjiaUserHelpinfo);
	
	/**
     * 新增砍价
     * 
     * @param kanjiaUserHelpinfo 砍价信息
     * @return 结果
     */
	public int insertKanjiaUserHelpinfo(KanjiaUserHelpinfo kanjiaUserHelpinfo);
	
	/**
     * 修改砍价
     * 
     * @param kanjiaUserHelpinfo 砍价信息
     * @return 结果
     */
	public int updateKanjiaUserHelpinfo(KanjiaUserHelpinfo kanjiaUserHelpinfo);
	
	/**
     * 删除砍价
     * 
     * @param id 砍价ID
     * @return 结果
     */
	public int deleteKanjiaUserHelpinfoById(Integer id);
	
	/**
     * 批量删除砍价
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteKanjiaUserHelpinfoByIds(String[] ids);
	
}