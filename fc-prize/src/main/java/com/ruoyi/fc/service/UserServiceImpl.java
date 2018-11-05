package com.ruoyi.fc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fc.mapper.UserMapper;
import com.ruoyi.fc.domain.User;
import com.ruoyi.fc.service.IUserService;
import com.ruoyi.common.support.Convert;

/**
 * 用户抽奖 服务层实现
 * 
 * @author ruoyi
 * @date 2018-10-27
 */
@Service
public class UserServiceImpl implements IUserService 
{
	@Autowired
	private UserMapper userMapper;

	/**
     * 查询用户抽奖信息
     * 
     * @param id 用户抽奖ID
     * @return 用户抽奖信息
     */
    @Override
	public User selectUserById(Integer id)
	{
	    return userMapper.selectUserById(id);
	}
	
	/**
     * 查询用户抽奖列表
     * 
     * @param user 用户抽奖信息
     * @return 用户抽奖集合
     */
	@Override
	public List<User> selectUserList(User user)
	{
	    return userMapper.selectUserList(user);
	}
	
    /**
     * 新增用户抽奖
     * 
     * @param user 用户抽奖信息
     * @return 结果
     */
	@Override
	public int insertUser(User user)
	{
	    return userMapper.insertUser(user);
	}
	
	/**
     * 修改用户抽奖
     * 
     * @param user 用户抽奖信息
     * @return 结果
     */
	@Override
	public int updateUser(User user)
	{
	    return userMapper.updateUser(user);
	}

	/**
     * 删除用户抽奖对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteUserByIds(String ids)
	{
		return userMapper.deleteUserByIds(Convert.toStrArray(ids));
	}

	@Override
	public int updateUserStatus(String[] uid) {
		return userMapper.updateUserStatus(uid);
	}

	@Override
	public String[] selectOutList(User user) {
		return userMapper.selectOutList(user);
	}


}
