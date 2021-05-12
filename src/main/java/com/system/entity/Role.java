package com.system.entity;

import com.util.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * TODO
 *
 * @author cxh
 * @date 2021/5/7 9:39
 */
@Data
public class Role extends BaseEntity {
    private String roleId;
    private String name;//角色名称
    private String roleCode;//角色code
    private String remark;//备注

    private List<String> idList;//删除用
}
