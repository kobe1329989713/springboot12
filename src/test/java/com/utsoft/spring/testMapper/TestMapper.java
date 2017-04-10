package com.utsoft.spring.testMapper;

import com.utsoft.spring.mapper.IUserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试正常环境的接口。
 * @Author:Administrator
 * @Date:2017/4/10 1:52
 */
@RunWith(SpringRunner.class)
public class TestMapper {

    // 因为接口是不能有实例的、所以用这个注解
    @MockBean
    private IUserMapper iUserMapper;
    @Before
    public void init(){
        // 测试哪个接口。只能传 admin 返回1 代表成功。
        BDDMockito.given(iUserMapper.createUser("admin")).willReturn(1);
        // 测试哪个接口。只能传 空 返回0 代表失败。
        BDDMockito.given(iUserMapper.createUser("")).willReturn(0);
        // 测试哪个接口。只能传 null 抛出一个空指针
        BDDMockito.given(iUserMapper.createUser("")).willThrow(NullPointerException.class);
    }

    // 预测的、测试
    @Test(expected = NullPointerException.class) // 抛异常时，用它可以把一个异常给过滤掉。
    public void handler(){
        // 调用哪个方法 传入admin 返回1
        Assert.assertEquals(Integer.valueOf(1),iUserMapper.createUser("admin"));
        // 调用哪个方法 传入"" 空 返回0
        Assert.assertEquals(Integer.valueOf(1),iUserMapper.createUser(""));
        // 调用哪个方法 传入 null 抛出异常。
        Assert.assertEquals(Integer.valueOf(1),iUserMapper.createUser(null));

        // 调用哪个方法 传入 没有预测的参数 会
        //Assert.assertEquals(Integer.valueOf(1),iUserMapper.createUser("kobe"));
    }
}
