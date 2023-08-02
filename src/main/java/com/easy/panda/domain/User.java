package com.easy.panda.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户信息
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
@Schema(name = "用户")
public class User implements Serializable {
    /**
     * 主键id
     */
    @TableId
    @Schema(name = "主键id")
    private Integer id;

    /**
     * 姓名
     */
    @Schema(name = "姓名")
    private String name;

    /**
     * 性别
     */
    @Schema(name = "性别")
    private String sex;

    /**
     * 生日
     */
    @Schema(name = "生日")
    private Date birthday;

    /**
     * 创建时间
     */
    @Schema(name = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}