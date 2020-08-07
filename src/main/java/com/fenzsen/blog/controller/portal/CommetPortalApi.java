package com.fenzsen.blog.controller.portal;

import com.fenzsen.blog.pojo.Comment;
import com.fenzsen.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Description: 门户评论API
 * Date: 2020/8/8
 */
@Slf4j
@RestController
@RequestMapping("/portal/comment")
public class CommetPortalApi {

    /**
     * Description: 添加评论
     * Date: 2020/8/8
     */
    @PostMapping
    public ResponseResult postComment(@RequestBody Comment comment){
        return null;
    }

    /**
     * Description: 删除评论
     * Date: 2020/8/8
     */
    @DeleteMapping("{commentId}")
    public ResponseResult deleteComment(@PathVariable String commentId){
        return null;
    }

    /**
     * Description: 获取评论列表
     * Date: 2020/8/8
     */
    @GetMapping("/list/{articleId}")
    public ResponseResult listComment(@PathVariable String articleId){
        return null;
    }

}
