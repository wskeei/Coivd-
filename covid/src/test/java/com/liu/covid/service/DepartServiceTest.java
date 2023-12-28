package com.liu.covid.service;

import com.liu.covid.entity.Department;
import com.liu.covid.mapper.DepartMapper;
import com.liu.covid.service.DepartService;
import com.liu.covid.service.impl.DepartServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DepartServiceTest {

    @InjectMocks
    private DepartServiceImpl departService;

    @Mock
    private DepartMapper departMapper;

    @Test
    public void testGetAll() {
        // 模拟数据
        List<Department> departmentList = new ArrayList<>();
        Department department1 = new Department();
        department1.setName("Department1");

        Department department2 = new Department();
        department2.setName("Department2");

        departmentList.add(department1);
        departmentList.add(department2);

        Mockito.when(departMapper.selectList(null)).thenReturn(departmentList);

        // 执行方法
        List<String> result = departService.getAll();

        // 验证结果
        System.out.println("测试 getAll 方法:");

        // 验证结果不为空
        assert result != null : "结果列表不能为空";

        // 遍历输出结果
        for (String departmentName : result) {
            System.out.println("部门名称：" + departmentName);
        }
    }
}
