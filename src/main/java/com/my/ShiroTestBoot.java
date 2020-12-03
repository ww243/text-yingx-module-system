package com.my;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author:ljn
 * @Description:
 * @Date:2020/12/02 21:28
 */
@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan("com.my.dao")
@MapperScan("com.my.dao")
public class ShiroTestBoot {
    public static void main(String[] args) {
        SpringApplication.run(ShiroTestBoot.class,args);
    }
}
