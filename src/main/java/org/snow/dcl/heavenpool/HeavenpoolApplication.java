package org.snow.dcl.heavenpool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.snow.dcl.heavenpool.dao")
public class HeavenpoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeavenpoolApplication.class, args);
    }

}
