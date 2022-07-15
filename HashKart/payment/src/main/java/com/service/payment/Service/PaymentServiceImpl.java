package com.service.payment.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.payment.Entity.Payment;
import com.service.payment.Repository.PaymentRepository;


@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentRepository repo;

	@Override
	public Payment addPayment(Payment payment) {
		return repo.save(payment);
	}

	@Override
	public List<Payment> getPayment(Integer userId) {
		return repo.findAllByUserId(userId);
	}

}
