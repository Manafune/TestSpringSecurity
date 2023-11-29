package com.manafune.code.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manafune.code.model.Authority;
import com.manafune.code.utils.AuthorityName;



public interface AuthorityRepository extends JpaRepository<Authority, Long>{

	Optional<Authority> findByName(AuthorityName name);
}
