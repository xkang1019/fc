package com.ruoyi.fc.mapper;

import com.ruoyi.fc.domain.User;
import java.util.List;	

/**
 * 用户抽奖 数据层
 * 
 * @author ruoyi
 * @date 2018-10-27
 */
public interface UserMapper 
{
	/**
     * 查询用户抽奖信息
     * 
     * @param id 用户抽奖ID
     * @return 用户抽奖信息
     */
	public User selectUserById(Integer id);
	
	/**
     * 查询用户抽奖列表
     * 
     * @param user 用户抽奖信息
     * @return 用户抽奖集合
     */
	public List<User> selectUserList(User user);
	
	/**
     * 新增用户抽奖
     * 
     * @param user 用户抽奖信息
     * @return 结果
     */
	public int insertUser(User user);
	
	/**
     * 修改用户抽奖
     * 
     * @param user 用户抽奖信息
     * @return 结果
     */
	public int updateUser(User user);
	
	/**
     * 删除用户抽奖
     * 
     * @param id 用户抽奖ID
     * @return 结果
     */
	public int deleteUserById(Integer id);
	
	/**
     * 批量删除用户抽奖
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserByIds(String[] ids);
	
}