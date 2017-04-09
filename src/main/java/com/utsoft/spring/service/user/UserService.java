package com.utsoft.spring.service.user;

import com.utsoft.spring.dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 这是一个
 * @Author:Administrator
 * @Date:2017/4/9 23:04
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;




}
