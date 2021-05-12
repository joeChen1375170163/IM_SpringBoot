package com.system.controller;

import com.system.entity.Role;
import com.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * 角色 controller
 * @author cxh
 * @date 2021/5/7 9:36
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 查询列表
     * @param role
     * @return
     */
    @PostMapping("/queryList")
    public Object queryList(@RequestBody Role role)
    {
        return roleService.queryList(role);
    }

    /**
     * 新增修改
     * @param role
     * @return
     */
    @PostMapping("/addOrEdit")
    public Object addOrEdit(@RequestBody Role role)
    {
        return roleService.addOrEdit(role);
    }

    /**
     * 删除
     * @param role
     * @return
     */
    @PostMapping("/del")
    public Object del(@RequestBody Role role)
    {
        return roleService.del(role);
    }

    /**
     * 查看
     * @param role
     * @return
     */
    @PostMapping("/query")
    public Object query(@RequestBody Role role)
    {
        return roleService.query(role);
    }
}
