package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.Chapter;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.ggkt.vod.service.ChapterService;
import com.atguigu.ggkt.vod.mapper.ChapterMapper;
import org.springframework.stereotype.Service;

/**
* @author odin
* @description 针对表【chapter(课程)】的数据库操作Service实现
* @createDate 2022-09-05 19:41:27
*/
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter>
    implements ChapterService{

}




