package com.utsoft.spring;

import com.utsoft.spring.config.TestBeanConfigruation;
import com.utsoft.spring.dao.user.UserDao;
import com.utsoft.spring.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * user 测试。
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestBeanConfigruation.class) // 把测试用的配置类、指定到这里面来测试。
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ApplicationContext context;


    @Test
    public void testAdd() throws Exception {
        userDao.add("kobe22");
        userDao.add(null);
    }

    @Test
    public void testAdd2() throws Exception {
        Integer reboot = userDao.add("kobe22");
        System.out.println("返回结果是：" + reboot);
        Integer resort2 = userDao.add(null);
        System.out.println("返回结果是：" + resort2);
    }

    /**
     * Assert.assertNotNull() :这个方法就是用于测试一个数据是否装配到了、springboot 的容器里面、没有就会报错的。
     */
    @Test
    public void handler() {
        System.out.println("为什么没有输出值呢？==:"+ context);
        System.out.println("user：" + User.class);
        // 因为这个方法是无返回的的，所以什么也没有打印出来。
        Assert.assertNotNull("==："+context.getBean(User.class));
        // TestBeanConfigruation 这个类容器本来就没有的、所以用 Assert.assertNotNull() 方法就会报错。
        Assert.assertNotNull("==："+context.getBean(TestBeanConfigruation.class));
    }
}
