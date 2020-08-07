package com.fenzsen.blog.controller.admin;

import com.fenzsen.blog.pojo.Article;
import com.fenzsen.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Description: 管理中心文章API
 * Date: 2020/8/8
 */
@Slf4j
@RestController
@RequestMapping("/admin/article")
public class ArticleApi {

    /**
     * Description: 添加文章
     * Date: 2020/8/8
     */
    @PostMapping
    public ResponseResult postArticle(@RequestBody Article article){
        return null;
    }

    /**
     * Description: 删除文章
     * Date: 2020/8/8
     */
    @DeleteMapping("{articleId}")
    public ResponseResult deleteArticle(@PathVariable String articleId){
        return null;
    }

    /**
     * Description: 更新文章
     * Date: 2020/8/8
     */
    @PutMapping("{articleId}")
    public ResponseResult updateArticle(@PathVariable String articleId){
        return null;
    }

    /**
     * Description: 获取文章详情
     * Date: 2020/8/8
     */
    @GetMapping("{articleId}")
    public ResponseResult getArticle(@PathVariable String articleId){
        return null;
    }

    /**
     * Description: 获取文章列表
     * Date: 2020/8/8
     */
    @GetMapping("/list")
    public ResponseResult listArticles(@RequestParam("page")int page,@RequestParam("size")int size){
        return null;
    }

    /**
     * Description: 修改文章状态
     * Date: 2020/8/8
     */
    @PutMapping("state/{articleId}/{state}")
    public ResponseResult updateArticleState(@PathVariable String state, @PathVariable String articleId){
        return null;
    }

    /**
     * Description: 置顶文章
     * Date: 2020/8/8
     */
    @PutMapping("top/{articleId}")
    public ResponseResult updateArticleState(@PathVariable String articleId){
        return null;
    }



}
