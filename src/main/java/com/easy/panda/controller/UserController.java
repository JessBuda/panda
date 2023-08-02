package com.easy.panda.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.easy.panda.domain.User;
import com.easy.panda.service.UserService;
import com.easy.panda.util.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by panda.
 *
 * @Author : mags
 * @createTime 2023/4/24 14:17
 * @description
 */
@RestController
@RequestMapping("/user")
@Tag(name = "用户管理", description = "用户管理模块")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    /**
     * 根据用户id获取用户信息
     * @param userId
     * @return
     */
    @Operation(summary = "用户查询", description  = "根据ID获取用户信息")
    @GetMapping("/{id}")
    public R<User> getUserInfo(@PathVariable("id") Integer userId) {
        return R.ok(userService.getById(userId));
    }

    /**
     * 新增用户
     */
    @Operation(summary = "用户新增", description = "新增用户")
    @GetMapping("/add")
    public R<String> addUser() {
        // 创建用户信息
        User user = new User();
        user.setName("张三");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setCreateTime(new Date());
        userService.save(user);
        return R.ok();
    }

    /**
     * 用户分页查询
     * @param page 分页对象
     * @param name  用户名
     * @return
     */
    @Operation(summary = "用户分页", description = "分页获取用户信息")
    @GetMapping("/page")
    public R<IPage<User>> page(Page<User> page, String name){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        return R.ok(userService.page(page,wrapper.eq("name", name)));
    }
}
