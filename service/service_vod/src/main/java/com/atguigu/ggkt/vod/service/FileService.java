package com.atguigu.ggkt.vod.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author Odin
 * @Date 2022/9/4 00:44
 * @Description:
 */

/**
 * 文件上传
 */
public interface FileService {

    String upload(MultipartFile file);
}
