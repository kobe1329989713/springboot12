package com.utsoft.spring.testController;

import com.utsoft.spring.controller.BookController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * 测试 controller 里面的方法。之第二种方法。
 *
 * @Author:Administrator
 * @Date:2017/4/10 23:09
 */
@RunWith(SpringRunner.class)
// 指定你需要测试哪个 controller 类。
// 注：它只测试你指定的哪个 controller 类，不会加载整个 springboot 容器的。
// 而这个 controller 里面的依赖的哪个对象、需要自己去 mock 进来。
@WebMvcTest(controllers = BookController.class)
public class TestBookController02 {

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
