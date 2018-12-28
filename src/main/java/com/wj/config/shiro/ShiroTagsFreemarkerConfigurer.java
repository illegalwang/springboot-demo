package com.wj.config.shiro;//package com.wj.config.shiro;
//
//import com.jagregory.shiro.freemarker.ShiroTags;
//import freemarker.template.Configuration;
//import freemarker.template.TemplateException;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
//
//import java.io.IOException;
//
///**
// * freemarker中使用shiro标签需要此配置
// * Created by wj on 2018/12/28.
// */
//public class ShiroTagsFreemarkerConfigurer extends FreeMarkerConfigurer {
//    @Override
//    public void afterPropertiesSet() throws IOException, TemplateException {
//        super.afterPropertiesSet();
//        Configuration configuration = this.getConfiguration();
//        configuration.setSharedVariable("shiro", new ShiroTags());
//        //防止页面输出数字,变成2,000
////        configuration.setNumberFormat("#");
//    }
//}


import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.Configuration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * 集成Shiro标签
 */
@Component
public class ShiroTagsFreemarkerConfigurer implements InitializingBean {

    @Autowired
    private Configuration configuration;

    @Autowired
    private FreeMarkerViewResolver resolver;

    @Override
    public void afterPropertiesSet() throws Exception {
        // 加上这句后，可以在页面上使用shiro标签
        configuration.setSharedVariable("shiro", new ShiroTags());
        // 加上这句后，可以在页面上用${context.contextPath}获取contextPath
        resolver.setRequestContextAttribute("context");
    }
}