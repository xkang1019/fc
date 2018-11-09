package com.ruoyi.web.controller.fc;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.fc.domain.Lunbo;
import com.ruoyi.fc.service.ILunboService;
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 * 中奖轮播 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
@Controller
@RequestMapping("/fc/lunbo")
public class LunboController extends BaseController
{
    private String prefix = "fc/lunbo";
	
	@Autowired
	private ILunboService lunboService;
	
	@RequiresPermissions("fc:lunbo:view")
	@GetMapping()
	public String lunbo()
	{
	    return prefix + "/lunbo";
	}
	
	/**
	 * 查询中奖轮播列表
	 */
	@RequiresPermissions("fc:lunbo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Lunbo lunbo)
	{
		startPage();
        List<Lunbo> list = lunboService.selectLunboList(lunbo);
		return getDataTable(list);
	}
	
	/**
	 * 新增中奖轮播
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存中奖轮播
	 */
	@RequiresPermissions("fc:lunbo:add")
	@Log(title = "中奖轮播", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Lunbo lunbo)
	{		
		return toAjax(lunboService.insertLunbo(lunbo));
	}

	/**
	 * 修改中奖轮播
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Lunbo lunbo = lunboService.selectLunboById(id);
		mmap.put("lunbo", lunbo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存中奖轮播
	 */
	@RequiresPermissions("fc:lunbo:edit")
	@Log(title = "中奖轮播", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Lunbo lunbo)
	{		
		return toAjax(lunboService.updateLunbo(lunbo));
	}
	
	/**
	 * 删除中奖轮播
	 */
	@RequiresPermissions("fc:lunbo:remove")
	@Log(title = "中奖轮播", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(lunboService.deleteLunboByIds(ids));
	}




	@GetMapping("/web/list")
	@ResponseBody
	public AjaxResult weblist(Lunbo lunbo)
	{
		List<Lunbo> list = lunboService.selectLunboList(lunbo);
		return success().put("list",list);
	}
	
}
