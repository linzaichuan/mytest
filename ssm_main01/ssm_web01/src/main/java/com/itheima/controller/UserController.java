package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.domain.Role;
import com.itheima.domain.SysUser;
import com.itheima.service.IOrdersService;
import com.itheima.service.IRoleService;
import com.itheima.service.IUserService;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/user")
/*@RolesAllowed("ROLE_ADMIN")*/
/*@Secured("ROLE_ADMIN")*/
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class UserController {


    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;



    @RequestMapping("/findByPage")
    public ModelAndView findByPage(@RequestParam(defaultValue = "1") int pageNum ,
                                   @RequestParam(defaultValue = "2") int pageSize){
        /*
        * 测试代码,获取用户名
        * */
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user =(User) authentication.getPrincipal();
        System.out.println("用户名:"+user.getUsername());
        PageInfo<SysUser> pageInfo = userService.findByPage(pageNum, pageSize);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

    @RequestMapping("/save")
    public String save(SysUser sysUser){
        userService.save(sysUser);
        return "redirect:/user/findByPage";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(Integer id){
        //调用service根据主键查询
        SysUser sysUser = userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-show");
        mv.addObject("user",sysUser);
        return mv;
    }

    @RequestMapping("/toUserRole")
    public ModelAndView toUserRole(int id){
        SysUser sysUser = userService.findById(id);
        List<Role> roleList = sysUser.getRoles();
        String rolesStr = "";
        if(roleList != null && roleList.size()>0){
            for (Role role : roleList) {
                rolesStr += role.getRoleName()+",";
            }
        }
        List<Role> allRoleList = roleService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-role-add");
        mv.addObject("user",sysUser);
        mv.addObject("rolesStr",rolesStr);
        mv.addObject("allRoleList",allRoleList);
        return mv;
    }

    @RequestMapping("/addRoleToUser")
    public  String  addRoleToUser(Integer userId, @RequestParam(value = "ids",required = false) Integer[] roleIds){
          userService.addRoleToUser(userId,roleIds );
          return "redirect:/user/findByPage";
    }

}
