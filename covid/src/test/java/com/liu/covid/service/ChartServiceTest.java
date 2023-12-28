package com.liu.covid.service;

import com.liu.covid.entity.EmpIden;
import com.liu.covid.entity.MaterialManage;
import com.liu.covid.mapper.EmpIdenMapper;
import com.liu.covid.mapper.EmpIsMapper;
import com.liu.covid.mapper.MaterialMapper;
import com.liu.covid.service.impl.ChartServiceImpl;
import com.liu.covid.vo.LineVO;
import com.liu.covid.vo.PieVo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ChartServiceTest {

    @InjectMocks
    private ChartServiceImpl chartService;

    @Mock
    private EmpIdenMapper empIdenMapper;

    @Mock
    private EmpIsMapper empIsMapper;

    @Mock
    private MaterialMapper materialMapper;

    @Test
    public void testLineVOList() {
        // 模拟数据
        Mockito.when(empIdenMapper.selectCount(Mockito.any())).thenReturn(10);

        // 执行方法
        LineVO lineVO = chartService.lineVOList();

        // 验证结果
        System.out.println("测试 LineVOList 方法:");

        // 验证 LineVO 不为空
        assert lineVO != null : "LineVO 对象不能为空";

        // 验证 LineVO 的月份列表不为空
        assert lineVO.getMonth() != null : "LineVO 月份列表不能为空";
        System.out.println("LineVO 月份列表：" + lineVO.getMonth());

        // 验证 LineVO 的状态信息不为空
        assert lineVO.getStatus() != null : "LineVO 状态信息不能为空";
        System.out.println("LineVO 状态信息：" + lineVO.getStatus());
    }

    @Test
    public void testPieVOMap() {
        // 模拟数据
        List<MaterialManage> materialList = new ArrayList<>();
        MaterialManage material = new MaterialManage();
        material.setName("Material1");
        material.setCount(20);
        materialList.add(material);

        Mockito.when(materialMapper.selectList(Mockito.any())).thenReturn(materialList);

        // 执行方法
        List<PieVo> pieVoList = chartService.pieVOMap();

        // 验证结果
        System.out.println("测试 PieVOMap 方法:");

        // 验证 PieVoList 不为空
        assert pieVoList != null : "PieVoList 列表不能为空";

        // 遍历 PieVoList 输出每个 PieVo 的信息
        for (PieVo pieVo : pieVoList) {
            System.out.println("PieVo 名称：" + pieVo.getName() + ", 值：" + pieVo.getValue());
        }
    }
}
