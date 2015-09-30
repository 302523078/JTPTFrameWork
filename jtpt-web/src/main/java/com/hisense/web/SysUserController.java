package com.hisense.web;

import com.hisense.core.controller.BaseController;
import com.hisense.core.util.HqlFilter;
import com.hisense.jtpt.entity.SysUser;
import com.hisense.jtpt.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bcm on 15-9-30.
 */
@Controller
@RequestMapping("sysUserController")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/getAllSysUsers", method = RequestMethod.GET)
    public String getAllSysUsers(HttpServletRequest request,Model model){
        HqlFilter hqlFilter = this.makeHqlFilter(request);
        List<SysUser> users = sysUserService.findByFilter(hqlFilter,hqlFilter.getCurPageNo(),hqlFilter.getPageSize());
        model.addAttribute("users", users);
        return "/user/userlist";
    }

    @RequestMapping(value = "/getAllSysUsers", method = RequestMethod.POST)
    public String getAllSysUsersByCondition(HttpServletRequest request,Model model){
        HqlFilter hqlFilter = this.makeHqlFilter(request);
        List<SysUser> users = sysUserService.findByFilter(hqlFilter,hqlFilter.getCurPageNo(),hqlFilter.getPageSize());
        model.addAttribute("users", users);
        return "/user/userlist";
    }

    @RequestMapping(value = "/saveSysUser", method = RequestMethod.POST)
    public void saveSysUser(@ModelAttribute SysUser sysUser,HttpServletResponse response){
        sysUserService.save(sysUser);
        System.out.println();
    }

    @RequestMapping(value = "/saveSysUser", method = RequestMethod.GET)
    public String saveSysUserInit(){
        return "/user/user";
    }


}
