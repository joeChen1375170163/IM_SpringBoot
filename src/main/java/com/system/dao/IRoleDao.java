package com.system.dao;

import com.system.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *
 * @author cxh
 * @date 2021/5/7 10:24
 */
@Repository
@Mapper
public interface IRoleDao {

    /**
     * 查询角色列表
     * @param param
     * @return
     */
    public List<Role> queryList(Role param);

    /**
     * 查询权限
     * @param userId
     * @return
     */
    List<String> queryCodeByUserId (@Param("userId") String userId);

    /**
     * 新增角色
     * @param param
     */
    public void insertRole(Role param);

    /**
     * 修改角色
     * @param param
     */
    public void updateRole(Role param);

    /**
     * 查看角色
     * @param roleId
     */
    public Role queryRoleByRoleId(@Param("roleId") String roleId);

    /**
     * 删除角色
     * @param roleId
     */
    void delRole (@Param("roleId") String roleId);

    /**
     * 批量删除
     * @param idList
     */
    void batchDelRole (@Param("list") List<String> idList);
}
