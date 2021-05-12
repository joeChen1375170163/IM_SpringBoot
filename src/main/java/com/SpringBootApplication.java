package com;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

/**
 * TODO
 * 启动类
 * @author cxh
 * @date 2021/4/30 11:43
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
@MapperScan("com.**.entity")
public class SpringBootApplication {
    public static void main (String[] args) {
        SpringApplication.run(SpringBootApplication.class,args);
    }
}
