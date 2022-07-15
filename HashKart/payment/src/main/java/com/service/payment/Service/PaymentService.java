package com.service.payment.Service;

import java.util.List;

import com.service.payment.Entity.Payment;

public interface PaymentService {
	
	public Payment addPayment(Payment payment);
	public List<Payment> getPayment(Integer userId);
	
}
