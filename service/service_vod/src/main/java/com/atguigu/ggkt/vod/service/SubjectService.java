package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Odin
 * @Date 2022/9/4 15:27
 * @Description:
 */

public interface SubjectService extends IService<Subject> {

    /**
     * 课程分类列表
     * 懒加载，每次查询一次数据
     * @param id
     * @return
     */
    List<Subject> selectSubjectList(Long id);

    void exportData(HttpServletResponse response);

    void importDictData(MultipartFile file);
}
