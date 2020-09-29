package com.bjfs.fsjy.springcloud.controller;

import com.bjfs.fsjy.springcloud.entities.CommonResult;
import com.bjfs.fsjy.springcloud.entities.Payment;
import com.bjfs.fsjy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @auther Tom
 * @create 2020/7/24
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结工：{}", result);

        if(result > 0) {
            return new CommonResult(200, "插入数据库成功" + serverPort, result);
        }else {
            return new CommonResult(400, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结工：{}", payment);

        if(payment != null) {
            return new CommonResult(200, "查询成功" + serverPort, payment);
        }else {
            return new CommonResult(400, "没有对应记录，查询id：" + id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


}
