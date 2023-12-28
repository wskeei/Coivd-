package com.liu.covid.controller;

import com.liu.covid.service.HospitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospitals")
public class HospitalsController {

    @Autowired
    private HospitalsService hospitalsService;

    @GetMapping("/availableBedsTotal")
    public int getAvailableBedsTotal() {
        // 调用 HospitalsService 中的业务方法
        return hospitalsService.getAvailableBedsTotal();
    }

    @GetMapping("/medicalStaffTotal")
    public int getMedicalStaffTotal() {
        // 调用 HospitalsService 中的业务方法
        return hospitalsService.getMedicalStaffTotal();
    }
}
