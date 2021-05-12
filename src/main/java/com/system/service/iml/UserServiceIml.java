package com.system.service.iml;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.dao.IRoleDao;
import com.system.dao.IUserDao;
import com.system.entity.User;
import com.system.service.IUserService;
import com.util.CookieUtils;
import com.util.ResultUtil;
import com.util.UUIDtils;
import com.util.redisUtil.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * TODO
 *  登录service
 * @author cxh
 * @date 2021/4/30 11:29
 */
@Service
public class UserServiceIml implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private IRoleDao roleDao;
    @Autowired
    private RedisClient redisClient;

    @Override
    public Object login (User param, HttpServletRequest request, HttpServletResponse response) {
        User user = userDao.queryUserByName(param.getUserName());
        if ( StringUtils.isEmpty(user) || !param.getPassword().equals(user.getPassword()) ) {
            return ResultUtil.failResult("账号或密码不正确");
        }
        user.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        CookieUtils.addCookie(response, user, redisClient);
        return ResultUtil.successResult(user);
    }

    @Override
    public Object queryUserInfo (User user) {
        String userStr = redisClient.get(CookieUtils.COOKIE_NAME_TOKEN + "::" + user.getToken());
        JSONObject json = JSONObject.parseObject(userStr);
        List<String> a =roleDao.queryCodeByUserId(json.getString("userId"));
        json.put("roles", a);
        return ResultUtil.successResult(json);
    }

    @Override
    public Object delUserInfo (User user,HttpServletResponse response) {
        CookieUtils.delCookie(response, user, redisClient);
        return ResultUtil.successResult("请重新登录");
    }

    @Override
    public Object queryList (User user) {
        PageHelper.startPage(1, 10);
        List<User> userList=userDao.queryList(user);
        return ResultUtil.successResult(new PageInfo<>(userList));
    }

    @Override
    public Object addOrEdit (User user) {
        if(!StringUtils.isEmpty(user.getUserId()))
        {//修改
            userDao.update(user);
        }else
        {//新增
            user.setPassword("admin123456");
            user.setUserId(UUIDtils.uuId());
            userDao.insert(user);
        }
        return ResultUtil.successResult("操作成功");
    }

    @Override
    public Object query (User user) {
        return ResultUtil.successResult(userDao.queryUserById(user.getUserId()));
    }

    @Override
    public Object del (User user) {
        userDao.batchDel(user.getIdList());
        return ResultUtil.successResult("操作成功");
    }
}
