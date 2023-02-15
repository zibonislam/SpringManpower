package com.manpower.management.service;

import com.manpower.management.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
}
