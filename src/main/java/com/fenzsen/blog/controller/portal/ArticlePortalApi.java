package com.fenzsen.blog.controller.portal;

import com.fenzsen.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 门户文章API
 * Date: 2020/8/8
 */
@Slf4j
@RestController
@RequestMapping("/portal/article")
public class ArticlePortalApi {

    /**
    * Description: 获取文章列表
    * Date: 2020/8/8
    */
    @GetMapping("list/{page}/{size}")
    public ResponseResult listArticle(@PathVariable int page, @PathVariable int size){
        return null;
    }

    /**
     * Description: 根据分类获取内容
     * Date: 2020/8/8
     */
    @GetMapping("list/{categoryId}/{page}/{size}")
    public ResponseResult listArticle(@PathVariable int page, @PathVariable int size, @PathVariable String categoryId){
        return null;
    }

    /**
     * Description: 获取文章详情
     * Date: 2020/8/8
     */
    @GetMapping("/{articleId}")
    public ResponseResult getArticleDetail(@PathVariable String articleId){
        return null;
    }

    /**
     * Description: 获取推荐文章
     * Date: 2020/8/8
     */
    @GetMapping("recommend/{articleId}")
    public ResponseResult getRecommendArticle(@PathVariable String articleId){
        return null;
    }

}
