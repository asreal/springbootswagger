package com.boottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by asreal on 2016-03-31.
 */
//@EnableAutoConfiguration
@SpringBootApplication
//@EnableSwagger2
//@ComponentScan
public class AppStart {
    public static void main(String [] args){
        SpringApplication.run(AppStart.class, args);
    }
}
