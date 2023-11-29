package com.manafune.code.utils;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

import com.manafune.code.model.Authority;
import com.manafune.code.model.User;
import com.manafune.code.repository.AuthorityRepository;
import com.manafune.code.repository.UserRepository;


@Component
public class Runner implements CommandLineRunner {

	private final UserRepository userRepository;
	private final AuthorityRepository authorityRepository;
	
	public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
		this.userRepository = userRepository;
		this.authorityRepository = authorityRepository; 
	}
	
	@Override
	public void run(String... arg) throws Exception{
		if(this.authorityRepository.count() == 0) {
			this.authorityRepository.saveAll(List.of(
					new Authority(AuthorityName.ADMIN),
					new Authority(AuthorityName.READ),
					new Authority(AuthorityName.WRITE)
					));
		}
		
		if(this.userRepository.count()== 0) {
			var encoders = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			this.userRepository.saveAll(List.of(
					new User("manafune", encoders.encode("pas123456"), List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
					new User("user01", "user0123", List.of(this.authorityRepository.findByName(AuthorityName.READ).get())),
					new User("user02", "user0234", List.of(this.authorityRepository.findByName(AuthorityName.WRITE).get()))
					));

		}
	}
}
