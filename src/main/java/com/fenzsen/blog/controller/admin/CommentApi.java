package com.fenzsen.blog.controller.admin;

import com.fenzsen.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Description: 管理中心评论API、
 * Date: 2020/8/8
 */
@Slf4j
@RestController
@RequestMapping("/admin/comment")
public class CommentApi {

    /**
     * Description: 删除评论
     * Date: 2020/8/8
     */
    @DeleteMapping("{commentId}")
    public ResponseResult deleteComment(@PathVariable String commentId){
        return null;
    }


    /**
     * Description: 获取评论详情
     * Date: 2020/8/8
     */
    @GetMapping("{commentId}")
    public ResponseResult getComment(@PathVariable String commentId){
        return null;
    }

    /**
     * Description: 获取评论列表
     * Date: 2020/8/8
     */
    @GetMapping("/list")
    public ResponseResult listComments(@RequestParam("page")int page,@RequestParam("size")int size){
        return null;
    }

    /**
     * Description: 置顶评论
     * Date: 2020/8/8
     */
    @PutMapping("top/{commentId}")
    public ResponseResult updateArticleState(@PathVariable String commentId){
        return null;
    }

}
