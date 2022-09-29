package org.dog.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Odin
 * @Date 2022/9/5 14:29
 * @Description:
 */
public class TestWrite {
    public static void main(String[] args) {
        String fileName = "/Users/odin/Desktop/User.xlsx";
        EasyExcel.write(fileName, User.class)
                .sheet("写操作")
                .doWrite(data());

    }

    //循环设置要添加的数据，最终封装到list集合中
    private static List<User> data() {
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User data = new User();
            data.setId(i);
            data.setName("张三"+i);
            list.add(data);
        }
        return list;
    }
}
