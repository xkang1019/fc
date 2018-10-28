package com.ruoyi.fc.mapper;

import com.ruoyi.fc.domain.Record;
import java.util.List;	

/**
 * 用户分享记录 数据层
 * 
 * @author ruoyi
 * @date 2018-10-27
 */
public interface RecordMapper 
{
	/**
     * 查询用户分享记录信息
     * 
     * @param id 用户分享记录ID
     * @return 用户分享记录信息
     */
	public Record selectRecordById(Integer id);
	
	/**
     * 查询用户分享记录列表
     * 
     * @param record 用户分享记录信息
     * @return 用户分享记录集合
     */
	public List<Record> selectRecordList(Record record);
	
	/**
     * 新增用户分享记录
     * 
     * @param record 用户分享记录信息
     * @return 结果
     */
	public int insertRecord(Record record);
	
	/**
     * 修改用户分享记录
     * 
     * @param record 用户分享记录信息
     * @return 结果
     */
	public int updateRecord(Record record);
	
	/**
     * 删除用户分享记录
     * 
     * @param id 用户分享记录ID
     * @return 结果
     */
	public int deleteRecordById(Integer id);
	
	/**
     * 批量删除用户分享记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteRecordByIds(String[] ids);
	
}