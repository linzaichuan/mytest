package com.itheima.luence.dao.impl;

import com.itheima.luence.Book;
import com.itheima.luence.dao.BookDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> findAll() {
        // 创建List集合封装查询结果
        List<Book> bookList = new ArrayList<Book>();
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try{
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 创建数据库连接对象
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/lucene_db","root","root");
            // 编写sql语句
            String sql = "select * from book";
            // 创建statement
            psmt = connection.prepareStatement(sql);
            // 执行查询
            rs = psmt.executeQuery();
            // 处理结果集
            while (rs.next()){
                // 创建图书对象
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setBookName(rs.getString("bookname"));
                book.setPrice(rs.getFloat("price"));
                book.setPic(rs.getString("pic"));
                book.setBookDesc(rs.getString("bookdesc"));
                bookList.add(book);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            // 释放资源
            try{
                if(rs != null) rs.close();
                if(psmt != null) psmt.close();
                if(connection != null) connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return bookList;
    }

}
