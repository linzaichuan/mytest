package com.itheima.service;

import com.itheima.dao.IUserDao;
import com.itheima.domain.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-security.xml"})
public class userService {

    @Autowired
    private IUserService userService;
   @Autowired
   private IUserDao userDao;
    @Test
    public void  test01(){

        System.out.println(userDao.findAll());


    }

}
