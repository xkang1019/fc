package com.ruoyi.web.controller.mm;

import com.ruoyi.forest.domian.Diary;
import com.ruoyi.forest.domian.SlDiaryDO;
import com.ruoyi.forest.dto.do2dto.DiaryConvert;
import com.ruoyi.forest.ov.CardsInfoVO;
import com.ruoyi.forest.ov.do2vo.DiaryConvertVO;
import com.ruoyi.forest.server.SlDiaryService;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * @author kang
 * @email 1992lcg@163.com
 * @date 2018-09-05 17:35:11
 */
 
@Controller
@RequestMapping("/diary")
public class SlDiaryController extends BaseController{
	@Autowired
	private SlDiaryService slDiaryService;



	@PostMapping("web/add")
	@ResponseBody
	public AjaxResult add(@RequestBody Diary diary){
		SlDiaryDO slDiaryDO = DiaryConvert.MAPPER.doToDO(diary);
		slDiaryDO.setUserId(Math.toIntExact(getUserId()));
		if(slDiaryService.save(slDiaryDO)>0){
			return success();
		}
		return error();
	}


	@GetMapping("web/list")
	@ResponseBody
	public TableDataInfo weblist(@RequestParam Map<String, Object> params){
		startPage();
		List<SlDiaryDO> slDiaryList = slDiaryService.list(new HashMap<>(16));
		System.out.println(slDiaryList.size());
		List<CardsInfoVO> cardsInfoVOList = DiaryConvertVO.MAPPER.doToVOList(slDiaryList);
		return getDataTable(cardsInfoVOList);
	}

/*
	public static void main(String[] args) {
		Diary diary = new Diary();
		diary.setContent("adsad");
		String [] arr2= new String[]{"asd","sad"};
		diary.setContentImg(arr2);
		diary.setCreationTime("2019-09-06");
		diary.setType(true);
		SlDiaryDO slDiaryDO = DiaryConvert.MAPPER.doToDO(diary);
		System.out.println(slDiaryDO.getContentimg());
		System.out.println(slDiaryDO.getCreationtime());

	}*/
}
