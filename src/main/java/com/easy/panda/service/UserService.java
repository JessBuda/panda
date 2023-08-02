package com.easy.panda.service;

import com.easy.panda.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.scheduling.annotation.Async;

/**
* @author mags
* @description 针对表【t_user】的数据库操作Service
* @createDate 2023-04-24 14:11:17
*/
public interface UserService extends IService<User> {

    void sendMessageText(String msg);

}
