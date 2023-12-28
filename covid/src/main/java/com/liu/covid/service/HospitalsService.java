package com.liu.covid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.covid.entity.Hospitals;

public interface HospitalsService extends IService<Hospitals> {
    int getAvailableBedsTotal();

    int getMedicalStaffTotal();
}
