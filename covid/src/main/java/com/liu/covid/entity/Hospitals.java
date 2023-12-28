package com.liu.covid.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Hospitals {

    @TableId
    private Integer hospitalId;

    private String hospitalName;

    private String location;

    private Integer availableBeds;

    private Integer medicalStaff;

    private Integer ventilators;

    private Integer isolationUnits;
}
