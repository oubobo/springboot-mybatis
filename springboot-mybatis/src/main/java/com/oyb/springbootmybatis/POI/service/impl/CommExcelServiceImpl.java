package com.oyb.springbootmybatis.POI.service.impl;

import com.oyb.springbootmybatis.POI.service.ICommExcelService;
import com.oyb.springbootmybatis.vo.MybatisInfoVO;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommExcelServiceImpl implements ICommExcelService {

    private static final Logger logger = LoggerFactory.getLogger(CommExcelServiceImpl.class);

    /**
     * 导出excel
     */
    public void export(HttpServletResponse response) {

        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook workbook = new HSSFWorkbook();

        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = workbook.createSheet("导出测试");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);

        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(0);
        //设置单元格内容
        cell.setCellValue("学员考试成绩一览表");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));

        HSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("姓名");
        row2.createCell(1).setCellValue("班级");
        row2.createCell(2).setCellValue("笔试成绩");
        row2.createCell(3).setCellValue("机试成绩");


        //在sheet里创建第三行
        HSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("李明");
        row3.createCell(1).setCellValue("As178");
        row3.createCell(2).setCellValue(87);
        row3.createCell(3).setCellValue(78);

        OutputStream output = null;

        try {
            output = response.getOutputStream();
            response.reset();
            //加下划线这部分代码是B/S模式中采用的输出方式，而不是输出到本地指定的磁盘目录。
            // 该代码表示将details.xls的Excel文件通过应答实体（response）输出给请求的客户端浏览器，客户端可保存或直接打开。
            response.setHeader("Content-disposition", "attachment; filename=details.xls");
            //response.setContentType("application/msexcel");
            response.setContentType("application/vnd.ms-excel");
            workbook.write(output);
            output.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 2.6 导入Excel应用实例
     *
     * @param xlsPath
     * @return
     */
    public List<MybatisInfoVO> importExcel(String xlsPath) {
        List temp = new ArrayList();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(xlsPath);
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

            HSSFSheet sheet = workbook.getSheetAt(0);
            logger.info("sheetName={}",sheet.getSheetName());
            for (int i = 1;i <= sheet.getLastRowNum();i++) {
                logger.info("sheet.lastRownum={}",sheet.getLastRowNum());
                HSSFRow row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                MybatisInfoVO mybatisInfoVO = new MybatisInfoVO();
                mybatisInfoVO.setCupSize(row.getCell(0).getStringCellValue());
                mybatisInfoVO.setAge(String.valueOf(row.getCell(1).getNumericCellValue()));
                temp.add(mybatisInfoVO);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }


}
