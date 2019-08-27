package com.sb.sbcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@MapperScan("com.sb.sbcache.mapper")
@SpringBootApplication
@EnableCaching
public class SbCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbCacheApplication.class, args);
    }

}
