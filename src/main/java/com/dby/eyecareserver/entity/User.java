package com.dby.eyecareserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@Data // 确保该注解存在（已正确使用）
@TableName(value ="user")
public class User implements Serializable {
    /**
     * 用户ID，主键，自增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名，唯一索引
     */
    private String username;

    /**
     * 密码，加密存储
     */
    private String password;

    /**
     * 用户真实姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 注册时间
     */
    private Date registerTime;
    /**
     * 用于加密的随机盐
     */
    private String token;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}