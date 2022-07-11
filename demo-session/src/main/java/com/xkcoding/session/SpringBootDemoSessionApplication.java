package com.xkcoding.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动类
 * 此 demo 主要演示了 Spring Boot 如何通过 Spring Session 实现Session共享、重启程序Session不失效。
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-12-19 19:35
 */
@SpringBootApplication
public class SpringBootDemoSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoSessionApplication.class, args);
    }

}

