package com.itheima.service;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update(Product product);

    void delete(String productIds);


    PageBean<Product> findByPage(int pageNum , int pageSize);


}
