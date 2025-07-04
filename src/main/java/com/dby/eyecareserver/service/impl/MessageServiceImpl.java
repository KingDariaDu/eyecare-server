package com.dby.eyecareserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dby.eyecareserver.entity.Message;
import com.dby.eyecareserver.service.MessageService;
import com.dby.eyecareserver.mapper.MessageMapper;
import org.springframework.stereotype.Service;

/**
* @author dby
* @description 针对表【message】的数据库操作Service实现
* @createDate 2025-03-07 22:29:48
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{

}




