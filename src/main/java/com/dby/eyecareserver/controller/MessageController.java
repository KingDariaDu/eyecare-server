package com.dby.eyecareserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dby.eyecareserver.dto.ResultDto;
import com.dby.eyecareserver.entity.Message;
import com.dby.eyecareserver.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@Tag(name = "留言管理")
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Operation(summary = "创建留言")
    @Parameters({
        @Parameter(name = "userId", description = "用户ID", required = true),
        @Parameter(name = "content", description = "留言内容", required = true)
    })
    @PostMapping("/create")
    public ResultDto createMessage(Integer userId, String content) {
        Message message = new Message();
        message.setUserId(userId);
        message.setContent(content);
        message.setCreateTime(new Date());
        boolean success = messageService.save(message);
        return success ? ResultDto.ok().setMsg("留言创建成功").setData(message) : ResultDto.error().setMsg("留言创建失败");
    }

    @Operation(summary = "查询留言")
    @Parameter(name = "id", description = "留言ID", required = true)
    @GetMapping("/get")
    public ResultDto getMessage(Integer id) {
        Message message = messageService.getById(id);
        return message != null ? ResultDto.ok().setData(message) : ResultDto.error().setMsg("留言不存在");
    }

    @Operation(summary = "分页查询留言列表")
    @Parameters({
        @Parameter(name = "pageNum", description = "页码", required = true),
        @Parameter(name = "pageSize", description = "每页数量", required = true),
        @Parameter(name = "userId", description = "用户ID")
    })
    @GetMapping("/list")
    public ResultDto getMessageList(
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(required = false) Integer userId) {
        Page<Message> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        if (userId != null) {
            queryWrapper.eq("user_id", userId);
        }
        Page<Message> messagePage = messageService.page(page, queryWrapper);
        return ResultDto.ok().setData(messagePage.getRecords());
    }

    @Operation(summary = "删除留言")
    @Parameter(name = "id", description = "留言ID", required = true)
    @DeleteMapping("/delete")
    public ResultDto deleteMessage(Integer id) {
        boolean success = messageService.removeById(id);
        return success ? ResultDto.ok().setMsg("删除成功") : ResultDto.error().setMsg("删除失败");
    }
}