package com.ruoyi.fc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fc.mapper.RecordMapper;
import com.ruoyi.fc.domain.Record;
import com.ruoyi.fc.service.IRecordService;
import com.ruoyi.common.support.Convert;

/**
 * 用户分享记录 服务层实现
 * 
 * @author ruoyi
 * @date 2018-10-27
 */
@Service
public class RecordServiceImpl implements IRecordService 
{
	@Autowired
	private RecordMapper recordMapper;

	/**
     * 查询用户分享记录信息
     * 
     * @param id 用户分享记录ID
     * @return 用户分享记录信息
     */
    @Override
	public Record selectRecordById(Integer id)
	{
	    return recordMapper.selectRecordById(id);
	}
	
	/**
     * 查询用户分享记录列表
     * 
     * @param record 用户分享记录信息
     * @return 用户分享记录集合
     */
	@Override
	public List<Record> selectRecordList(Record record)
	{
	    return recordMapper.selectRecordList(record);
	}
	
    /**
     * 新增用户分享记录
     * 
     * @param record 用户分享记录信息
     * @return 结果
     */
	@Override
	public int insertRecord(Record record)
	{
	    return recordMapper.insertRecord(record);
	}
	
	/**
     * 修改用户分享记录
     * 
     * @param record 用户分享记录信息
     * @return 结果
     */
	@Override
	public int updateRecord(Record record)
	{
	    return recordMapper.updateRecord(record);
	}

	/**
     * 删除用户分享记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteRecordByIds(String ids)
	{
		return recordMapper.deleteRecordByIds(Convert.toStrArray(ids));
	}
	
}
