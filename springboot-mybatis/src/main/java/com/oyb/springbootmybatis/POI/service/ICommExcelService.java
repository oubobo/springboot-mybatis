package com.oyb.springbootmybatis.POI.service;

import com.oyb.springbootmybatis.vo.MybatisInfoVO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ICommExcelService {

    /**
     * 导出excel
     */
    public void export(HttpServletResponse response);

    public List<MybatisInfoVO> importExcel(String xlsPath);
}
