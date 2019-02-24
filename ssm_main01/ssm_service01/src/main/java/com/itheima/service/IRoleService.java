package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Role;

import java.util.List;

public interface IRoleService {


    PageInfo<Role> findByPage(int pageNum ,int pageSize);

    void save(Role role);

    List<Role> findAll();

    Role findByRoleId(Integer id);

}
