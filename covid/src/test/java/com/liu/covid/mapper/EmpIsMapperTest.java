package com.liu.covid.mapper;

import com.liu.covid.entity.EmpIs;
import com.liu.covid.entity.Enum.GenderEnum;
import com.liu.covid.mapper.EmpIsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Transactional
public class EmpIsMapperTest {

    @Autowired
    private EmpIsMapper empIsMapper;

    @Test
    public void testCRUDOperations() {
        // Create
        EmpIs empIs1 = createEmpIs(1L, "黎香湖", GenderEnum.女, 12341231231L, 35f, "酒店隔离", "广州市广州南站如家酒店", "2021-04-06", "2021-04-20", "广东汕头", "广东东莞", null, "人力资源部");
        empIsMapper.insert(empIs1);

        // Read
        EmpIs retrievedEmpIs = empIsMapper.selectById(empIs1.getId());
        assertNotNull(retrievedEmpIs);
        assertEquals(empIs1.getName(), retrievedEmpIs.getName());

        // 更新
        retrievedEmpIs.setTemp(36.5f);
        empIsMapper.updateById(retrievedEmpIs);

        EmpIs updatedEmpIs = empIsMapper.selectById(retrievedEmpIs.getId());
        assertEquals(36.5f, updatedEmpIs.getTemp());

        // 删除
        empIsMapper.deleteById(updatedEmpIs.getId());
        EmpIs deletedEmpIs = empIsMapper.selectById(updatedEmpIs.getId());
        assertNull(deletedEmpIs);
    }

    private EmpIs createEmpIs(Long id, String name, GenderEnum sex, Long phone, float temp, String type, String place, String begin, String end, String leaved, String arrived, String content, String depart) {
        EmpIs empIs = new EmpIs();
        empIs.setId(id);
        empIs.setName(name);
        empIs.setSex(sex);
        empIs.setPhone(phone);
        empIs.setTemp(temp);
        empIs.setType(type);
        empIs.setPlace(place);
        empIs.setBegin(java.sql.Date.valueOf(begin));
        empIs.setEnd(java.sql.Date.valueOf(end));
        empIs.setLeaved(leaved);
        empIs.setArrived(arrived);
        empIs.setContent(content);
        empIs.setDepart(depart);
        System.out.println("成功创建");
        return empIs;
    }
}
