package com.fc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fc.dao")
public class OnlineOrderingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineOrderingSystemApplication.class, args);
    }

}
