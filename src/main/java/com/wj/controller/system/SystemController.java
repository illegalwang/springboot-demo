package com.wj.controller.system;

import com.wj.controller.BaseController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wj on 2018/12/12.
 */
//@RestController相当于@ResponseBody+@Controller方法会返回json数据，不会按照视图解析
@Controller
public class SystemController extends BaseController {

    private static final Log log = LogFactory.getLog(SystemController.class);

    @GetMapping("/")
    public String index() {
        log.info("----去主页---------------------------------------------------------------");
        return "index";
    }

}
