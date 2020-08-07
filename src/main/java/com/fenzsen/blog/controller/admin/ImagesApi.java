package com.fenzsen.blog.controller.admin;

import com.fenzsen.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Description: 管理中心图片API
 * Date: 2020/8/8
 */
@Slf4j
@RestController
@RequestMapping("/admin/image")
public class ImagesApi {

    /**
     * Description: 添加图片
     * Date: 2020/8/8
     */
    @PostMapping
    public ResponseResult uploadImage(){
        return null;
    }

    /**
     * Description: 删除图片
     * Date: 2020/8/8
     */
    @DeleteMapping("{imageId}")
    public ResponseResult deleteImage(@PathVariable String imageId){
        return null;
    }

    /**
     * Description: 更新图片
     * Date: 2020/8/8
     */
    @PutMapping("{imageId}")
    public ResponseResult updateImage(@PathVariable String imageId){
        return null;
    }

    /**
     * Description: 获取单项图片
     * Date: 2020/8/8
     */
    @GetMapping("{imageId}")
    public ResponseResult getImage(@PathVariable String imageId){
        return null;
    }

    /**
     * Description: 获取图片列表
     * Date: 2020/8/8
     */
    @GetMapping("/list")
    public ResponseResult listImages(@RequestParam("page")int page,@RequestParam("size")int size){
        return null;
    }

}
