package com.oyb.springbootmybatis.controller;

import com.oyb.springbootmybatis.POI.service.ICommExcelService;
import com.oyb.springbootmybatis.vo.MybatisInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ExCelController {

    @Autowired
    private ICommExcelService commExcelService;

    /**
     * 导出excel
     */
    @GetMapping(value = "excel/export")
    public void export(HttpServletResponse response){
        //先找到接口类打开,然后双击接口名选中,再按住ctrl+T就可以了,ctrl+alt+o去除无用的
        commExcelService.export(response);

    }

    @GetMapping(value = "excel/import")
    public List<MybatisInfoVO> importExcel(){
        String xlsExcel = "E:/excel/details.xls";
      return   commExcelService.importExcel(xlsExcel);
    }
}
