package com.utsoft.spring.testController;

import com.utsoft.spring.config.TestBeanConfigruation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试 controller 里面的方法。
 *
 * @Author:Administrator
 * @Date:2017/4/10 23:09
 */
@RunWith(SpringRunner.class)
// 指定一个随机端口。 这个注解它就可以加载整个 springboot 容器进来。
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestBookController {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Test
    public void handler() {
        // 访问 BookController 里面的方法。
        // getForObject("访问URL","返回类型是")，get方式访问。
        String boty = testRestTemplate.getForObject("/book/home",String.class);
        // 访问哪个URL 如果结果等于 book_kobe_LOVE 就对了、不是就报错。
        Assert.assertEquals("book_kobe_LOVE",boty);
        // 哪个URL 就被请求了一次。
    }

    // 测试带有参数的URL
    @Test
    public void handlerShow() {
        String boty = testRestTemplate.getForObject("/book/show?id=100",String.class);
        Assert.assertEquals("id100",boty);
    }

}
