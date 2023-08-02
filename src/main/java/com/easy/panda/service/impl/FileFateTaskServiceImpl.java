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
@Component("fileFate")
@Slf4j
public class FileFateTaskServiceImpl implements FateTaskService {
    /**
     * 处理数据
     * @param param
     */
    @Override
    public HashMap handel(String param) {
        log.info("处理文件数据：{}",param);
        return null;
    }
}
