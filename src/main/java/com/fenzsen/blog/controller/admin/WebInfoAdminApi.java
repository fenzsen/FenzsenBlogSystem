package com.fenzsen.blog.controller.admin;

import com.fenzsen.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Description: 管理中心网站信息Api
 * Date: 2020/8/8
 */
@Slf4j
@RestController
@RequestMapping("/admin/website_info")
public class WebInfoAdminApi {

    /**
     * Description: 获取网站标题
     * Date: 2020/8/8
     */
    @GetMapping("/title")
    public ResponseResult getWebsiteTitle(){
        return null;
    }

    /**
     * Description: 修改网站标题
     * Date: 2020/8/8
     */
    @PutMapping("/title")
    public ResponseResult updateWebsiteTitle(@RequestParam("title")String title){
        return null;
    }

    /**
     * Description: 获取SEO信息
     * Date: 2020/8/8
     */
    @GetMapping("/seo")
    public ResponseResult getSEOInfo(){
        return null;
    }

    /**
     * Description: 修改SEO信息
     * Date: 2020/8/8
     */
    @PutMapping("/seo")
    public ResponseResult putSEOInfo(@RequestParam("keywords")String keywords,
                                     @RequestParam("description")String description){
        return null;
    }

    /**
     * Description: 获取统计信息
     * Date: 2020/8/8
     */
    @GetMapping("/view_count")
    public ResponseResult getWebsiteViewCount(){
        return null;
    }

}
