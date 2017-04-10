package com.utsoft.spring.testController;

import com.utsoft.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * 测试 controller 里面的方法。之第二种方法。
 *  @SpringBootTest 不能和  @WebMvcTest 同时使用
 * 如果使用MockMvc对象的话，需要另外加上@AutoConfigureMockMvc注解
 * @Author:Administrator
 * @Date:2017/4/10 23:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // 用它才能使用 MockMvc
public class TestBookController03 {

    @Autowired
    private MockMvc mvc;
    @Test
    public void handler() throws Exception {
        // 测试这个URL 希望它返回 200 ok 的状态码
        mvc.perform(MockMvcRequestBuilders.get("/book/home")).andExpect(MockMvcResultMatchers.status().isOk());
        // 希望它返回的结果是 aaa 结果不是所以报错。
        mvc.perform(MockMvcRequestBuilders.get("/book/home")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("book_kobe_LOVE"));
    }

    // 测试带有参数的URL
    @Test
    public void handlerShow() throws Exception {
        // 希望它返回的ID 是 400，                                                          指定参数
        mvc.perform(MockMvcRequestBuilders.get("/book/show").param("id", "400")).andExpect(MockMvcResultMatchers.status().isOk());
        // 希望它返回值是：结果不是所以报错。
        mvc.perform(MockMvcRequestBuilders.get("/book/show").param("id", "400")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("id400"));
    }

}
