package com.utsoft.spring.controller;

import com.utsoft.spring.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用 Junit 来测试这里面的方法。
 * @Author:Administrator
 * @Date:2017/4/10 21:52
 */
@RestController
public class BookController {

    @Autowired
    private UserDao userDao;


    @GetMapping("/book/home")
    public String home(){
        System.out.println("======LOVE=====");
        return "book_kobe_LOVE";
    }


    @GetMapping("/book/show")
    public String show(@RequestParam("id") String id){
        System.out.println("======show 方法。=====");
        userDao.add("kobe");
        return "id" + id;
    }

}
