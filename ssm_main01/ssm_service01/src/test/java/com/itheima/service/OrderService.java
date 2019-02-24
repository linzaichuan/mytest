package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.dao.IOrdersDao;
import com.itheima.domain.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml","classpath:spring-security.xml"})
public class OrderService {

    @Autowired
    private IOrdersService ordersService;
    @Test
    public void findByPage(){
       /* PageInfo<Orders> pageInfo = ordersService.findByPage(1, 2);
        System.out.println(pageInfo);*/
        System.out.println("11");
    }
}
