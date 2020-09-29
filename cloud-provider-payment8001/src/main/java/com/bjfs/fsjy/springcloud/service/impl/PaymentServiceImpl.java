package com.bjfs.fsjy.springcloud.service.impl;

import com.bjfs.fsjy.springcloud.dao.PaymentDao;
import com.bjfs.fsjy.springcloud.entities.Payment;
import com.bjfs.fsjy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther Tom
 * @create 2020/7/24
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
