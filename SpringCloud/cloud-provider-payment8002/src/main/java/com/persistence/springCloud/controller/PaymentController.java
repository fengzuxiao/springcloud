package com.persistence.springCloud.controller;

import com.persistence.springCloud.entities.CommonResult;
import com.persistence.springCloud.entities.Payment;
import com.persistence.springCloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;//添加serverPort

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        Integer result = paymentService.create(payment);
        log.info("********插入结果：" + result);
        if (result > 0){
            return new CommonResult(200, "插入成功，serverPort：" + serverPort,result);
        }else {
            return new CommonResult(444, "插入失败" ,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("********查询结果：" + result);
        if (result != null){
            return new CommonResult(200, "查询成功，serverPort：" + serverPort,result);
        }else {
            return new CommonResult(444, "没有数据，查询ID:"+ id ,null);
        }
    }
    @PostMapping(value = "/payment/updatePayment")
    public CommonResult updatePayment(@RequestBody Map<String,Object> map){
        Integer result = paymentService.updatePayment(map);
        log.info("********更新结果：", result);
        if (result > 0){
            return new CommonResult(200, "更新成功", result);
        }else {
            return new CommonResult(444, "更新失败",null);
        }
    }


}
