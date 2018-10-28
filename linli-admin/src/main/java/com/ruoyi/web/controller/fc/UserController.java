package com.ruoyi.web.controller.fc;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.fc.domain.Record;
import com.ruoyi.fc.domain.User;
import com.ruoyi.fc.service.IRecordService;
import com.ruoyi.fc.service.IUserService;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.module.service.IPrizeService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 用户抽奖 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-10-27
 */
@Controller
@RequestMapping("/fc/user")
public class UserController extends BaseController
{
    private String prefix = "fc/user";
	
	@Autowired
	private IUserService userService;
	@Autowired
	private ISysUserService iSysUserService;

	@Autowired
	private IPrizeService prizeService;

	@Autowired
	private IRecordService recordService;
	
	@RequiresPermissions("fc:user:view")
	@GetMapping()
	public String user()
	{
	    return prefix + "/user";
	}
	
	/**
	 * 查询用户抽奖列表
	 */
	@RequiresPermissions("fc:user:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(User user)
	{
		startPage();
        List<User> list = userService.selectUserList(user);
		return getDataTable(list);
	}
	
	/**
	 * 新增用户抽奖
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户抽奖
	 */
	@RequiresPermissions("fc:user:add")
	@Log(title = "用户抽奖", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(User user)
	{		
		return toAjax(userService.insertUser(user));
	}

	/**
	 * 修改用户抽奖
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		User user = userService.selectUserById(id);
		mmap.put("user", user);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户抽奖
	 */
	@RequiresPermissions("fc:user:edit")
	@Log(title = "用户抽奖", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(User user)
	{		
		return toAjax(userService.updateUser(user));
	}
	
	/**
	 * 删除用户抽奖
	 */
	@RequiresPermissions("fc:user:remove")
	@Log(title = "用户抽奖", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(userService.deleteUserByIds(ids));
	}


	/**
	 * 抽奖
	 * @return
	 */
	@PostMapping("web/prizeStart")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public AjaxResult webCount()
	{
		int  count  = iSysUserService.selectUserPrizeCountById(getUserId());
		if (count<=0){
			return error("今日抽奖次数已用完");
		}

		return userWinningPrize();
	}


	private AjaxResult userWinningPrize(){
		User user = new User();
		user.setUid(Math.toIntExact(getUserId()));
		user.setDatetime(new Date());
		user.setPid(1);
		user.setPname("西红柿");
		user.setStatus(1);
		user.setUname("瓜皮");
		if (userService.insertUser(user)>0){
			int  count  = iSysUserService.selectUserPrizeCountById(getUserId());
			SysUser sysUser = new SysUser();
			sysUser.setUserId(getUserId());
			sysUser.setPrize(count-1);
			iSysUserService.updateUserInfo(sysUser);
			return	success("恭喜了中奖了").put("prize",prizeService.selectPrizeById(user.getPid()));
		}else {
			return error();
		}
	}



	@PostMapping("/test")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public AjaxResult web111Count()
	{
		SysUser sysUser = new SysUser();
		sysUser.setUserId(getUserId());
		sysUser.setPrize(0);

		int a  =iSysUserService.updateUserInfo(sysUser);
		return success().put("a",a);
	}

	
}
