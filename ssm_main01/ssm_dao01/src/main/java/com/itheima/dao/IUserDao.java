package com.itheima.dao;

import com.itheima.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IUserDao {

    @Select("SELECT * from sys_user where username = #{username}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roles",column = "id",javaType = List.class,
                    many=@Many(select = "com.itheima.dao.IRoleDao.findRoleByUserId",fetchType = FetchType.LAZY)
            )
    })

    List<SysUser> findByUsername(String username);

    @Select("SELECT * from sys_user")
    List<SysUser> findAll();

    @Insert("INSERT into sys_user VALUES (seq_user.nextval,#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(SysUser sysUser);

    @Select("SELECT * from sys_user WHERE id = #{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roles",column = "id",javaType = List.class,
            many=@Many(select = "com.itheima.dao.IRoleDao.findRoleByUserId",fetchType = FetchType.LAZY)
            )
    })

    SysUser findById(Integer id);

    @Delete("DELETE from sys_user_role WHERE userid = #{userId}")
    void deleteUserRoleByUserId(Integer userId);

    @Insert("INSERT  into sys_user_role(userid,roleid) VALUES (#{arg0},#{arg1})")
    void saveUserRole(Integer userId,Integer roleId);


}
