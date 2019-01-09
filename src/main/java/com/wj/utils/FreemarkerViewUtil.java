package com.wj.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO 只是一个示例，没有封装。需要用到时可以按照此示例封装
 * freemarker模板生成类
 * Created by wj on 2018/12/24.
 */
public class FreemarkerViewUtil {
    private static final String TEMPLATE_PATH = PathUtil.getTemplatePath();

    public static void main(String[] args) {
        Writer out = null;
        try {
            // 创建一个Configuration对象
            Configuration configuration = new Configuration(Configuration.getVersion());
            // 设置编码
            configuration.setDefaultEncoding("UTF-8");
            // 设置模板文件路径
//            configuration.setClassForTemplateLoading(FreemarkerViewUtilil.class, "/templates");
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // 获取模板
            Template template = configuration.getTemplate("test/test.ftl");
            // 设置输出流
            out = new FileWriter(new File("D:\\test.html"));
            // 设置参数
            Map<String, String> map = new HashMap<>();
            map.put("captcha", "123456789");
            // 解析模板为字符串
//            String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
            // 输出
            template.process(map, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 解析ftl模板为字符串
     * @param map
     * @param <T>
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    public static <T> String processTemplateToString(Map<String, T> map, String path) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setDefaultEncoding("UTF-8");
        configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
        Template template = configuration.getTemplate(path);
        // 解析模板为字符串
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
        return content;
    }
}
