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
 * @TableName appointment
 */
@TableName(value ="appointment")
@Data
public class Appointment implements Serializable {
    /**
     * 预约ID，主键，自增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID，外键关联用户表
     */
    private Integer userId;

    /**
     * 检测项目ID，外键关联检测项目表
     */
    private Integer examId;

    /**
     * 预约时间
     */
    private Date appointmentTime;

    /**
     * 预约状态（例如：待确认、已确认、已取消）
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}