package com.wj.controller.system;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.wj.bean.model.IndexGroupChild;
import com.wj.controller.BaseController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wj on 2018/12/26.
 */
@Controller
@RequestMapping("group/child")
public class GroupChildController extends BaseController {

    private static final Log log = LogFactory.getLog(GroupChildController.class);

    @PostMapping()
    public ModelAndView addChild(IndexGroupChild groupChild) {
        ModelAndView mv = new ModelAndView("redirect:/");
        groupChildService.addChild(groupChild);
        return mv;
    }
}
