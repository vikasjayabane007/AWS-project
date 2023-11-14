package com.cognizant.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.model.UserLoginCredential;
import com.cognizant.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository urepo;

	@Override
	public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
		log.debug("Start : {}", "loadUserByUsername");
		UserLoginCredential member = urepo.findById(uid).orElse(null);
		
		log.debug("End : {}", "loadUserByUsername");
		return new User(member.getUid(), member.getPassword(), new ArrayList<>());

	}

}
