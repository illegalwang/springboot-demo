package com.wj.controller.system;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.wj.bean.model.IndexGroupChild;
import com.wj.controller.BaseController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wj on 2018/12/26.
 */
@Controller
@RequestMapping("/group/child")
public class GroupChildController extends BaseController {

    private static final Log log = LogFactory.getLog(GroupChildController.class);

    @PostMapping()
    @RequiresUser
    public ModelAndView addChild(IndexGroupChild groupChild) {
        log.info("新增child");
        ModelAndView mv = new ModelAndView("redirect:/");
        groupChildService.addChild(groupChild);
        return mv;
    }

    @PutMapping()
    @ResponseBody
    public int updateChildGroup(Integer webId, Integer groupId) {
        log.info("修改child的分组-----web_id：" + webId + "；group_id：" + groupId);
        return groupChildService.updateChildGroup(webId, groupId);
    }
}
