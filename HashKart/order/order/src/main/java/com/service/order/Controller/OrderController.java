package com.service.order.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.service.order.Entity.Order;
import com.service.order.Service.OrderService;
import com.service.order.Util.HeaderGenerator;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private HeaderGenerator headerGenerator;
	
	@Autowired
	RestTemplate rt;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<Order> placeOrders(@RequestBody Order order, HttpServletRequest request){
		
		if(order!=null) {
			//Integer userId = order.getId();
			//String url = "http://cartItem-service/cart/get"+userId;
			//ResponseEntity<Map>  response = rt.getForEntity(url, Map.class );
			//Map<Integer, Integer> cartItems = response.getBody();
	    	Order addedOrder = orderService.addOrder(order);
	    	
	    	
	        	return new ResponseEntity<Order>(
	        			addedOrder,
	        			headerGenerator.getHeadersForSuccessPostMethod(request, order.getId()),
	        			HttpStatus.CREATED);
	        }
	        return new ResponseEntity<Order>(
	        		headerGenerator.getHeadersForError(),
	        		HttpStatus.INTERNAL_SERVER_ERROR);
	        
	}
	
	
	@GetMapping(value="/get/{userId}")
	public ResponseEntity<List<Order>> getAllOrdersForUser(@PathVariable Integer userId ){
		
		List<Order> orders = orderService.getOrdersForUserId(userId);
		
		if(orders!=null) {
    		return new ResponseEntity<List<Order>>(
        			orders,
        			headerGenerator.getHeadersForSuccessGetMethod(),
        			HttpStatus.OK);
        }
    	return new ResponseEntity<List<Order>>(
    			headerGenerator.getHeadersForSuccessGetMethod(),
    			HttpStatus.NOT_FOUND);
		
	}
	
}
