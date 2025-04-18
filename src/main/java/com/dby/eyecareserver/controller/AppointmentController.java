package com.dby.eyecareserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dby.eyecareserver.dto.ResultDto;
import com.dby.eyecareserver.entity.Appointment;
import com.dby.eyecareserver.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Tag(name = "预约管理")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Operation(summary = "创建预约")
    @Parameters({
        @Parameter(name = "userId", description = "用户ID", required = true),
        @Parameter(name = "examId", description = "眼科项目ID", required = true),
        @Parameter(name = "appointmentTime", description = "预约日期", required = true)
    })
    @PostMapping("/create")
    public ResultDto createAppointment(Integer userId, Integer examId, @DateTimeFormat(pattern = "yyyy-MM-dd") Date appointmentTime) {
        Appointment appointment = new Appointment();
        appointment.setUserId(userId);
        appointment.setExamId(examId);
        appointment.setAppointmentTime(appointmentTime);
        appointment.setStatus(0); // 0表示待确认
        boolean success = appointmentService.save(appointment);
        return success ? ResultDto.ok().setMsg("预约创建成功").setData(appointment) : ResultDto.error().setMsg("预约创建失败");
    }

    @Operation(summary = "查询预约")
    @Parameter(name = "id", description = "预约ID", required = true)
    @GetMapping("/get")
    public ResultDto getAppointment(Integer id) {
        Appointment appointment = appointmentService.getById(id);
        return appointment != null ? ResultDto.ok().setData(appointment) : ResultDto.error().setMsg("预约不存在");
    }

    @Operation(summary = "分页查询预约列表")
    @Parameters({
        @Parameter(name = "pageNum", description = "页码", required = true),
        @Parameter(name = "pageSize", description = "每页数量", required = true),
        @Parameter(name = "userId", description = "用户ID"),
        @Parameter(name = "examId", description = "眼科项目ID")
    })
    @GetMapping("/list")
    public ResultDto getAppointmentList(
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(required = false) Integer userId,
            @RequestParam(required = false) Integer examId) {
        Page<Appointment> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Appointment> queryWrapper = new QueryWrapper<>();
        if (userId != null) {
            queryWrapper.eq("user_id", userId);
        }
        if (examId != null) {
            queryWrapper.eq("exam_id", examId);
        }
        Page<Appointment> appointmentPage = appointmentService.page(page, queryWrapper);
        return ResultDto.ok().setData(appointmentPage.getRecords());
    }

    @Operation(summary = "更新预约状态")
    @Parameters({
        @Parameter(name = "id", description = "预约ID", required = true),
        @Parameter(name = "status", description = "状态(0:待确认,1:已确认,2:已取消)", required = true)
    })
    @PostMapping("/update-status")
    public ResultDto updateAppointmentStatus(Integer id, Integer status) {
        Appointment appointment = appointmentService.getById(id);
        if (appointment == null) {
            return ResultDto.error().setMsg("预约不存在");
        }
        appointment.setStatus(status);
        boolean success = appointmentService.updateById(appointment);
        return success ? ResultDto.ok().setMsg("状态更新成功") : ResultDto.error().setMsg("状态更新失败");
    }

    @Operation(summary = "取消预约")
    @Parameter(name = "id", description = "预约ID", required = true)
    @DeleteMapping("/cancel")
    public ResultDto cancelAppointment(Integer id) {
        boolean success = appointmentService.removeById(id);
        return success ? ResultDto.ok().setMsg("预约取消成功") : ResultDto.error().setMsg("预约取消失败");
    }
}