package com.liu.covid.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liu.covid.controller.EmpController;
import com.liu.covid.entity.EmpHealth;
import com.liu.covid.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EmpControllerTest {

    @Mock
    private EmpMapper empMapper;

    @InjectMocks
    private EmpController empController;

    @Test
    public void testFindAll() {
        // 设置模拟数据
        Page<EmpHealth> mockPage = new Page<>();
        Mockito.when(empMapper.selectPage(Mockito.any(), Mockito.any())).thenReturn(mockPage);

        // 调用controller的方法
        Page<EmpHealth> result = empController.findAll(1, 10);

        // 验证结果是否符合预期
        assertNotNull(result);
        assertEquals(mockPage, result);

        // 验证mapper的selectPage方法是否被调用
        Mockito.verify(empMapper, Mockito.times(1)).selectPage(Mockito.any(), Mockito.any());
    }

    @Test
    public void testSave() {
        // 设置模拟数据
        EmpHealth mockEmp = new EmpHealth();
        Mockito.when(empMapper.insert(Mockito.any())).thenReturn(1);

        // 调用controller的方法
        String result = empController.save(mockEmp);

        // 验证结果是否符合预期
        assertEquals("success", result);

        // 验证mapper的insert方法是否被调用
        Mockito.verify(empMapper, Mockito.times(1)).insert(Mockito.any());
    }

    @Test
    public void testFindById() {
        // 设置模拟数据
        EmpHealth mockEmp = new EmpHealth();
        Mockito.when(empMapper.selectById(Mockito.any())).thenReturn(mockEmp);

        // 调用controller的方法
        EmpHealth result = empController.findById(1);

        // 验证结果是否符合预期
        assertEquals(mockEmp, result);

        // 验证mapper的selectById方法是否被调用
        Mockito.verify(empMapper, Mockito.times(1)).selectById(Mockito.any());
    }

    @Test
    public void testUpdate() {
        // 设置模拟数据
        EmpHealth mockEmp = new EmpHealth();
        Mockito.when(empMapper.updateById(Mockito.any())).thenReturn(1);

        // 调用controller的方法
        String result = empController.update(mockEmp);

        // 验证结果是否符合预期
        assertEquals("success", result);

        // 验证mapper的updateById方法是否被调用
        Mockito.verify(empMapper, Mockito.times(1)).updateById(Mockito.any());
    }

    @Test
    public void testDeleteById() {
        // 调用controller的方法
        empController.deleteById(1L);

        // 验证mapper的deleteById方法是否被调用
        Mockito.verify(empMapper, Mockito.times(1)).deleteById(Mockito.anyString());
    }

    @Test
    public void testSearch() {
        // 设置模拟数据
        List<EmpHealth> mockList = Collections.singletonList(new EmpHealth());
        Mockito.when(empMapper.selectList(Mockito.any())).thenReturn(mockList);

        // 调用controller的方法
        List<EmpHealth> result = empController.search("name", "John");

        // 验证结果是否符合预期
        assertNotNull(result);
        assertEquals(mockList, result);

        // 验证mapper的selectList方法是否被调用
        Mockito.verify(empMapper, Mockito.times(1)).selectList(Mockito.any());
    }
}
