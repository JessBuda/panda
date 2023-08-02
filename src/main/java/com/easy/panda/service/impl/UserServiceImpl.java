package com.easy.panda.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.panda.domain.User;
import com.easy.panda.service.UserService;
import com.easy.panda.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author mags
 * @description 针对表【t_user】的数据库操作Service实现
 * @createDate 2023-04-24 14:11:17
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Async("commonThreadPool")
    public void sendMessageText(String msg) {
        log.info(String.format("执行：%s", msg));
    }
}




