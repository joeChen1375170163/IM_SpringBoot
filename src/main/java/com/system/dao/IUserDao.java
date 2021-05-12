package com.system.dao;

import com.system.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 * 用户dao
 * @author cxh
 * @date 2021/4/30 14:48
 */
@Repository
@Mapper
public interface IUserDao {
    /**
     * 查询登录人信息
     * @param name
     * @return
     */
    User queryUserByName(@Param("userName") String name);

    /**
     * 查询用户
     * @param user
     * @return
     */
    List<User> queryList (User user);

    /**
     * 新增用户
     * @param user
     */
    void insert (User user);

    /**
     * 修改用户
     * @param user
     */
    void update(User user);

    /**
     * 查看
     * @param userId
     * @return
     */
    User queryUserById (@Param("userId") String userId);

    /**
     * 批量删除
     * @param idList
     */
    void batchDel (@Param("list") List<String> idList);
}
