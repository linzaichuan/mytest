package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.IPermissionDao;
import com.itheima.domain.Permission;
import com.itheima.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionService implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public PageInfo<Permission> findByPage(int pageNum ,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Permission> list = permissionDao.findAll();
        return new PageInfo<>(list);
    }

    @Override
    public void save(Permission permission) {
             permissionDao.save(permission);
    }

    @Override
    public List<Permission> findPermissionByRoleId(Integer id) {
        return permissionDao.findPermissionByRoleId(id);
    }

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }


    public void insert(Integer[] permissionids, Integer roleId) {
        permissionDao.delete(roleId);
        if(permissionids != null && permissionids.length >0){
            for (Integer permissionid : permissionids) {
                    permissionDao.insert(permissionid,roleId );
            }
        }
    }

}
