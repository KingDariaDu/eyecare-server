package com.dby.eyecareserver.dto;

import lombok.Data;
import lombok.experimental.Accessors;
/**
 * 统一返回结果的封装
 */
@Data
@Accessors(chain = true)
public class ResultDto {
    /**状态码 0-成功  -1-失败*/
    private Integer code;
    /**附加文本消息*/
    private String msg;
    /**处理结果是否成功*/
    private boolean success;
    /**附加返回数据，例如查询结果集*/
    private Object data;
    /**总数据条数（分页用：计算总页数）*/
    private Long count;

    private ResultDto(){}
    /**
     * 成功返回结果
     * @return
     */
    public static ResultDto ok() {
        ResultDto r = new ResultDto();
        r.code = 0;
        r.msg = "执行成功";
        r.success = true;
        return r;
    }
    /**
     * 失败返回结果
     * @return
     */
    public static ResultDto error() {
        ResultDto r = new ResultDto();
        r.code = -1;
        r.msg = "执行失败";
        r.success = false;
        return r;
    }
    public ResultDto setMsg(String msg) {
    this.msg = msg;
    return this;
}
    /**
     * 用户名存在
     */
    public static ResultDto userExist() {
        ResultDto r = new ResultDto();
        r.code = -2;
        r.msg = "用户名已存在";
        r.success = false;
        return r;
    }
}
