package com.hc.bgmt;


import com.hc.common.swagger.annotation.EnableHcSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHcSwagger2
public class BgmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgmtApplication.class, args);
    }

}
