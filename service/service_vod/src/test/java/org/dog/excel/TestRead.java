package org.dog.excel;

import com.alibaba.excel.EasyExcel;

/**
 * @Author Odin
 * @Date 2022/9/5 14:49
 * @Description:
 */
public class TestRead {
    public static void main(String[] args) {
        String fileName = "/Users/odin/Desktop/User.xls";
        EasyExcel.read(fileName,User.class,new ExcelListener()).sheet().doRead();
    }
}
