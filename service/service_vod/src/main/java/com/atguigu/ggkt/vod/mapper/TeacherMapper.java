package com.atguigu.ggkt.vod.mapper;

import com.atguigu.ggkt.model.vod.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author Odin
 * @Date 2022/8/28 17:39
 * @Description:
 */

@Mapper
@Repository
public interface TeacherMapper extends BaseMapper<Teacher> {

}
