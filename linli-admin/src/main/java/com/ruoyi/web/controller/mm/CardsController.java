package com.ruoyi.web.controller.mm;

import java.util.List;

import com.ruoyi.forest.domian.Cards;
import com.ruoyi.forest.server.ICardsService;
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
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 * 首页卡片展示 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-10-25
 */
@Controller
@RequestMapping("/mm/cards")
public class CardsController extends BaseController
{
    private String prefix = "mm/cards";
	
	@Autowired
	private ICardsService cardsService;
	
	@RequiresPermissions("module:cards:view")
	@GetMapping()
	public String cards()
	{
	    return prefix + "/cards";
	}
	
	/**
	 * 查询首页卡片展示列表
	 */
	@RequiresPermissions("module:cards:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Cards cards)
	{
		startPage();
        List<Cards> list = cardsService.selectCardsList(cards);
		return getDataTable(list);
	}
	
	/**
	 * 新增首页卡片展示
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存首页卡片展示
	 */
	@RequiresPermissions("module:cards:add")
	@Log(title = "首页卡片展示", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Cards cards)
	{		
		return toAjax(cardsService.insertCards(cards));
	}

	/**
	 * 修改首页卡片展示
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Cards cards = cardsService.selectCardsById(id);
		mmap.put("cards", cards);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存首页卡片展示
	 */
	@RequiresPermissions("module:cards:edit")
	@Log(title = "首页卡片展示", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Cards cards)
	{		
		return toAjax(cardsService.updateCards(cards));
	}
	
	/**
	 * 删除首页卡片展示
	 */
	@RequiresPermissions("module:cards:remove")
	@Log(title = "首页卡片展示", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(cardsService.deleteCardsByIds(ids));
	}
	
}
