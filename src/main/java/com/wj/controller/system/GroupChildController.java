package com.wj.controller.system;

import com.wj.bean.model.IndexGroupChild;
import com.wj.controller.BaseController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wj on 2018/12/26.
 */
@Controller
@RequestMapping("/group/child")
public class GroupChildController extends BaseController {

    private static final Log log = LogFactory.getLog(GroupChildController.class);

    @GetMapping()
    @ResponseBody
    public List<IndexGroupChild> listGroupChild(Integer groupId) {
        return groupChildService.listChildByGroupId(groupId);
    }

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

    /**
     * 逻辑删除选中的children
     * @param webIds
     * @param groupId
     * @return
     */
    @DeleteMapping()
    @ResponseBody
    public int LogicDeleteGroupChild(@RequestParam(value = "webIds[]",required = false) Integer[] webIds,
                                @RequestParam(value = "groupId", required = false) Integer groupId) {
        log.info("逻辑删除分组的child-----webIds：" + Arrays.toString(webIds) + ";groupId：" + groupId);
        return groupChildService.logicDeleteGroupChild(webIds, groupId);
    }

    /***
     * 逻辑删除child根据id
     * @param webId
     * @param groupId
     * @return
     */
    @DeleteMapping("/single")
    @ResponseBody
    public int LogicDeleteSingleChild(Integer webId, Integer groupId) {
        log.info("逻辑删除单个child-----webId:" + webId + ";groupId:" + groupId);
        return groupChildService.logicDeleteSingleChild(webId, groupId);
    }
}
