package com.dby.eyecareserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dby.eyecareserver.dto.ResultDto;
import com.dby.eyecareserver.entity.Exam;
import com.dby.eyecareserver.service.ExamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;

@Tag(name = "眼科项目管理")
@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private ExamService examService;

    @Operation(summary = "创建眼科项目")
    @Parameters({
        @Parameter(name = "name", description = "项目名称", required = true),
        @Parameter(name = "description", description = "项目描述", required = true)
    })
    @PostMapping("/create")
    public ResultDto createExam(String name, String description) {
        Exam exam = new Exam();
        exam.setName(name);
        exam.setDescription(description);
        boolean success = examService.save(exam);
        return success ? ResultDto.ok().setMsg("项目创建成功").setData(exam) : ResultDto.error().setMsg("项目创建失败");
    }

    @Operation(summary = "查询眼科项目")
    @Parameter(name = "id", description = "项目ID", required = true)
    @GetMapping("/get")
    public ResultDto getExam(Integer id) {
        Exam exam = examService.getById(id);
        return exam != null ? ResultDto.ok().setData(exam) : ResultDto.error().setMsg("项目不存在");
    }

    @Operation(summary = "分页查询项目列表")
    @Parameters({
        @Parameter(name = "pageNum", description = "页码", required = true),
        @Parameter(name = "pageSize", description = "每页数量", required = true),
        @Parameter(name = "name", description = "项目名称模糊查询")
    })
    @GetMapping("/list")
    public ResultDto getExamList(
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(required = false) String name) {
        Page<Exam> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Exam> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            queryWrapper.like("name", name);
        }
        Page<Exam> examPage = examService.page(page, queryWrapper);
        return ResultDto.ok().setData(examPage.getRecords());
    }

    @Operation(summary = "更新眼科项目")
    @Parameters({
        @Parameter(name = "id", description = "项目ID", required = true),
        @Parameter(name = "name", description = "项目名称"),
        @Parameter(name = "description", description = "项目描述")
    })
    @PostMapping("/update")
    public ResultDto updateExam(Integer id, String name, String description) {
        Exam exam = examService.getById(id);
        if (exam == null) {
            return ResultDto.error().setMsg("项目不存在");
        }
        exam.setName(name);
        exam.setDescription(description);
        boolean success = examService.updateById(exam);
        return success ? ResultDto.ok().setMsg("更新成功") : ResultDto.error().setMsg("更新失败");
    }

    @Operation(summary = "删除眼科项目")
    @Parameter(name = "id", description = "项目ID", required = true)
    @DeleteMapping("/delete")
    public ResultDto deleteExam(Integer id) {
        boolean success = examService.removeById(id);
        return success ? ResultDto.ok().setMsg("删除成功") : ResultDto.error().setMsg("删除失败");
    }
}