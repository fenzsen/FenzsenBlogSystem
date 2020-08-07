package com.fenzsen.blog.controller.portal;

import com.fenzsen.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 门户文章搜索API
 * Date: 2020/8/8
 */
@Slf4j
@RestController
@RequestMapping("/portal/search")
public class SearchPortalApi {

    /**
     * Description: 文章搜索
     * Date: 2020/8/8
     */
    @GetMapping
    public ResponseResult doSerch(@RequestParam("keyword")String keyword){
        return null;
    }

}
