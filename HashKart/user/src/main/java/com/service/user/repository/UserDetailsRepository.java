package com.service.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.user.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>{

}
