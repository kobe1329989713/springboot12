package com.utsoft.spring.dao.user;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    /**
     * 添加方法。
     * @param username 添加的用户名
     * @return 1成功，0失败。
     */
    public Integer add(String username){
        System.out.println("添加的用户是：" + username);
        if(username == null){
            return 0;
        }
        return 1;
    }

}
