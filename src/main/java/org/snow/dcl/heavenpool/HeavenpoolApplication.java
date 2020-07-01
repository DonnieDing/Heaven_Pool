package org.snow.dcl.heavenpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class HeavenpoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeavenpoolApplication.class, args);
    }

    @RequestMapping("/test")
    public String test(){
        return "Hello World!";
    }

}
