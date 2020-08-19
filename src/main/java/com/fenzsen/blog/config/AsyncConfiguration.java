package com.fenzsen.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Description: 线程池配置
 * Date: 2020/8/20
 */
@Configuration
@EnableAsync
public class AsyncConfiguration {

    public Executor asyncExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);    // 不超时情况下，保持活跃的最少线程数
        executor.setMaxPoolSize(10);    // 可创建的最大线程数
        executor.setThreadNamePrefix("fenzsen_blog_task_worker_");  // 线程名
        executor.setQueueCapacity(30);  // 队列容量
        executor.initialize();  // 初始化
        return executor;
    }


}
