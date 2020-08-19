package com.fenzsen.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Description: Swagger-UI配置
 * Date: 2020/8/8
 */
@Configuration
public class Swagger2ConfigurtationConfig {

    public static final String VERSION = "1.0.0";

    /**
     * Description: 管理中心api，接口前缀：portal
     * Date: 2020/8/8
     */
    @Bean
    public Docket portalApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(portalApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fenzsen.blog.controller.portal"))
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build()
                .groupName("前端门户");
    }

    private ApiInfo portalApiInfo() {
        return new ApiInfoBuilder()
                .title("Fenzsen博客系统门户接口文档") //设置文档的标题
                .description("门户接口文档") // 设置文档的描述
                .version(VERSION) // 设置文档的版本信息-> 1.0.0 Version information
                .build();
    }


    /**
     * Description: 管理中心api，接口前缀：admin
     * Date: 2020/8/8
     */
    @Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(adminApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fenzsen.blog.controller.admin"))
                .paths(PathSelectors.any())
                .build()
                .groupName("管理中心");
    }


    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("管理中心接口文档")
                .description("管理相关中心接口")
                .version(VERSION)
                .build();
    }

    /**
    * Description: 管理中心api，接口前缀：user
    * Date: 2020/8/8
    */
    @Bean
    public Docket UserApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(userApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fenzsen.blog.controller.user"))
                .paths(PathSelectors.any())
                .build()
                .groupName("用户中心");
    }

    private ApiInfo userApiInfo() {
        return new ApiInfoBuilder()
                .title("博客系统用户接口")
                .description("用户相关接口")
                .version(VERSION)
                .build();
    }


}
