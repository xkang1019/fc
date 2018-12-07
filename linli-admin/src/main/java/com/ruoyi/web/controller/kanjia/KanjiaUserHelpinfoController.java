package com.ruoyi.web.controller.kanjia;

import com.ruoyi.common.annotation.Form;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.kanjia.domain.KanjiaUserHelpinfo;
import com.ruoyi.kanjia.service.IKanjiaUserHelpinfoService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * 砍价 信息操作处理
 * 
 * @author xkang
 * @date 2018-12-06
 */
@Controller
@RequestMapping("/kanjia/kanjiaUserHelpinfo")
public class KanjiaUserHelpinfoController extends BaseController
{
    private String prefix = "kanjia/kanjiaUserHelpinfo";
	
	@Autowired
	private IKanjiaUserHelpinfoService kanjiaUserHelpinfoService;

	@Autowired
	private ISysUserService iSysUserService;


	@RequiresPermissions("kanjia:kanjiaUserHelpinfo:view")
	@GetMapping()
	public String kanjiaUserHelpinfo()
	{
	    return prefix + "/kanjiaUserHelpinfo";
	}
	
	/**
	 * 查询砍价列表
	 */
	@RequiresPermissions("kanjia:kanjiaUserHelpinfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(KanjiaUserHelpinfo kanjiaUserHelpinfo)
	{
		startPage();
        List<KanjiaUserHelpinfo> list = kanjiaUserHelpinfoService.selectKanjiaUserHelpinfoList(kanjiaUserHelpinfo);
		return getDataTable(list);
	}
	
	/**
	 * 新增砍价
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存砍价
	 */
	@RequiresPermissions("kanjia:kanjiaUserHelpinfo:add")
	@Log(title = "砍价", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(KanjiaUserHelpinfo kanjiaUserHelpinfo)
	{		
		return toAjax(kanjiaUserHelpinfoService.insertKanjiaUserHelpinfo(kanjiaUserHelpinfo));
	}

	/**
	 * 修改砍价
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		KanjiaUserHelpinfo kanjiaUserHelpinfo = kanjiaUserHelpinfoService.selectKanjiaUserHelpinfoById(id);
		mmap.put("kanjiaUserHelpinfo", kanjiaUserHelpinfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存砍价
	 */
	@RequiresPermissions("kanjia:kanjiaUserHelpinfo:edit")
	@Log(title = "砍价", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(KanjiaUserHelpinfo kanjiaUserHelpinfo)
	{		
		return toAjax(kanjiaUserHelpinfoService.updateKanjiaUserHelpinfo(kanjiaUserHelpinfo));
	}
	
	/**
	 * 删除砍价
	 */
	@RequiresPermissions("kanjia:kanjiaUserHelpinfo:remove")
	@Log(title = "砍价", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(kanjiaUserHelpinfoService.deleteKanjiaUserHelpinfoByIds(ids));
	}

	@Form
	@PostMapping("/web/add")
	@ResponseBody
	public AjaxResult webAddSave(KanjiaUserHelpinfo kanjiaUserHelpinfo, HttpServletRequest request)
	{

	    int  prize	=iSysUserService.selectUserPrizeCountById(getUserId());
		if (prize==0){
			return error("已帮砍过价了");
		}
		kanjiaUserHelpinfo.setUid(Math.toIntExact(getUserId()));
		kanjiaUserHelpinfo.setMoney(new BigDecimal(2));
		return toAjax(kanjiaUserHelpinfoService.insertKanjiaUserHelpinfo(kanjiaUserHelpinfo)).put("money",new BigDecimal(2));
	}
	
}
