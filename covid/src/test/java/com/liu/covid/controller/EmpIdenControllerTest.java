package com.liu.covid.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.covid.entity.EmpIden;
import com.liu.covid.mapper.EmpIdenMapper;
import com.liu.covid.service.ChartService;
import com.liu.covid.vo.LineVO;
import com.liu.covid.vo.PieVo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EmpIdenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChartService chartService;

    @MockBean
    private EmpIdenMapper empIdenMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void findAll() throws Exception {
        // 模拟EmpIdenMapper的行为
        Mockito.when(empIdenMapper.selectPage(Mockito.any(), Mockito.any())).thenReturn(new Page<>());

        // 执行请求
        mockMvc.perform(get("/empiden/findAll/1/10"))
                .andExpect(status().isOk());
    }

    @Test
    void save() throws Exception {
        // 准备数据
        EmpIden empIden = new EmpIden();

        // 模拟EmpIdenMapper的行为
        Mockito.when(empIdenMapper.insert(Mockito.any())).thenReturn(1);

        // 执行请求
        ResultActions result = mockMvc.perform(post("/empiden/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empIden)));

        // 断言
        result.andExpect(status().isOk())
                .andExpect(content().string("success"));
    }

    @Test
    void getLineVO() throws Exception {
        // 准备数据
        LineVO lineVO = new LineVO(); // 用于模拟查询结果

        // 模拟ChartService的行为
        Mockito.when(chartService.lineVOList()).thenReturn(lineVO);

        // 执行请求
        ResultActions result = mockMvc.perform(get("/empiden/LineVO"));

        // 断言
        result.andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(lineVO)));
    }

    @Test
    void getPieVO() throws Exception {
        // 准备数据
        List<PieVo> pieVoList = new ArrayList<>(); // 用于模拟查询结果

        // 模拟ChartService的行为
        Mockito.when(chartService.pieVOMap()).thenReturn(pieVoList);

        // 执行请求
        ResultActions result = mockMvc.perform(get("/empiden/PieVO"));

        // 断言
        result.andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(pieVoList)));
    }

    @Test
    void findById() throws Exception {
        // 模拟EmpIdenMapper的行为
        EmpIden empIden = new EmpIden(); // 用于模拟查询结果
        Mockito.when(empIdenMapper.selectById(Mockito.any())).thenReturn(empIden);

        // 执行请求
        ResultActions result = mockMvc.perform(get("/empiden/findById/1"));

        // 断言
        result.andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        // 准备数据
        EmpIden empIden = new EmpIden();

        // 模拟EmpIdenMapper的行为
        Mockito.when(empIdenMapper.updateById(Mockito.any())).thenReturn(1);

        // 执行请求
        ResultActions result = mockMvc.perform(put("/empiden/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empIden)));

        // 断言
        result.andExpect(status().isOk())
                .andExpect(content().string("success"));
    }

    @Test
    void deleteById() throws Exception {
        // 执行请求
        mockMvc.perform(delete("/empiden/deleteById/1"))
                .andExpect(status().isOk());
    }

    @Test
    void search() throws Exception {
        // 准备数据
        String searchKey = "fieldName";
        String searchText = "searchText";
        EmpIden empIden = new EmpIden(); // 用于模拟查询结果
        List<EmpIden> resultList = new ArrayList<>();
        resultList.add(empIden);

        // 模拟EmpIdenMapper的行为
        Mockito.when(empIdenMapper.selectList(Mockito.any())).thenReturn(resultList);

        // 执行请求
        ResultActions result = mockMvc.perform(get("/empiden/search/{searchkey}/{stext}", searchKey, searchText));

        // 断言
        result.andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(resultList)));
    }
}
