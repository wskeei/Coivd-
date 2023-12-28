package com.liu.covid.mapper;

import com.liu.covid.entity.EmpHealth;
import com.liu.covid.entity.Enum.GenderEnum;
import com.liu.covid.mapper.EmpMapper;
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
public class EmpMapperTest {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testCRUDOperations() {
        // Create
        EmpHealth empHealth1 = createEmpHealth("刘先生", GenderEnum.男, 15143355464L, 36.5f, "否", "正常", "", "后勤部");
        empMapper.insert(empHealth1);

        // Read
        EmpHealth retrievedEmpHealth = empMapper.selectById(empHealth1.getId());
        assertNotNull(retrievedEmpHealth);
        assertEquals(empHealth1.getName(), retrievedEmpHealth.getName());

        // Update
        retrievedEmpHealth.setTemp(36.0f);
        empMapper.updateById(retrievedEmpHealth);

        EmpHealth updatedEmpHealth = empMapper.selectById(retrievedEmpHealth.getId());
        assertEquals(36.0f, updatedEmpHealth.getTemp());

        // Delete
        empMapper.deleteById(updatedEmpHealth.getId());
        EmpHealth deletedEmpHealth = empMapper.selectById(updatedEmpHealth.getId());
        assertNull(deletedEmpHealth);
    }



    private EmpHealth createEmpHealth(String name, GenderEnum sex, Long phoneNum, float temp, String risk, String health, String content, String depart) {
        EmpHealth empHealth = new EmpHealth();
        empHealth.setName(name);
        empHealth.setSex(sex);
        empHealth.setPhonenum(phoneNum);
        empHealth.setTemp(temp);
        empHealth.setRisk(risk);
        empHealth.setHealth(health);
        empHealth.setContent(content);
        empHealth.setDepart(depart);
        return empHealth;
    }
}
