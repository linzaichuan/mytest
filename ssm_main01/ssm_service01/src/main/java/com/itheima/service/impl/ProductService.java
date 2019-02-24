package com.itheima.service.impl;

import com.itheima.dao.IProductDao;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delete(String productIds) {
        if(productIds != null){
            String[] array = productIds.split(",");
            if(array != null || array .length > 0){
                for(String id: array){
                    productDao.delete(id);
                }
            }
        }

    }

    @Override
    public PageBean<Product> findByPage(int pageNum , int pageSize ) {
        if(pageNum < 1){
            pageNum = 1 ;
        }

        List<Product> list = productDao.findByPage((pageNum - 1) * pageSize,pageSize * pageNum);
        Long count = productDao.count();

        //封装PageBean
        PageBean<Product> pageBean = new PageBean<>();
        pageBean.setPageNum(pageNum);
        pageBean.setPageSize(pageSize);
        pageBean.setList(list);
        pageBean.setTotalCount(count);

        return pageBean;
    }


}
