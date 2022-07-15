package com.service.payment.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.payment.Entity.Payment;
import com.service.payment.Service.PaymentService;
import com.service.payment.Util.HeaderGenerator;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	HeaderGenerator headerGenerator;
	
	
	@PostMapping (value = "/Pay")
    public ResponseEntity<Payment> addToCart(@RequestBody Payment payment, HttpServletRequest request){
    	if(payment!=null) {
    	Payment response = paymentService.addPayment(payment);
        	return new ResponseEntity<Payment>(
        			response,
        			headerGenerator.getHeadersForSuccessPostMethod(request, response.getPaymentId()),
        			HttpStatus.CREATED);
        }
        return new ResponseEntity<Payment>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.INTERNAL_SERVER_ERROR);       
    }
	
	   @GetMapping(value = "/getPay")
	   public ResponseEntity<List<Payment>> pay(@RequestParam Integer userId) {
		   List<Payment> pays = paymentService.getPayment(userId);
		   if(pays!=null) {
		    	
		        	return new ResponseEntity<List<Payment>>(
		        			pays,
		        			headerGenerator.getHeadersForSuccessGetMethod(),
		        			HttpStatus.OK);
		        }
		        return new ResponseEntity<List<Payment>>(
		        		headerGenerator.getHeadersForError(),
		        		HttpStatus.NOT_FOUND); 
	   }
	   
	   
	   
}
