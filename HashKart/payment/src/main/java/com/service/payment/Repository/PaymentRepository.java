package com.service.payment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.payment.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	Payment findByUserId(Integer userId);

	List<Payment> findAllByUserId(Integer userId);

}
