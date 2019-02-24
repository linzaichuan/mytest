package com.itheima.dao;

import com.itheima.domain.Orders;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOrdersDao {

    @Select("SELECT o.* ,p.id pid ,productnum ,productname ,cityname,departuretime , productprice , productdesc , productstatus from orders o inner join product p on o.productId = p.id")
    @Results({
            @Result(id = true ,property = "id" ,column = "id"),
            @Result(property ="product.id",column ="pid"),
            @Result(property ="product.productNum",column ="productnum"),
            @Result(property ="product.productName",column ="productname"),
            @Result(property ="product.cityName",column ="cityname"),
            @Result(property ="product.departureTime",column ="departuretime"),
            @Result(property ="product.productPrice",column ="productprice"),
            @Result(property ="product.productDesc",column ="productdesc"),
            @Result(property ="product.productStatus",column ="productstatus")
    })
    List<Orders> findAll();
}
