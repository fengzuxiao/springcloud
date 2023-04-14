package com.persistence.springCloud.service;

import com.persistence.springCloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

    public int updatePayment(Map<String, Object> params);
}
