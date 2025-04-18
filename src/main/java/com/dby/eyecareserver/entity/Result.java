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
 * @TableName result
 */
@TableName(value ="result")
@Data
public class Result implements Serializable {
    /**
     * 检测结果ID，主键，自增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 预约ID，外键关联预约表
     */
    private Integer appointmentId;

    /**
     * 检测项目ID，外键关联检测项目表
     */
    private Integer examId;

    /**
     * 检测结果数据，以JSON格式存储，例如：{ “left_eye”: “5.0”, “right_eye”: “4.8” }
     */
    private String data;

    /**
     * 检测时间
     */
    private Date examTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}