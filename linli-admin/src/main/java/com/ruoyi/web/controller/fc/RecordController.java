package com.ruoyi.web.controller.fc;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.fc.domain.Record;
import com.ruoyi.fc.service.IRecordService;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户分享记录 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-10-27
 */
@Controller
@RequestMapping("/fc/record")
public class RecordController extends BaseController
{
    private String prefix = "fc/record";
	
	@Autowired
	private IRecordService recordService;
	
	@RequiresPermissions("fc:record:view")
	@GetMapping()
	public String record()
	{
	    return prefix + "/record";
	}
	
	/**
	 * 查询用户分享记录列表
	 */
	@RequiresPermissions("fc:record:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Record record)
	{
		startPage();
        List<Record> list = recordService.selectRecordList(record);
		return getDataTable(list);
	}
	
	/**
	 * 新增用户分享记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户分享记录
	 */
	@RequiresPermissions("fc:record:add")
	@Log(title = "用户分享记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Record record)
	{		
		return toAjax(recordService.insertRecord(record));
	}

	/**
	 * 修改用户分享记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Record record = recordService.selectRecordById(id);
		mmap.put("record", record);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户分享记录
	 */
	@RequiresPermissions("fc:record:edit")
	@Log(title = "用户分享记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Record record)
	{		
		return toAjax(recordService.updateRecord(record));
	}
	
	/**
	 * 删除用户分享记录
	 */
	@RequiresPermissions("fc:record:remove")
	@Log(title = "用户分享记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(recordService.deleteRecordByIds(ids));
	}
	
}
