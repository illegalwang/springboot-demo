package com.wj.controller.system;

import com.wj.bean.model.IndexWebGroup;
import com.wj.controller.BaseController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wj on 2018/12/24.
 */
@Controller
@RequestMapping("group")
public class WebGroupController extends BaseController {

    private static final Log log = LogFactory.getLog(WebGroupController.class);

    @PostMapping()
    public void addGroup(@RequestParam(value = "imgFile") MultipartFile imgFile,
                         IndexWebGroup webGroup) {
        webGroupService.addWebGroup(webGroup, imgFile);
    }

}
