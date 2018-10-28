package com.ruoyi.web.controller.mm;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.forest.domian.SysCardsDO;
import com.ruoyi.forest.ov.CardsListVO;
import com.ruoyi.forest.ov.do2vo.DiaryConvertVO;
import com.ruoyi.forest.server.SysCardsService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.framework.util.FileUploadUtils;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lzy
 * @email 1992lcg@163.com
 * @date 2018-09-12 10:43:25
 */
 
@Controller
@RequestMapping("/system/sysCards")
public class SysCardsController extends BaseController {
	@Autowired
	private SysCardsService sysCardsService;
	

	@ResponseBody
	@GetMapping("/web/list")
	//@RequiresPermissions("system:sysCards:sysCards")
	public TableDataInfo weblist(@RequestParam Map<String, Object> params){
		//查询列表数据
		startPage();
		List<SysCardsDO> sysCardsList = sysCardsService.list(new HashMap<>(16));
		List<CardsListVO> cardsListVOList =  DiaryConvertVO.MAPPER.sysCardDoToVOList(sysCardsList);
		return getDataTable(cardsListVOList);
	}



}
