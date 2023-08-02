package com.easy.panda.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by panda.
 *
 * @Author : mags
 * @createTime 2023/5/16 11:20
 * @description
 */
@Service
public class FateTaskFactory {
    @Resource
    private Map<String, FateTaskService> fateTaskServiceMap = new ConcurrentHashMap<>();

    /**
     * 获取处理类
     *
     * @param key
     * @return
     */
    public FateTaskService getFateTaskService(String key) {
        if(!fateTaskServiceMap.containsKey(key)){
            throw new RuntimeException("没有找到对应的处理类");
        }
        return fateTaskServiceMap.get(key);
    }
}
