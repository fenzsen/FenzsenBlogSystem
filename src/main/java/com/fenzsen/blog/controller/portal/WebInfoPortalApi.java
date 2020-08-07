package com.fenzsen.blog.controller.portal;

import com.fenzsen.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Description: 门户网站信息API
 * Date: 2020/8/8
 */
@Slf4j
@RestController
@RequestMapping("/portal/website_info")
public class WebInfoPortalApi {

    /**
    * Description: 获取分类列表
    * Date: 2020/8/8
    */
    @GetMapping("/categories")
    public ResponseResult getCategories(){
        return null;
    }

    /**
     * Description: 获取网站标题
     * Date: 2020/8/8
     */
    @GetMapping("/title")
    public ResponseResult getWebsiteTitle(){
        return null;
    }

    /**
     * Description: 获取访问量数据
     * Date: 2020/8/8
     */
    @GetMapping("/view_count")
    public ResponseResult getWebsiteViewCount(){
        return null;
    }

    /**
     * Description: 获取网站SEO信息
     * Date: 2020/8/8
     */
    @GetMapping("/seo")
    public ResponseResult getWebsiteSEOInfo(){
        return null;
    }

    /**
     * Description: 获取轮播图列表
     * Date: 2020/8/8
     */
    @GetMapping("/loop")
    public ResponseResult getLoops(){
        return null;
    }

    /**
     * Description: 获取友链列表
     * Date: 2020/8/8
     */
    @GetMapping("/friend_link")
    public ResponseResult getFriendLinks(){
        return null;
    }



}
