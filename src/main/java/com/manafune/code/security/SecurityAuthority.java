package com.manafune.code.security;

import org.springframework.security.core.GrantedAuthority;

import com.manafune.code.model.Authority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {
	
	private final Authority authority;
	
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority.getName().toString();
	}

}
