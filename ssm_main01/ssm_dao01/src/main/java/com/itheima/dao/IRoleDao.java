package com.itheima.dao;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IRoleDao {

    @Select("SELECT * from sys_role")
    List<Role> findAll();


    /*添加*/
    @Insert("INSERT into sys_role VALUES (seq_role.nextval,#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("SELECT * from sys_role r " +
            " inner join sys_user_role ur on r.id = ur.roleid " +
            " where ur.userid = #{userId} ")
    @Results({
           @Result(id = true , property = "id" , column = "id"),
            @Result(property = "permissions",column = "id",javaType = List.class,
                many=@Many(select = "com.itheima.dao.IPermissionDao.findPermissionByRoleId" ,fetchType = FetchType.LAZY)
            )
    })
    List<Role> findRoleByUserId(Integer userId);



 @Select("SELECT * from sys_role where id = #{id}")
 @Results({
         @Result(id = true , property = "id" , column = "id"),
         @Result(property = "permissions",column = "id",javaType = List.class,
                 many=@Many(select = "com.itheima.dao.IPermissionDao.findPermissionByRoleId" ,fetchType = FetchType.LAZY)
         )
 })
   Role findByRoleId(Integer id);
}
