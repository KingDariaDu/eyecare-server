package com.dby.eyecareserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dby.eyecareserver.entity.Appointment;
import com.dby.eyecareserver.service.AppointmentService;
import com.dby.eyecareserver.mapper.AppointmentMapper;
import org.springframework.stereotype.Service;

/**
* @author dby
* @description 针对表【appointment】的数据库操作Service实现
* @createDate 2025-03-07 22:29:48
*/
@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment>
    implements AppointmentService{

}




