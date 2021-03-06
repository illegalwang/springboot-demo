package com.wj.config.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 *
 * *@ControllerAdvice 该注解定义异常处理类
 * *@ExceptionHandler 该注解声明异常处理方
 *
 * TODO 现在只有通用异常方法，待扩展
 * Created by wj on 2018/12/25.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Log log = LogFactory.getLog(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception exception) {
        log.error("异常地址：" + request.getRequestURL());
        log.error("异常原因：" + exception);
        log.error("-----GlobalExceptionHandler.defaultErrorHandler----------------------------------------------------------");
        log.error("以下是异常信息：");
        exception.printStackTrace();
        ModelAndView mv = new ModelAndView("redirect:/error");
        return mv;
    }

}
