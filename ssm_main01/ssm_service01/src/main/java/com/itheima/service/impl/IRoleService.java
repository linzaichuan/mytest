package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.IRoleDao;
import com.itheima.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IRoleService implements com.itheima.service.IRoleService {


    @Autowired
    private IRoleDao roleDao;

    @Override
    public PageInfo<Role> findByPage(int pageNum, int pageSize) {
       PageHelper.startPage(pageNum, pageSize);
        List<Role> list = roleDao.findAll();
        return new PageInfo<>(list);
    }

    @Override
    public void save(Role role) {
      roleDao.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findByRoleId(Integer id) {
        return roleDao.findByRoleId(id);
    }
}
