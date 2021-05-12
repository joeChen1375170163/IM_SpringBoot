package com.system.controller;

import com.system.entity.User;
import com.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * 用户controller
 * @author cxh
 * @date 2021/5/6 17:56
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询列表
     * @param user
     * @return
     */
    @PostMapping("/queryList")
    public Object queryList(@RequestBody User user)
    {
        return userService.queryList(user);
    }

    /**
     * 新增或修改
     * @param user
     * @return
     */
    @PostMapping("/addOrEdit")
    public Object addOrEdit(@RequestBody User user)
    {
        return userService.addOrEdit(user);
    }

    /**
     * 查看
     * @param user
     * @return
     */
    @PostMapping("/query")
    public Object query(@RequestBody User user)
    {
        return userService.query(user);
    }

    /**
     * 删除
     * @param user
     * @return
     */
    @PostMapping("/del")
    public Object del(@RequestBody User user)
    {
        return userService.del(user);
    }
}
