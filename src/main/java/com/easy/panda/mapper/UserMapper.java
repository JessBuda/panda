package com.easy.panda.mapper;

import com.easy.panda.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author mags
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2023-04-24 14:11:17
* @Entity com.easy.panda.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




