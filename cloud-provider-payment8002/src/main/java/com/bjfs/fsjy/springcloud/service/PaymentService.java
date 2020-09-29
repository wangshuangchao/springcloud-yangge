package com.bjfs.fsjy.springcloud.service;

import com.bjfs.fsjy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @auther Tom
 * @create 2020/7/24
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
