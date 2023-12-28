package com.liu.covid.mapper;

import com.liu.covid.entity.EmpIden;
import com.liu.covid.entity.Enum.GenderEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

@SpringBootTest
public class EmpIdenMapperTest {

    @Autowired
    private EmpIdenMapper empIdenMapper;



    @Test
    public void testSelect() {
        EmpIden empIden = empIdenMapper.selectById(12L);
        System.out.println("Select Result: " + empIden);
    }




}
