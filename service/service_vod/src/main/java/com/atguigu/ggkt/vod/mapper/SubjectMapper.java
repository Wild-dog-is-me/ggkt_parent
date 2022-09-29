package com.atguigu.ggkt.vod.mapper;

import com.atguigu.ggkt.model.vod.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author Odin
 * @Date 2022/9/4 15:28
 * @Description:
 */
@Mapper
@Repository
public interface SubjectMapper extends BaseMapper<Subject> {
}
