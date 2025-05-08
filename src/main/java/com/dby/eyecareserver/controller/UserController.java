package com.dby.eyecareserver.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dby.eyecareserver.dto.ResultDto;
import com.dby.eyecareserver.entity.User;
import com.dby.eyecareserver.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;


@Tag(name = "用户管理")
@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 注册用户
     * @param username
     * @param password
     * @param phone
     */
    @Operation(summary = "注册用户", description = "用户名密码注册")
    @Parameters({
            @Parameter(name = "username", description = "用户名", required = true),
            @Parameter(name = "password", description = "密码", required = true),
            @Parameter(name = "phone", description = "电话", required = true)
    })
    @PostMapping("/user/register")
    public ResultDto register(String username, String password, String phone) {
        //查询用户是否存在
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        if (user != null) {
            //用户已存在
            return ResultDto.error().setMsg("用户已存在");
        }
            //用户不存在，注册用户
            //对密码加盐加密
            //生成随机字符串作为token(盐)
        String token = RandomUtil.randomString(16);
        password = SecureUtil.md5(password + token);

        user = new User();
        user.setUsername(username);
        user.setPhone(phone);
        //将加密后的密码存入数据库
        user.setPassword(password);
        //记录token
        user.setToken(token);
        boolean b = userService.save(user);
        return b ? ResultDto.ok().setMsg("注册成功").setData(user) : ResultDto.error().setMsg("注册失败");


    }
    /**
     * 登录验证
     * @param username
     * @param password
     */
    @Operation(summary = "登录验证")
    @Parameters({
        @Parameter(name = "username", description = "用户名", required = true),
        @Parameter(name = "password", description = "密码", required = true)
    })
    @PostMapping("/user/login")

    public ResultDto login(String username,String password) {
        System.out.println("登录查询用户: " + username);
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        if (user == null) {
            System.out.println("用户不存在: " + username);
            return ResultDto.error().setMsg("用户不存在");
        }
        System.out.println("用户存在: " + username + "尝试登录");
        String encryptedInput = SecureUtil.md5(password + user.getToken());
        if (user.getPassword().equals(encryptedInput)) {
            return ResultDto.ok().setMsg("登录成功").setData(user).setCode(200);
        }
        return ResultDto.error().setMsg("密码错误");
    }

    @Operation(summary = "更新用户信息")
    @Parameters({
        @Parameter(name = "id", description = "用户ID", required = true),
        @Parameter(name = "name", description = "真实姓名"),
        @Parameter(name = "gender", description = "性别"),
        @Parameter(name = "age", description = "年龄"),
        @Parameter(name = "email", description = "邮箱")
    })
    @PostMapping("/user/update")
    public ResultDto updateUserInfo(Integer id, String name, String gender, Integer age, String email) {
        User user = userService.getById(id);
        if (user == null) {
            return ResultDto.error().setMsg("用户不存在");
        }
        user.setName(name);
        user.setGender(gender);
        user.setAge(age);
        user.setEmail(email);
        boolean success = userService.updateById(user);
        return success ? ResultDto.ok().setMsg("更新成功") : ResultDto.error().setMsg("更新失败");
    }

    @Operation(summary = "重置密码")
    @Parameters({
        @Parameter(name = "username", description = "用户名", required = true),
        @Parameter(name = "newPassword", description = "新密码", required = true),
        @Parameter(name = "phone", description = "验证手机号", required = true)
    })
    @PostMapping("/user/reset-password")
    public ResultDto resetPassword(String username, String newPassword, String phone) {
        User user = userService.getOne(new QueryWrapper<User>()
            .eq("username", username)
            .eq("phone", phone));
        
        if (user == null) {
            return ResultDto.error().setMsg("用户信息不匹配");
        }
        
        String newToken = RandomUtil.randomString(16);
        String encryptedPwd = SecureUtil.md5(newPassword + newToken);
        user.setPassword(encryptedPwd);
        user.setToken(newToken);
        
        boolean success = userService.updateById(user);
        return success ? ResultDto.ok().setMsg("密码重置成功") : ResultDto.error().setMsg("密码重置失败");
    }
    
    @Operation(summary = "删除用户")
    @Parameter(name = "id", description = "用户ID", required = true)
    @DeleteMapping("/user/delete")
    public ResultDto deleteUser(Integer id) {
        boolean success = userService.removeById(id);
        return success ? ResultDto.ok().setMsg("删除成功") : ResultDto.error().setMsg("删除失败");
    }
    
    @Operation(summary = "查询用户信息")
    @Parameter(name = "id", description = "用户ID", required = true)
    @GetMapping("/user/get")
    public ResultDto getUser(Integer id) {
        User user = userService.getById(id);
        return user != null ? ResultDto.ok().setData(user) : ResultDto.error().setMsg("用户不存在");
    }
    //未完全实现
    @Operation(summary = "分页查询用户列表")
    @Parameters({
        @Parameter(name = "pageNum", description = "页码", required = true),
        @Parameter(name = "pageSize", description = "每页数量", required = true),
        @Parameter(name = "username", description = "用户名模糊查询")
    })
    @GetMapping("/user/list")
    public ResultDto getUserList(
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam(required = false) String username) {
        Page<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)) {
            queryWrapper.like("username", username);
        }
        Page<User> userPage = userService.page(page, queryWrapper);
        return ResultDto.ok()
                .setMsg("查询成功")
                .setData(userPage.getRecords());
    }
}
