package com.liu.covid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.covid.entity.Hospitals;
import com.liu.covid.mapper.HospitalsMapper;
import com.liu.covid.service.HospitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalsServiceImpl extends ServiceImpl<HospitalsMapper, Hospitals> implements HospitalsService {

    @Autowired
    private HospitalsMapper hospitalsMapper;

    @Override
    public int getAvailableBedsTotal() {
        // 直接在方法上使用@Select注解，写入SQL语句
        return hospitalsMapper.getAvailableBedsTotal();
    }

    @Override
    public int getMedicalStaffTotal() {
        // 直接在方法上使用@Select注解，写入SQL语句
        return hospitalsMapper.getMedicalStaffTotal();
    }
}
