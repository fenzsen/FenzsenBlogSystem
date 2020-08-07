package com.fenzsen.blog.controller;

import com.fenzsen.blog.pojo.TestHouse;
import com.fenzsen.blog.pojo.TeseUser;
import com.fenzsen.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

// Log 库注解
@Slf4j
// @Controller 注解处理 http请求
@RestController    // @RestController 注解处理 http请求,并且整个类的方法都以 body 的形式返回数据。
@RequestMapping("/test")    // @RestController 注解处理,整个类的请求都含有的公共路径
public class TestController {

    // 定义一个全局的 Log
    // public static final Logger log= LoggerFactory.getLogger(TestController.class);

    // @ResponseBody 注解以 body 的形式返回
    // @RequestMapping 指定请求路径、方法、参数
    @RequestMapping( value = "/testString",method = RequestMethod.GET)
    public String testString(){
        log.info("Hello World");
        return "Hello World";
    }

    @GetMapping("/testJson")    // get请求注解，直接传递路径
    // get请求方法参数直接定义和使用
    public TeseUser testJson(String name ,String password){
        log.info("userName:" + name);
        log.info("password：" + password);
        TeseUser teseUser = new TeseUser("大雄",20,"男");
        teseUser.setHouse(new TestHouse("故宫","北京"));
        // 返回对象就是返回json形式的数据，在一个对象中添加另一个对象就形成json的嵌套
        return  teseUser;
    }

    @PostMapping("/postParameter")   // post请求
    // post方法参数可以是实体类的对象，其中请求参数为该对象内的成员变量   请求头为：raw 以json的形式传递
    public ResponseResult postRequest(@RequestBody TeseUser user){
        log.info("userName:" + user.getName());
        log.info("password：" + user.getPassword());
        ResponseResult success = ResponseResult.SUCCESS("post请求成功，参数为：userName:" + user.getName() + "password：" + user.getPassword());
        return success;
    }


}
