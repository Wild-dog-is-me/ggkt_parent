package com.atguigu.ggkt.vod.mapper;

import com.atguigu.ggkt.model.vod.CourseDescription;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author odin
* @description 针对表【course_description(课程简介)】的数据库操作Mapper
* @createDate 2022-09-05 19:41:27
* @Entity generator.domain.CourseDescription
*/

@Mapper
@Repository
public interface CourseDescriptionMapper extends BaseMapper<CourseDescription> {

}




