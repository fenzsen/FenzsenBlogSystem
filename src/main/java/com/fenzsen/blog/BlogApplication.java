package com.fenzsen.blog;

import com.fenzsen.blog.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Date: 2020/8/8
 * Description: 项目启动入口
 */
@SpringBootApplication
@EnableSwagger2
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class,args);
    }

    @Bean
    public IdWorker createIdWorker(){
        return new IdWorker(0,0);
    }

}
