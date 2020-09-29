package com.bjfs.fsjy.springcloud.controller;

import com.bjfs.fsjy.springcloud.entities.CommonResult;
import com.bjfs.fsjy.springcloud.entities.Payment;
import com.bjfs.fsjy.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther Tom
 * @create 2020/8/31
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        // openfeign-ribbon,客户端一般默认等待1秒
        return paymentFeignService.paymentFeignTimeout();
    }


}
