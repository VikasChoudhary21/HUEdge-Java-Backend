package com.service.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String userName);

}
