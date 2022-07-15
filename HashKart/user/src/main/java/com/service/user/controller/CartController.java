package com.service.user.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.user.entity.CartItem;
import com.service.user.service.CartItemService;
import com.service.user.util.HeaderGenerator;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
    private CartItemService cartItemService;
    
    @Autowired
    private HeaderGenerator headerGenerator;

    @GetMapping (value = "/get/{userId}")
    public ResponseEntity<Map<Integer, Integer>> getCartItemByUserId(@PathVariable Integer userId){
        Map<Integer, Integer> userCart = cartItemService.getCartByUserId(userId);
        if(!userCart.isEmpty()) {
        	return new ResponseEntity<Map<Integer, Integer>>(
        			userCart,
        			headerGenerator.getHeadersForSuccessGetMethod(),
        			HttpStatus.OK);
        }
        return new ResponseEntity<Map<Integer, Integer>>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);       
    }

    
    @PostMapping (value = "/update")
    public ResponseEntity<String> addToCart(@RequestBody CartItem cartItem, HttpServletRequest request){
    	if(cartItem!=null) {
    	String response = cartItemService.addToCart(cartItem);
        	return new ResponseEntity<String>(
        			response,
        			headerGenerator.getHeadersForSuccessPostMethod(request, cartItem.getId()),
        			HttpStatus.CREATED);
        }
        return new ResponseEntity<String>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.INTERNAL_SERVER_ERROR);       
    }
    
    @GetMapping (value = "/delete")
    public ResponseEntity<String> removeFromCart(@RequestParam Integer userId){
        String response = cartItemService.removeFromCart(userId);
        if(userId!=null) {
        	return new ResponseEntity<String>(
        			response,
        			headerGenerator.getHeadersForSuccessGetMethod(),
        			HttpStatus.OK);
        }
        return new ResponseEntity<String>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);       
    }
}
