package com.system.entity;

import com.util.BaseEntity;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * TODO
 *
 * @author cxh
 * @date 2021/4/30 11:13
 */
@Validated
@Data
public class User extends BaseEntity {
    private String userId;
    @NotBlank(message="账号不能为空")
    private String userName;//账号
    @NotBlank(message="密码不能为空")
    private String password;//密码
    private String name;//真名
    private String tel;//联系电话
    private String address;//地址
    private String introduction;//备注  简介
    private String avatar;// 登入人 头像地址
    private List<String> roles;
    private String token;//登入时随机生产一个token 传给前台

    private List<String> idList;//删除id
}
