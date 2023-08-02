package com.easy.panda.service.impl;

import com.easy.panda.service.FateTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by panda.
 *
 * @Author : mags
 * @createTime 2023/5/16 11:15
 * @description
 */
@Component("dbFate")
@Slf4j
public class DbFateTaskServiceImpl implements FateTaskService {
    /**
     * 处理数据
     * @param param
     */
    @Override
    public HashMap handel(String param) {
        log.info("处理数据库数据：{}",param);
        return null;
    }
}
