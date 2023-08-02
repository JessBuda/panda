package com.easy.panda.controller;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.excel.EasyExcel;
import com.easy.panda.domain.dto.DemoDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Random;

/**
 * Created by panda.
 *
 * @Author : mags
 * @createTime 2023/5/9 11:26
 * @description
 */
@RestController
@RequestMapping("/excel")
@Tag(name = "excel导入导出", description = "excel导入导出")
@AllArgsConstructor
public class ExcelController {
    /**
     * 文件下载
     * @param response
     * @throws IOException
     */
    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName= URLEncoder.encode("猫狗样本","UTF-8").replaceAll("\\+","%20");
        response.setHeader("Content-disposition","attachment;filename*=utf-8''"+fileName+".csv");
        EasyExcel.write(response.getOutputStream(), DemoDTO.class).sheet("模板").doWrite(data());
    }
    // 模拟数据
    private List<DemoDTO> data() {
        List<DemoDTO> list = CollUtil.newArrayList();
        String[] size = {"大", "中", "小"};
        String[] color = {"红", "黄", "蓝"};
        String[] animal = {"猫", "狗"};
        for (long i = 0; i < 1000; i++) {
            DemoDTO data = new DemoDTO();
            data.setId(i);
            data.setSize(getRandom(size));
            data.setColor(getRandom(color));
            data.setAnimal(getRandom(animal));
            list.add(data);
        }
        return list;
    }

    /**
     * 随机获取数组中的一个元素
     * @param array
     * @return
     */
    public String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

}
