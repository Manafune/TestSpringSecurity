package com.manafune.code.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manafune.code.repository.UserRepository;
import com.manafune.code.security.SecurityUser;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;

	public SecurityUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		var optUser = this.userRepository.findByUsername(username);
		if(optUser.isPresent()) {
			return new SecurityUser(optUser.get());
		}
		throw new UsernameNotFoundException("User not Found: "+username);
	}
}
