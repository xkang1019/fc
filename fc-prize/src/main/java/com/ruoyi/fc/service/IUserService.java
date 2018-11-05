package com.ruoyi.fc.service;

import com.ruoyi.fc.domain.User;
import java.util.List;

/**
 * 用户抽奖 服务层
 * 
 * @author ruoyi
 * @date 2018-10-27
 */
public interface IUserService 
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
     * 删除用户抽奖信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserByIds(String ids);

	/**
	 * 批量刷新过期奖品
	 * @param uid
	 * @return
	 */
	public int updateUserStatus(String[] uid);


	/**
	 * 查询24小时过期时间奖品ID
	 * @return
	 */
	public  String[] selectOutList(User user);
	
}
