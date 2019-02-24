package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Role;
import com.itheima.domain.SysUser;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void save(SysUser sysUser) {
        String password = passwordEncoder.encode(sysUser.getPassword());
        sysUser.setPassword(password);
        userDao.save(sysUser);
    }

    @Override
    public SysUser findById(Integer id) {
     return    userDao.findById(id);
    }

    @Override
    public void addRoleToUser(Integer userId, Integer[] roleIds) {
                userDao.deleteUserRoleByUserId(userId);
                if(roleIds != null && roleIds.length > 0){
                    for (Integer roleId : roleIds) {
                        userDao.saveUserRole(userId,roleId );
                    }
                }

    }

    @Override
    public PageInfo<SysUser> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysUser> list = userDao.findAll();
        return new PageInfo<>(list);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SysUser> list = userDao.findByUsername(username);
        if(list == null || list.size() ==0) {
            return null;
        }
        SysUser sysUser = list.get(0);
   //创造用户的权限集合
        List<Role> roles = sysUser.getRoles();
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        if(roles != null && roles.size()>0){
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
    }
        //4. 返回：数据库中正确的密码，用户的角色
        // 参数1: 返回的用户名
        // 参数2: 返回的用户名对应的密码(正确的密码)
        // 参数3：指定用户具有的角色。用户具有的角色要包含在spring-security.xml中配置的access="ROLE_ADMIN"
        User user = new User(username, sysUser.getPassword(), authorities);
        return user;
    }



}
