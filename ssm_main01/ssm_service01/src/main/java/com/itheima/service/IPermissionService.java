package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Permission;

import java.util.List;

public interface IPermissionService {

    PageInfo<Permission> findByPage(int pageNum , int pageSize);

    void save(Permission permission);


      List<Permission> findPermissionByRoleId(Integer id);

      List<Permission> findAll();

    void insert(Integer[] permissionids , Integer roleId );

}
