package com.utsoft.spring;

import com.utsoft.spring.dao.user.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot12ApplicationTests {
	@Autowired
	private UserDao userDao;

	@Test
	public void testAdd2() throws Exception {
		Integer resout = userDao.add("22kobe22");
		System.out.println("返回结果是22："+ resout);
		Integer resout2 = userDao.add(null);
		System.out.println("22返回结果是："+ resout2);
	}

}
