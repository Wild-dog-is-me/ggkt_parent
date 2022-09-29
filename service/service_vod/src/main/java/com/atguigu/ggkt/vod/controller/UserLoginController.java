package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Odin
 * @Date 2022/9/1 23:07
 * @Description:
 */

@CrossOrigin
@RestController
@RequestMapping("/admin/vod/user")
public class UserLoginController {

    @PostMapping("/login")
    public Result login() {
        Map<String, Object> map = new HashMap<>();
        map.put("token", "admin-token");
        return Result.ok(map);
    }

    @GetMapping("/info")
    public Result info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles", "admin");
        map.put("introduction", "I am a super admin");
        map.put("avatar", "https://pic.imgdb.cn/item/626a05e4239250f7c57c61b0.png");
        map.put("name", "super admin");
        return Result.ok(map);
    }
}
