package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.IPermissionService;
import com.itheima.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {


    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/findByPage";
    }



    @RequestMapping("findByPage")
    public ModelAndView findByPage(@RequestParam(defaultValue = "1") int pageNum ,@RequestParam(defaultValue = "2") int pageSize){
        PageInfo<Role> pageInfo = roleService.findByPage(pageNum, pageSize);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("role-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

    @RequestMapping("/addPermissionByRole")
    public ModelAndView addPermissionByRole(int id){
  /*    List<Permission> permissionList = permissionService.findAll();
        List<Permission> permissionByRoleId = permissionService.findPermissionByRoleId(id);
        Role role = roleService.findByRoleId(id);
        String permissionIdStr = "";
        if(permissionByRoleId != null && permissionByRoleId.size()>0){
            for (Permission permission : permissionByRoleId) {
                permissionIdStr += permission.getPermissionName() + ",";
            }

        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionList",permissionList);
        mv.addObject("permissionIdStr",permissionIdStr);
        mv.addObject("role",role);
        mv.setViewName("role-permission-add");
        return mv;*/


        List<Permission> permissionList = permissionService.findAll();
        Role role = roleService.findByRoleId(id);
        List<Permission> permissions = role.getPermissions();
        String permissionIdStr = "";
        if(permissions != null && permissions.size()>0){
            for (Permission permission : permissions) {
                permissionIdStr += permission.getPermissionName() + ",";
            }

        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionList",permissionList);
        mv.addObject("permissionIdStr",permissionIdStr);
        mv.addObject("role",role);
        mv.setViewName("role-permission-add");
        return mv;

    }


    @RequestMapping("/addPermissionToRole")
    public  String  addPermissionToRole(@RequestParam(value = "ids",required = false) Integer[] permissionids ,Integer roleId ){
        permissionService.insert(permissionids,roleId );
        return "redirect:/role/findByPage";
    }
}
