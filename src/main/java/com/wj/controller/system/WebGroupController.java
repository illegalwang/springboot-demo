package com.wj.controller.system;

import com.wj.bean.model.IndexWebGroup;
import com.wj.controller.BaseController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Delete;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wj on 2018/12/24.
 */
@Controller
@RequestMapping("/group")
public class WebGroupController extends BaseController {

    private static final Log log = LogFactory.getLog(WebGroupController.class);

    @PostMapping()
    @RequiresUser
    public String addGroup(@RequestParam(value = "imgFile") MultipartFile imgFile,
                         IndexWebGroup webGroup) {
        webGroupService.addWebGroup(webGroup, imgFile);
        return "redirect:/";
    }

    @PutMapping()
    @ResponseBody
    public int updateGroupTitle(String title, String littleTitle, Integer groupId) {
        return webGroupService.updateGroupTitle(title, littleTitle, groupId);
    }

    @DeleteMapping()
    @ResponseBody
    public int deleteGroup(Integer groupId) {
        return webGroupService.deleteGroup(groupId);
    }

}
