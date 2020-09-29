package com.bjfs.fsjy.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @auther Tom
 * @create 2020/8/7
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private  String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
