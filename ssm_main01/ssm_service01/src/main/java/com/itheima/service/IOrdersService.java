package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;

import java.util.List;

public interface IOrdersService {

    List<Orders> findAll();

    PageInfo<Orders> findByPage(int pageNum ,int pageSize);
}
