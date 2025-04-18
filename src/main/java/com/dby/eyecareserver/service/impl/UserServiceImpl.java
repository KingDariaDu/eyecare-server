package com.dby.eyecareserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dby.eyecareserver.entity.User;
import com.dby.eyecareserver.service.UserService;
import com.dby.eyecareserver.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author dby
* @description 针对表【user】的数据库操作Service实现
* @createDate 2025-03-07 22:29:48
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




