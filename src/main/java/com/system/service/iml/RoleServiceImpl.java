package com.system.service.iml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.dao.IRoleDao;
import com.system.entity.Role;
import com.system.service.IRoleService;
import com.util.ResultUtil;
import com.util.UUIDtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 * 角色service
 * @author cxh
 * @date 2021/5/7 10:36
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public Object queryList (Role param) {
        PageHelper.startPage(1, 10);
        List<Role> roleList=roleDao.queryList(param);
        return ResultUtil.successResult(new PageInfo<>(roleList));
    }

    @Override
    public Object addOrEdit (Role role) {
        if(StringUtils.isNotBlank(role.getRoleId()))
        {//修改
            roleDao.updateRole(role);
        }else
        {
            role.setRoleCode(UUIDtils.getCode());
            role.setRoleId(UUIDtils.uuId());
            roleDao.insertRole(role);
        }
        return ResultUtil.successResult("操作成功");
    }

    @Override
    public Object del (Role role) {
        roleDao.batchDelRole(role.getIdList());
        return ResultUtil.successResult("操作成功");
    }

    @Override
    public Object query (Role role) {
        return ResultUtil.successResult(roleDao.queryRoleByRoleId(role.getRoleId()));
    }
}
