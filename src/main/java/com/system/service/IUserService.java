package com.system.service;

import com.system.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO
 *
 * @author cxh
 * @date 2021/4/30 11:28
 */
public interface IUserService {
    /**
     * 用户登录
     * @param user
     * @return
     */
    Object login (User user, HttpServletRequest request, HttpServletResponse response);

    /**
     * 根据token 获取 信息
     * @param user
     * @return
     */
    Object queryUserInfo (User user);

    /**
     * 根据token  删除 登入信息
     * @param user
     * @return
     */
    Object delUserInfo (User user,HttpServletResponse response);

    /**
     * 查询用户列表
     * @param user
     * @return
     */
    Object queryList (User user);

    /**
     * 新增or修改
     * @param user
     * @return
     */
    Object addOrEdit (User user);

    /**
     * 查看
     * @param user
     * @return
     */
    Object query (User user);

    /**
     * 删除
     * @param user
     * @return
     */
    Object del (User user);
}
