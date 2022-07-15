package com.service.user.controller;

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

import com.service.user.entity.User;
import com.service.user.service.UserService;
import com.service.user.util.HeaderGenerator;

@RestController
@RequestMapping("/user")
public class UserController {
	

	@Autowired
    private UserService userService;
    
    @Autowired
    private HeaderGenerator headerGenerator;

    @GetMapping (value = "/getAll")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getAllUsers();
 
    	return new ResponseEntity<List<User>>(
    			users,
    			headerGenerator.getHeadersForSuccessGetMethod(),
    			HttpStatus.OK);
   
    }
    
    @GetMapping (value = "/getUserForId", params="userId")
    public ResponseEntity<User> getUserForId(@RequestParam Integer userId){
        User user = userService.getUserById(userId).get();
 
    	if(user!=null) {
    		return new ResponseEntity<User>(
        			user,
        			headerGenerator.getHeadersForSuccessGetMethod(),
        			HttpStatus.OK);
        }
    	return new ResponseEntity<User>(
    			headerGenerator.getHeadersForSuccessGetMethod(),
    			HttpStatus.NOT_FOUND);
   
    }
    
    @GetMapping (value = "/getUserForName", params="username")
    public ResponseEntity<User> getUserForId(@RequestParam String username){
        User user = userService.getUserByName(username);
 
    	if(user!=null) {
    		return new ResponseEntity<User>(
        			user,
        			headerGenerator.getHeadersForSuccessGetMethod(),
        			HttpStatus.OK);
        }
    	return new ResponseEntity<User>(
    			headerGenerator.getHeadersForSuccessGetMethod(),
    			HttpStatus.NOT_FOUND);
   
    }
    
    @PostMapping (value = "/addUser")
    public ResponseEntity<User> addToCart(@RequestBody User user, HttpServletRequest request){
    	if(user!=null) {
    	User addedUser = userService.saveUser(user);
        	return new ResponseEntity<User>(
        			addedUser,
        			headerGenerator.getHeadersForSuccessPostMethod(request, user.getId()),
        			HttpStatus.CREATED);
        }
        return new ResponseEntity<User>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.INTERNAL_SERVER_ERROR);       
    }
}
