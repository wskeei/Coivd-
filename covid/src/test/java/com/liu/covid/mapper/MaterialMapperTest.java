package com.liu.covid.mapper;

import com.liu.covid.entity.Enum.ImpEnum;
import com.liu.covid.entity.MaterialManage;
import com.liu.covid.mapper.MaterialMapper;
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
public class MaterialMapperTest {

    @Autowired
    private MaterialMapper materialMapper;

    @Test
    public void testCRUDOperations() {
        // Create
        MaterialManage material1 = createMaterial("KN94口罩", 150, "个", true, "孙迪", 13415135777L);
        materialMapper.insert(material1);

        // Read
        MaterialManage retrievedMaterial = materialMapper.selectById(material1.getId());
        assertNotNull(retrievedMaterial);
        assertEquals(material1.getName(), retrievedMaterial.getName());

        // Update
        retrievedMaterial.setCount(200);
        materialMapper.updateById(retrievedMaterial);

        MaterialManage updatedMaterial = materialMapper.selectById(retrievedMaterial.getId());
        assertEquals(200, updatedMaterial.getCount());

        // Delete
        materialMapper.deleteById(updatedMaterial.getId());
        MaterialManage deletedMaterial = materialMapper.selectById(updatedMaterial.getId());
        assertNull(deletedMaterial);
    }


    private MaterialManage createMaterial(String name, int count, String type, boolean isImp, String charge, Long cnum) {
        MaterialManage material = new MaterialManage();
        material.setName(name);
        material.setCount(count);
        material.setType(type);
        material.setIsImp(isImp ? ImpEnum.是 : ImpEnum.否);
        material.setCharge(charge);
        material.setCnum(cnum);
        return material;
    }
}
