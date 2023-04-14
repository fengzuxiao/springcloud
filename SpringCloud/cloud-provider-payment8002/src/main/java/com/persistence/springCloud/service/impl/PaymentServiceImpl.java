package com.persistence.springCloud.service.impl;

import com.persistence.springCloud.dao.PaymentDao;
import com.persistence.springCloud.entities.Payment;
import com.persistence.springCloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

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

    @Override
    public int updatePayment(Map<String, Object> params) {
        return paymentDao.updatePayment(params);
    }
}
