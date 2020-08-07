package com.fenzsen.blog.controller.admin;

import com.fenzsen.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Description: 管理中心分类API
 * Date: 2020/8/8
 */
@Slf4j
@RestController
@RequestMapping("/admin/category")
public class CategoryAdminApi {

    /**
    * Description: 添加分类
    * Date: 2020/8/8
    */
    @PostMapping
    public ResponseResult postCategory(){
        return null;
    }

    /**
     * Description: 删除分类
     * Date: 2020/8/8
     */
    @DeleteMapping("{categoryId}")
    public ResponseResult deleteCategory(@PathVariable String categoryId){
        return null;
    }

    /**
     * Description: 更新分类
     * Date: 2020/8/8
     */
    @PutMapping("{categoryId}")
    public ResponseResult updateCategory(@PathVariable String categoryId){
        return null;
    }

    /**
     * Description: 获取单项分类
     * Date: 2020/8/8
     */
    @GetMapping("{categoryId}")
    public ResponseResult getCategory(@PathVariable String categoryId){
        return null;
    }

    /**
     * Description: 获取分类列表
     * Date: 2020/8/8
     */
    @GetMapping("/list")
    public ResponseResult listCategory(@RequestParam("page")int page,@RequestParam("size")int size){
        return null;
    }

}
