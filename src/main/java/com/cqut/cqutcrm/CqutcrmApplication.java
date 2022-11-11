package com.cqut.cqutcrm;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CqutcrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqutcrmApplication.class, args);
    }
    //分页的启动类：借助于框架中提供的分页功能
    @Bean
    public MybatisPlusInterceptor addMybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor =
                new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(
                new PaginationInnerInterceptor()
        );
        return mybatisPlusInterceptor;
    }
}
