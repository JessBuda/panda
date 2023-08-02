package com.easy.panda.domain.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Created by panda.
 *
 * @Author : mags
 * @createTime 2023/5/9 11:29
 * @description
 */
@Data
@EqualsAndHashCode
public class DemoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ExcelProperty("id")
    private Long id;
    @ExcelProperty("size")
    private String size;
    @ExcelProperty("color")
    private String color;
    @ExcelProperty("animal")
    private String animal;

}
