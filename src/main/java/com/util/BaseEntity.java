package com.util;

import lombok.Data;

import java.util.Date;

/**
 * TODO
 *
 * @author cxh
 * @date 2021/4/30 11:20
 */
@Data
public class BaseEntity {
    private Date createDate;
    private Date updateDate;
    private String creator;//创建人
    private String updator;//修改人
    private String state;
}
