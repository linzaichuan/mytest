package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IProductDao {

    @Select("SELECT * from product")
    List<Product> findAll();

    @Insert("INSERT into product VALUES (SEQ_PRODUCT.nextval,#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    @Select("SELECT * from product where id = #{id}")
    Product findById(Integer id);

    @Update("UPDATE product set productNum = #{productNum},productName = #{productName},cityName = #{cityName},departureTime = #{departureTime},productPrice = #{productPrice},productDesc = #{productDesc},productStatus = #{productStatus} WHERE id = #{id}")
    void update(Product product);

    @Delete("DELETE  from product where id = #{id}")
    void delete(String id);



     @Select("select * from (select p.* ,rownum rn from product p where rownum <= #{count}) where rn > #{index}")
    List<Product> findByPage(@Param("index") int index , @Param("count") int count);

    /**
     * 查询总记录数
     * 注意：count(1)统计的结果与count(*)一样的。但count(1)效率更高。
     */
     @Select("select count(1) from product ")
     Long count();
}
