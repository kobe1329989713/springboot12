package com.utsoft.spring.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试从配置文件里面获取的值是否是对的。
 * @Author:Administrator
 * @Date:2017/4/10 1:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"app.version=1.0.0"})
public class EnvTest {

    // 它主要用于获取配置文件里面数据
    //@Autowired
    //private Environment env;


    // 测试从配置文件里面获取值、二：
    @Autowired
    private ConfigurableEnvironment env;

    // 它就是用于模拟配置文件的，这样就不用写配置文件了、因为在方法执行之前的。
    @Before
    public void init(){
        EnvironmentTestUtils.addEnvironment(env, "app.admin.name=admin");
        EnvironmentTestUtils.addEnvironment(env, "app.admin.enable=true");
    }

    @Test
    public void handler(){
        // 它如果，获取到了值就不会报错，报错说明没有从配置文件里面获取到值。
        Assert.assertEquals("springboot",env.getProperty("app.name"));
        // 从配置文件里面获取的值、和前面这个进行比较
        // 就是从配置文件里面获取的值是不是 springboot 是就对了。
        // 它会优先获取测试环境当中配置文件的值，没有在从正常环境里面去获取。


        // 获取哪个注释里面的值是否和 这个一样了。
        Assert.assertEquals("1.0.0",env.getProperty("app.version"));

        // 一样的。只不过是比较模拟配置文件的。
        Assert.assertEquals("admin",env.getProperty("app.admin.name"));
        Assert.assertEquals("true",env.getProperty("app.admin.enable"));
    }
}
