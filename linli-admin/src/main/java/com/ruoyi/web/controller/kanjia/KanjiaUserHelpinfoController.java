package com.ruoyi.web.controller.kanjia;

import com.ruoyi.common.annotation.Form;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.BigDecimalUtils;
import com.ruoyi.common.utils.DateUtil;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.kanjia.domain.KanjiaUser;
import com.ruoyi.kanjia.domain.KanjiaUserHelpinfo;
import com.ruoyi.kanjia.service.IKanjiaUserHelpinfoService;
import com.ruoyi.kanjia.service.IKanjiaUserService;
import com.ruoyi.system.domain.SysConfig;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysConfigService;
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
public class KanjiaUserHelpinfoController extends BaseController {
    private String prefix = "kanjia/kanjiaUserHelpinfo";

    @Autowired
    private IKanjiaUserHelpinfoService kanjiaUserHelpinfoService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private IKanjiaUserService kanjiaUserService;


    @RequiresPermissions("kanjia:kanjiaUserHelpinfo:view")
    @GetMapping()
    public String kanjiaUserHelpinfo() {
        return prefix + "/kanjiaUserHelpinfo";
    }

    /**
     * 查询砍价列表
     */
    @RequiresPermissions("kanjia:kanjiaUserHelpinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KanjiaUserHelpinfo kanjiaUserHelpinfo) {
        startPage();
        List<KanjiaUserHelpinfo> list = kanjiaUserHelpinfoService.selectKanjiaUserHelpinfoList(kanjiaUserHelpinfo);
        return getDataTable(list);
    }

    /**
     * 新增砍价
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存砍价
     */
    @RequiresPermissions("kanjia:kanjiaUserHelpinfo:add")
    @Log(title = "砍价", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KanjiaUserHelpinfo kanjiaUserHelpinfo) {
        return toAjax(kanjiaUserHelpinfoService.insertKanjiaUserHelpinfo(kanjiaUserHelpinfo));
    }

    /**
     * 修改砍价
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
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
    public AjaxResult editSave(KanjiaUserHelpinfo kanjiaUserHelpinfo) {
        return toAjax(kanjiaUserHelpinfoService.updateKanjiaUserHelpinfo(kanjiaUserHelpinfo));
    }

    /**
     * 删除砍价
     */
    @RequiresPermissions("kanjia:kanjiaUserHelpinfo:remove")
    @Log(title = "砍价", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(kanjiaUserHelpinfoService.deleteKanjiaUserHelpinfoByIds(ids));
    }

    @Form
    @PostMapping("/web/add")
    @ResponseBody
    public AjaxResult webAddSave(KanjiaUserHelpinfo kanjiaUserHelpinfo, HttpServletRequest request) {


        SysConfig activityEndTime = configService.selectConfigById((long) 107);
        int end = DateUtil.compareToDateString(DateUtil.getStringDate(), activityEndTime.getConfigValue());
        if (end == 1) {
            return error("活动已结束");
        }

        int prize = iSysUserService.selectUserPrizeCountById(getUserId());
        if (prize == 0) {
            return error("已帮砍过价了");
        }


        kanjiaUserHelpinfo.setUid(Math.toIntExact(getUserId()));

        //Double moneySum = kanjiaUserHelpinfoService.selToUserKanjiaMoneySum(getUserId());

        KanjiaUser kanjiaUser = new KanjiaUser();
        kanjiaUser.setUid(Math.toIntExact(kanjiaUserHelpinfo.getToUid()));
        List<KanjiaUser> list = kanjiaUserService.selectKanjiaUserList(kanjiaUser);
		/*if (moneySum==null){
			moneySum= 0.0;
		}*/
        //double xianjia =  Double.parseDouble(originalPrice.getConfigValue()) -moneySum;
        //低价
        SysConfig floorPrice = configService.selectConfigById((long) 101);
        //原价
        SysConfig originalPrice = configService.selectConfigById((long) 102);
        //随机开始值
        SysConfig probabilityStart = configService.selectConfigById((long) 105);
        //随机结束值
        SysConfig probabilityEnd = configService.selectConfigById((long) 106);


        double kanJia = BigDecimalUtils.getRandom(Double.parseDouble(probabilityStart.getConfigValue()), Double.parseDouble(probabilityEnd.getConfigValue()));
        kanjiaUserHelpinfo.setMoney(new BigDecimal(kanJia));
        kanjiaUserHelpinfoService.insertKanjiaUserHelpinfo(kanjiaUserHelpinfo);
        KanjiaUser kanjiaUser2 = new KanjiaUser();
        kanjiaUser2.setId(list.get(0).getId());
        int compareto = list.get(0).getPresentPrice().subtract(new BigDecimal(kanJia)).compareTo(new BigDecimal(floorPrice.getConfigValue()));

        BigDecimal PresentPrice;
        if (compareto == -1 || compareto == 0) {
            PresentPrice = new BigDecimal(floorPrice.getConfigValue());
            SysConfig surplusNum = configService.selectConfigById((long) 104);
            SysConfig sysConfig = new SysConfig();
            sysConfig.setConfigId((long) 104);
            sysConfig.setConfigValue((Integer.parseInt(surplusNum.getConfigValue()) - 1) + "");
            configService.updateConfig(sysConfig);

        } else {
            PresentPrice = list.get(0).getPresentPrice().subtract(new BigDecimal(kanJia));
        }
        kanjiaUser2.setPresentPrice(PresentPrice);
        kanjiaUserService.updateKanjiaUser(kanjiaUser2);
        SysUser sysUser = new SysUser();
        sysUser.setUserId(getUserId());
        sysUser.setPrize(prize - 1);
        return toAjax(iSysUserService.updateUserInfo(sysUser)).put("money", kanJia);
    }


}
