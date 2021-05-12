package com.system.service;

import com.system.entity.Role;

import java.util.List;

/**
 * TODO
 *
 * @author cxh
 * @date 2021/5/7 10:35
 */
public interface IRoleService {

    /**
     * 角色查询列表
     * @param param
     * @return
     */
    public Object queryList(Role param);

    /**
     * 新增 修改
     * @param role
     * @return
     */
    Object addOrEdit (Role role);

    /**
     * 删除
     * @param role
     * @return
     */
    Object del (Role role);

    /**
     * 查询
     * @param role
     * @return
     */
    Object query (Role role);
}
