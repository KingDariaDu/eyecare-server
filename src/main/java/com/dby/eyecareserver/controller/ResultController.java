package com.dby.eyecareserver.controller;

import com.dby.eyecareserver.entity.Result;
import com.dby.eyecareserver.service.ResultService;
import com.dby.eyecareserver.dto.ResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@Tag(name = "检测结果管理")
@RestController
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @Operation(summary = "创建检测结果")
    @Parameters({
        @Parameter(name = "appointmentId", description = "预约ID", required = true),
        @Parameter(name = "examId", description = "检测项目ID", required = true),
        @Parameter(name = "data", description = "检测结果数据(JSON格式)", required = true)
    })
    @PostMapping("/create")
    public ResultDto createResult(Integer appointmentId, Integer examId, String data) {
        Result result = new Result();
        result.setAppointmentId(appointmentId);
        result.setExamId(examId);
        result.setData(data);
        result.setExamTime(new Date());
        boolean success = resultService.save(result);
        return success ? ResultDto.ok().setMsg("结果创建成功").setData(result) : ResultDto.error().setMsg("结果创建失败");
    }

    @Operation(summary = "查询检测结果")
    @Parameter(name = "id", description = "结果ID", required = true)
    @GetMapping("/get")
    public ResultDto getResult(Integer id) {
        Result result = resultService.getById(id);
        return result != null ? ResultDto.ok().setData(result) : ResultDto.error().setMsg("结果不存在");
    }

    @Operation(summary = "分页查询结果列表")
    @Parameters({
        @Parameter(name = "pageNum", description = "页码", required = true),
        @Parameter(name = "pageSize", description = "每页数量", required = true),
        @Parameter(name = "appointmentId", description = "预约ID查询"),
        @Parameter(name = "examId", description = "检测项目ID查询")
    })
    @GetMapping("/list")
    public ResultDto getResultList(
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(required = false) Integer appointmentId,
            @RequestParam(required = false) Integer examId) {
        Page<Result> page = new Page<>(pageNum, pageSize);
// 以下是修正后的代码
QueryWrapper<Result> queryWrapper = new QueryWrapper<>();
        if (appointmentId != null) {
            queryWrapper.eq("appointment_id", appointmentId);
        }
        if (examId != null) {
            queryWrapper.eq("exam_id", examId);
        }
        Page<Result> resultPage = resultService.page(page, queryWrapper);
        return ResultDto.ok().setData(resultPage.getRecords());
    }

    @Operation(summary = "更新检测结果")
    @Parameters({
        @Parameter(name = "id", description = "结果ID", required = true),
        @Parameter(name = "data", description = "更新后的检测结果数据(JSON格式)")
    })
    @PostMapping("/update")
    public ResultDto updateResult(Integer id, String data) {
        Result result = resultService.getById(id);
        if (result == null) {
            return ResultDto.error().setMsg("结果不存在");
        }
        result.setData(data);
        boolean success = resultService.updateById(result);
        return success ? ResultDto.ok().setMsg("更新成功") : ResultDto.error().setMsg("更新失败");
    }

    @Operation(summary = "删除检测结果")
    @Parameter(name = "id", description = "结果ID", required = true)
    @DeleteMapping("/delete")
    public ResultDto deleteResult(Integer id) {
        boolean success = resultService.removeById(id);
        return success ? ResultDto.ok().setMsg("删除成功") : ResultDto.error().setMsg("删除失败");
    }
}