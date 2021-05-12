package com.system.entity;

import com.util.BaseEntity;
import lombok.Data;

/**
 * TODO
 *  异常记录信息
 * @author cxh
 * @date 2021/5/7 11:51
 */
@Data
public class ExceptionEntity extends BaseEntity {
    private String id;
    private String code;// 报错code
    private String exception;// 报错信息
}
