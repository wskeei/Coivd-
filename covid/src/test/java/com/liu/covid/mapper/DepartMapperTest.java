package com.liu.covid.mapper;

import com.liu.covid.entity.Department;
import com.liu.covid.mapper.DepartMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartMapperTest {

    @Autowired
    private DepartMapper departMapper;

    @Test
    public void testInsert() {
        Department department = new Department();
        department.setId(1001);
        department.setName("干活部");
        department.setCharge("刘小");

        int result = departMapper.insert(department);
        if(result >0 ) {
            System.out.println("成功插入数据");
        }
    }

    @Test
    public void testSelect() {
        Department department = departMapper.selectById(1001);
        System.out.println("Select Result: " + department);

    }

    @Test
    public void testUpdate() {
        Department department = departMapper.selectById(1001);
        department.setCharge("新的主管");

        int result = departMapper.updateById(department);

        if(result >0) {
            System.out.println("成功更新数据");
        }

    }

    @Test
    public void testDelete() {
        int result = departMapper.deleteById(1001);
        if(result >0) {
            System.out.println("成功删除数据");
        }else{
            System.out.println("存在外键，无法删除");
        }
    }
}
