package com.ruoyi.web.controller.fc;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.module.domain.Prize;
import com.ruoyi.module.service.IPrizeService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 奖品列 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-10-27
 */
@Controller
@RequestMapping("/fc/prize")
public class PrizeController extends BaseController
{
    private String prefix = "fc/prize";
	
	@Autowired
	private IPrizeService prizeService;
	
	@RequiresPermissions("fc:prize:view")
	@GetMapping()
	public String prize()
	{
	    return prefix + "/prize";
	}
	
	/**
	 * 查询奖品列列表
	 */
	@RequiresPermissions("fc:prize:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Prize prize)
	{
		startPage();
        List<Prize> list = prizeService.selectPrizeList(prize);
		return getDataTable(list);
	}
	
	/**
	 * 新增奖品列
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存奖品列
	 */
	@RequiresPermissions("fc:prize:add")
	@Log(title = "奖品列", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Prize prize)
	{		
		return toAjax(prizeService.insertPrize(prize));
	}

	/**
	 * 修改奖品列
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Prize prize = prizeService.selectPrizeById(id);
		mmap.put("prize", prize);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存奖品列
	 */
	@RequiresPermissions("fc:prize:edit")
	@Log(title = "奖品列", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Prize prize)
	{		
		return toAjax(prizeService.updatePrize(prize));
	}
	
	/**
	 * 删除奖品列
	 */
	@RequiresPermissions("fc:prize:remove")
	@Log(title = "奖品列", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(prizeService.deletePrizeByIds(ids));
	}
	
}
