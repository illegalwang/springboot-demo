package com.wj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.wj.dao") // 映射mapper文件所在的包
@SpringBootApplication // 这个是spring boot 的核心注解，主要目的是开启自动配置
@EnableScheduling // 开启定时任务
public class SpringbootDemoApplication extends SpringBootServletInitializer {

    // 需要打war包继承SpringBootServletInitializer类和重写此方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootDemoApplication.class);
    }

    public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
}