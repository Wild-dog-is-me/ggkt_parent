package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Odin
 * @Date 2022/8/28 22:03
 * @Description:
 */
@Api(tags = "讲师管理接口")
@RestController
@RequestMapping(value = "/admin/vod/teacher")
@CrossOrigin
public class TeacherController {

    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Resource
    private TeacherService teacherService;

    /**
     * 查询所有讲师
     */
    @ApiOperation("所有讲师列表")
    @GetMapping("/findAll")
    public Result findAllTeacher() {
        List<Teacher> list = teacherService.list();

        logger.info("com.atguigu.ggkt.vod.controller-->TeacherController-->findAllTeacher::", "查询所有讲师");

        return Result.ok(list).message("查询数据成功");
    }

    /**
     * 逻辑删除讲师
     */
    @ApiOperation("逻辑删除讲师")
    @DeleteMapping("/remove/{id}")
    public Result removeTeacher(@ApiParam(name = "id", value = "ID", required = true) @PathVariable Long id) {
        boolean isSuccess = teacherService.removeById(id);

        logger.info("com.atguigu.ggkt.vod.controller-->TeacherController-->removeTeacher::逻辑删除讲师（boolean）::id = [{}]", id);

        if (isSuccess) return Result.ok(null);
        else return Result.fail(null);
    }

    /**
     * 条件查询分页列表
     */
    @ApiOperation(value = "获取分页列表")
    @PostMapping("{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherVo", value = "查询对象", required = false)
            @RequestBody(required = false) TeacherQueryVo teacherQueryVo) {
        //创建page对象，传递当前页和每页记录数
        Page<Teacher> pageParam = new Page<>(page, limit);
        //获取条件值
        String name = teacherQueryVo.getName();//讲师名称
        Integer level = teacherQueryVo.getLevel();//讲师级别
        String joinDateBegin = teacherQueryVo.getJoinDateBegin();//开始时间
        String joinDateEnd = teacherQueryVo.getJoinDateEnd();//结束时间
        //封装条件
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(name)) wrapper.like("name", name);

        if (!StringUtils.isEmpty(level)) wrapper.eq("level", level);

        if (!StringUtils.isEmpty(joinDateBegin)) wrapper.ge("join_date", joinDateBegin);

        if (!StringUtils.isEmpty(joinDateEnd)) wrapper.le("join_date", joinDateEnd);

        //调用方法得到分页查询结果
        IPage<Teacher> pageModel = teacherService.page(pageParam, wrapper);

        logger.info("com.atguigu.ggkt.vod.controller-->TeacherController-->index::page = [{}], limit = [{}], teacherQueryVo = [{}]",page, limit, teacherQueryVo);

        return Result.ok(pageModel);
    }

    @ApiOperation("添加讲师")
    @PostMapping("/saveTeacher")
    public Result save(@RequestBody Teacher teacher) {
        boolean isSuccess = teacherService.save(teacher);

        logger.info("com.atguigu.ggkt.vod.controller-->TeacherController-->save::teacher = [{}]",teacher);

        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    @ApiOperation("根据id查询")
    @GetMapping("/getTeacher/{id}")
    public Result getTeacher(@PathVariable Long id) {
        Teacher teacher = teacherService.getById(id);

        logger.info("com.atguigu.ggkt.vod.controller-->TeacherController-->getTeacher::id = [{}]",id);

        return Result.ok(teacher);
    }


    @ApiOperation(value = "修改")
    @PostMapping("/updateTeacher")
    public Result updateTeacher(@RequestBody Teacher teacher) {
        boolean isSuccess = teacherService.updateById(teacher);

        logger.info("com.atguigu.ggkt.vod.controller-->TeacherController-->updateTeacher::teacher = [{}]",teacher);

        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "批量删除讲师")
    @DeleteMapping("/removeBatch")
    public Result batchRemove(@RequestBody List<Long> idList) {
        boolean isSuccess = teacherService.removeByIds(idList);

        logger.info("com.atguigu.ggkt.vod.controller-->TeacherController-->batchRemove::idList = [{}]",idList);

        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }
}
