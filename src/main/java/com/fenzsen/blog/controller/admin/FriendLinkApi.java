package com.fenzsen.blog.controller.admin;

import com.fenzsen.blog.pojo.FriendLink;
import com.fenzsen.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Description: 管理中心友情链接API、
 * Date: 2020/8/8
 */
@Slf4j
@RestController
@RequestMapping("/admin/friend_link")
public class FriendLinkApi {


    /**
     * Description: 添加友链
     * Date: 2020/8/8
     */
    @PostMapping
    public ResponseResult addFriendLink(@RequestBody FriendLink friendLink){
        return null;
    }

    /**
     * Description: 删除友链
     * Date: 2020/8/8
     */
    @DeleteMapping("{friendLinkId}")
    public ResponseResult deleteFriendLink(@PathVariable String friendLinkId){
        return null;
    }

    /**
     * Description: 更新友链
     * Date: 2020/8/8
     */
    @PutMapping("{friendLinkId}")
    public ResponseResult updateFriendLink(@PathVariable String friendLinkId){
        return null;
    }

    /**
     * Description: 获取友链
     * Date: 2020/8/8
     */
    @GetMapping("{friendLinkId}")
    public ResponseResult getFriendLink(@PathVariable String friendLinkId){
        return null;
    }

    /**
     * Description: 获取友链列表
     * Date: 2020/8/8
     */
    @GetMapping("/list")
    public ResponseResult listFriendLinks(@RequestParam("page")int page,@RequestParam("size")int size){
        return null;
    }

}
