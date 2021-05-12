package com.system.entity;

import com.util.BaseEntity;
import lombok.Data;

/**
 * TODO
 *
 * @author cxh
 * @date 2021/5/7 9:42
 */
@Data
public class UserRoleTemp extends BaseEntity {
    private String id;
    private String userId;
    private String roleId;
    private String userName;
    private String roleName;
    private String roleCode;
}
