package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    @Select("SELECT * from sys_permission")
    List<Permission> findAll();


    @Insert("INSERT into sys_permission VALUES (seq_permission.nextval,#{permissionName},#{url},#{pid})")
    void  save(Permission permission);

    @Select("SELECT * from sys_permission p " +
            " inner JOIN  sys_role_permission rp on p.id = rp.permissionid " +
            " WHERE rp.roleid = #{roleId} ")
    List<Permission> findPermissionByRoleId(Integer roleId);

    @Insert("INSERT into sys_role_permission VALUES (#{arg0},#{arg1})")
     void insert(Integer permissionid , Integer roleid);

    @Delete("DELETE  from sys_role_permission where roleid = #{roleId}")
    void delete(Integer roleId);

}
