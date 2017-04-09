package com.utsoft.spring.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试的一个配置类、这个配置类、是用于测试。
 * <br />
 * 1、先测试容器里是否有这个类。先注释掉注解。
 * @Author:Administrator
 * @Date:2017/4/10 0:15
 */
@TestConfiguration // 只能用于测试用。
//@Configuration  // 用于 正常使用。因为你放在这里、正常的扫描不到所以也会报错的。
public class TestBeanConfigruation {
    @Bean
    public Runnable createRunnable(){
        return () -> {};
    }
}
