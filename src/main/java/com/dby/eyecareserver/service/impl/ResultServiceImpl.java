package com.dby.eyecareserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dby.eyecareserver.entity.Result;
import com.dby.eyecareserver.service.ResultService;
import com.dby.eyecareserver.mapper.ResultMapper;
import org.springframework.stereotype.Service;

/**
* @author dby
* @description 针对表【result】的数据库操作Service实现
* @createDate 2025-03-07 22:29:48
*/
@Service
public class ResultServiceImpl extends ServiceImpl<ResultMapper, Result>
    implements ResultService{

}




