package aht.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aht.entity.AhtUser;

public interface AhtUserRepository extends JpaRepository<AhtUser, Long>{
	
	AhtUser findByUserName(String userName);
}
