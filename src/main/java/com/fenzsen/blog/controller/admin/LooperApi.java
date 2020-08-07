package com.fenzsen.blog.controller.admin;

import com.fenzsen.blog.pojo.Looper;
import com.fenzsen.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Description: 管理中心轮播图API、
 * Date: 2020/8/8
 */
@Slf4j
@RestController
@RequestMapping("/admin/loop")
public class LooperApi {

    /**
     * Description: 添加轮播图
     * Date: 2020/8/8
     */
    @PostMapping
    public ResponseResult addLoop(@RequestBody Looper looper){
        return null;
    }

    /**
     * Description: 删除轮播图
     * Date: 2020/8/8
     */
    @DeleteMapping("{loopId}")
    public ResponseResult deleteLoop(@PathVariable String loopId){
        return null;
    }

    /**
     * Description: 更新轮播图
     * Date: 2020/8/8
     */
    @PutMapping("{loopId}")
    public ResponseResult updateLoop(@PathVariable String loopId){
        return null;
    }

    /**
     * Description: 获取单项轮播图
     * Date: 2020/8/8
     */
    @GetMapping("{loopId}")
    public ResponseResult getLoop(@PathVariable String loopId){
        return null;
    }

    /**
     * Description: 获取轮播图列表
     * Date: 2020/8/8
     */
    @GetMapping("/list")
    public ResponseResult listLoops(@RequestParam("page")int page,@RequestParam("size")int size){
        return null;
    }
}
