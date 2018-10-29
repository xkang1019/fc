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
import com.ruoyi.module.domain.Prize;
import com.ruoyi.module.service.IPrizeService;
import com.ruoyi.module.service.PrizeServiceImpl;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
			return error("抽奖次数已用完");
		}

		return userWinningPrize();
	}


	private AjaxResult userWinningPrize(){
		List<Prize> list =	prizeService.selectPrizeList(new Prize());
		Prize prize =  regulation(list);
		User user = new User();
		user.setUid(Math.toIntExact(getUserId()));
		user.setDatetime(new Date());
		user.setPid(prize.getId());
		user.setPname(prize.getName());
		user.setStatus(1);
		user.setUname("微信用户");
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

	@PostMapping("web/addPrize")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public AjaxResult addPrize(Integer type)
	{
		User user = new User();
		user.setUid(Math.toIntExact(getUserId()));
		user.setDatetime(new Date());
		int sum = iSysUserService.selectUserSumPrizeCountById(getUserId());
		Record record = new Record();
		record.setUid(Math.toIntExact(getUserId()));
		record.setUname("微信用户");
		record.setType(type);
		if (sum<=0){
			recordService.insertRecord(record);
			return  error("分享成功");
		}


		if (type.equals(FcIndexConteroller.userType1)){
			recordService.insertRecord(record);
			 record.setDateTime(new Date());
			 List<Record> list = recordService.selectRecordList(record);
			 if(list.size()==3){
				 addPrize();
				int prizeCount =  iSysUserService.selectUserPrizeCountById(getUserId());
				return success("分享成功").put("prizeCount",prizeCount);
			 }
		}
		if (type.equals(FcIndexConteroller.userType2)){
			recordService.insertRecord(record);
			record.setDateTime(new Date());
			List<Record> list = recordService.selectRecordList(record);
			if(list.size()==1){
				addPrize();
				int prizeCount =  iSysUserService.selectUserPrizeCountById(getUserId());
				return success("分享成功").put("prizeCount",prizeCount);

			}
		}


		return  error();
	}



	@PostMapping("/test")
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public AjaxResult web111Count()
	{
		List<Prize> list =	prizeService.selectPrizeList(new Prize());
		for (int i = 0; i < 10; i++) {
			System.out.println("恭喜您，抽到了：" + regulation(list).getId());
		}
		return success();
	}

	/**
	 *
	 * @return
	 */
	public static Prize  regulation(List<Prize> prizeList){
		//总的概率区间
		float totalPro = 0f;
		//存储每个奖品新的概率区间
		List<Float> proSection = new ArrayList<Float>();
		proSection.add(0f);
		//遍历每个奖品，设置概率区间，总的概率区间为每个概率区间的总和
		for (Prize award : prizeList) {
			//每个概率区间为奖品概率乘以1000（把三位小数转换为整）再乘以剩余奖品数量
			totalPro += award.getProbability() * 10 * award.getNumber();
			proSection.add(totalPro);
		}
		//获取总的概率区间中的随机数
		Random random = new Random();
		float randomPro = (float)random.nextInt((int)totalPro);
		//判断取到的随机数在哪个奖品的概率区间中
		for (int i = 0,size = proSection.size(); i < size; i++) {
			if(randomPro >= proSection.get(i)
					&& randomPro < proSection.get(i + 1)){
				return prizeList.get(i);
			}
		}
		return null;
	}


  private void addPrize(){
	  int  count  = iSysUserService.selectUserPrizeCountById(getUserId());
	  SysUser sysUser = new SysUser();
	  sysUser.setUserId(getUserId());
	  sysUser.setPrize(count+1);
	  iSysUserService.updateUserInfo(sysUser);
	  int sum = iSysUserService.selectUserSumPrizeCountById(getUserId());
	  SysUser sysUser2 = new SysUser();
	  sysUser2.setUserId(getUserId());
	  sysUser2.setSumprize(sum-1);
	  iSysUserService.updateUserInfo(sysUser2);

  }



	
}
