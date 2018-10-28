package com.ruoyi.web.controller.tool;

import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.config.Global;
import com.ruoyi.framework.util.FileUploadUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.web.controller.system.SysProfileController;
import com.ruoyi.web.core.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author Administrator
 */
@Controller
@RequestMapping("/tool/file")
public class FileController extends BaseController {

    private static final String  PROFILE = "profile/" ;

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult upload( @RequestParam("file") MultipartFile file)
    {
        try
        {
            if (!file.isEmpty())
            {
                String filename = FileUploadUtils.upload(Global.getDownloadPath(), file);

                return success(Global.getUrl()+PROFILE+"download/"+filename);
            }
            return error();
        }
        catch (Exception e)
        {
            log.error("修改头像失败！", e);
            return error(e.getMessage());
        }
    }

}
