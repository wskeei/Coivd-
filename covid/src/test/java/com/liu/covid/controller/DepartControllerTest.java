package com.liu.covid.controller;

import com.liu.covid.controller.DepartController;
import com.liu.covid.service.DepartService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DepartControllerTest {

    @Mock
    private DepartService departService;

    @InjectMocks
    private DepartController departController;

    @Test
    public void testFindAll() {
        // 设置模拟数据
        List<String> mockData = new ArrayList<>();
        mockData.add("Item1");
        mockData.add("Item2");

        // 使用Mockito模拟service的行为
        Mockito.when(departService.getAll()).thenReturn(mockData);

        // 调用controller的方法
        List<String> result = departController.findAll();

        // 打印测试结果
        System.out.println("Test Result: " + result);

        // 验证结果是否符合预期
        assert result != null;
        assert result.size() == 2;
        assert result.get(0).equals("Item1");
        assert result.get(1).equals("Item2");

        // 验证service的getAll方法是否被调用
        Mockito.verify(departService, Mockito.times(1)).getAll();
    }
}
