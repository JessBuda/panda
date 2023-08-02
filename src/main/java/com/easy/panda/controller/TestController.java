package com.easy.panda.controller;

import com.easy.panda.annotation.Idempotent;
import com.easy.panda.service.FateTaskFactory;
import com.easy.panda.service.FateTaskService;
import com.easy.panda.service.UserService;
import com.easy.panda.util.R;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by panda.
 *
 * @Author : mags
 * @createTime 2023/5/16 10:13
 * @description
 */
@RestController
@RequestMapping("/test")
@Tag(name = "测试相关", description = "测试模块")
@AllArgsConstructor
public class TestController {
    private UserService userService;
    private FateTaskFactory fateTaskFactory;

    /**
     * 测试线程池
     * @return
     */
    @GetMapping("/testThread")
    public R<String> testThread(){
        userService.sendMessageText("测试线程池");
        return R.ok();
    }

    /**
     * 测试异常
     * @return
     */
    @GetMapping("/testError")
    public R testError(){
        int i = 0;
        int j = 2/i;
        return R.ok();
    }

    /**
     * 测试空指针异常
     * @return
     */
    @GetMapping("/testNullError")
    public R testNullError(){
        String nullStr = null;
        nullStr.toString();
        return R.ok();
    }

    /**
     * 测试工厂模式
     * @param param
     * @return
     */
    @GetMapping("/testFactory/{param}")
    public R testFactory(@PathVariable("param") String param){
        FateTaskService fateTaskService = fateTaskFactory.getFateTaskService(param);
        fateTaskService.handel(param);
        return R.ok();
    }

    /**
     * 测试幂等
     * @param keyParam
     * @return
     */
    @Idempotent(key = "#keyParam")
    @GetMapping("/testIdempotent/{keyParam}")
    public R testIdempotent(@PathVariable("keyParam") String keyParam){
        return R.ok(keyParam);
    }
}
