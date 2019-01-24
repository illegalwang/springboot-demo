package com.wj.test;

import com.wj.utils.EmailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试发送email
 * Created by wj on 2019/1/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {
    @Autowired
    private EmailUtil emailUtil;

    @Test
    public void testSimpleMail() {
//        emailUtil.sendSimpleMail("346021293@qq.com", "test spring boot mail", "second test");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content="<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>邮箱验证码</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table>\n" +
                "    <tr>\n" +
                "        <td style=\"background-color: #fbfbfb;color: #303030;\">\n" +
                "            <h4>IT模块：</h4>\n" +
                "            <p style=\"line-height: 2em;padding: 5px\">\n" +
                "                您好，XXXX。欢迎注册IT模块。<br>请将验证码填写到注册页面，三分后钟失效。\n" +
                "                <br>验证码：XXX<br>\n" +
                "                <span></span>\n" +
                "            </p>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>";
//        emailUtil.sendHtmlMail("346021293@qq.com","test html mail", content);
    }

}
