package com.liu.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.covid.entity.Hospitals;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HospitalsMapper extends BaseMapper<Hospitals> {

    @Select("SELECT SUM(available_beds) FROM covid_hospitals")
    int getAvailableBedsTotal();

    @Select("SELECT SUM(medical_staff) FROM covid_hospitals")
    int getMedicalStaffTotal();
}
