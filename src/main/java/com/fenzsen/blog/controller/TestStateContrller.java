package com.fenzsen.blog.controller;

import com.fenzsen.blog.pojo.TeseUser;
import com.fenzsen.blog.pojo.TestHouse;
import com.fenzsen.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestStateContrller {

    // 定义一个全局的 Log
//    public static final Logger log = (Logger) LoggerFactory.getLogger(TestStateContrller.class);

    @GetMapping(value = "/testResult")
    public ResponseResult testResult(){
        TeseUser teseUser = new TeseUser("大雄",20,"男");
        teseUser.setHouse(new TestHouse("故宫","北京"));
        ResponseResult result = ResponseResult.SUCCESS("操作成功").setData(teseUser);
        return  result;
    }

    @GetMapping("/testResultErr")
    public ResponseResult testResultErr(){
        ResponseResult result = ResponseResult.FAILED("操作失败");
        return  result;
    }

}
