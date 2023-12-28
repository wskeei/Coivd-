package com.liu.covid.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.covid.entity.EmpIs;
import com.liu.covid.mapper.EmpIsMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EmpIsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpIsMapper empIsMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void findAll() throws Exception {
        // 模拟EmpIsMapper的行为
        Mockito.when(empIsMapper.selectPage(Mockito.any(), Mockito.any())).thenReturn(new Page<>());

        // 执行请求
        mockMvc.perform(get("/empis/findAll/1/10"))
                .andExpect(status().isOk());
    }

    @Test
    void save() throws Exception {
        // 准备数据
        EmpIs empIs = new EmpIs();
        empIs.setBegin(new Date());

        // 模拟EmpIsMapper的行为
        Mockito.when(empIsMapper.insert(Mockito.any())).thenReturn(1);

        // 执行请求
        ResultActions result = mockMvc.perform(post("/empis/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empIs)));

        // 断言
        result.andExpect(status().isOk())
                .andExpect(content().string("success"));
    }

    @Test
    void findById() throws Exception {
        // 模拟EmpIsMapper的行为
        EmpIs empIs = new EmpIs(); // 用于模拟查询结果
        Mockito.when(empIsMapper.selectById(Mockito.any())).thenReturn(empIs);

        // 执行请求
        ResultActions result = mockMvc.perform(get("/empis/findById/1"));

        // 断言
        result.andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        // 准备数据
        EmpIs empIs = new EmpIs();
        empIs.setBegin(new Date());

        // 模拟EmpIsMapper的行为
        Mockito.when(empIsMapper.updateById(Mockito.any())).thenReturn(1);

        // 执行请求
        ResultActions result = mockMvc.perform(put("/empis/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empIs)));

        // 断言
        result.andExpect(status().isOk())
                .andExpect(content().string("success"));
    }

    @Test
    void deleteById() throws Exception {
        // 执行请求
        mockMvc.perform(delete("/empis/deleteById/1"))
                .andExpect(status().isOk());
    }

    @Test
    void search() throws Exception {
        // 准备数据
        String searchKey = "fieldName";
        String searchText = "searchText";
        EmpIs empIs = new EmpIs(); // 用于模拟查询结果
        List<EmpIs> resultList = new ArrayList<>();
        resultList.add(empIs);

        // 模拟EmpIsMapper的行为
        Mockito.when(empIsMapper.selectList(Mockito.any())).thenReturn(resultList);

        // 执行请求
        ResultActions result = mockMvc.perform(get("/empis/search/{searchkey}/{stext}", searchKey, searchText));

        // 断言
        result.andExpect(status().isOk());
        // 您可以根据应用程序的行为添加更多的断言
    }
}
