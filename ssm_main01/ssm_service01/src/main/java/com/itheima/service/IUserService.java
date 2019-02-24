package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Role;
import com.itheima.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {


    PageInfo<SysUser> findByPage(int pageNum ,int pageSize);

    void save(SysUser sysUser);

    SysUser findById(Integer id);

    void addRoleToUser(Integer userId,Integer[] roleIds);

}
