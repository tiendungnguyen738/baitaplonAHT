package aht.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import aht.entity.AhtContract;

public interface ContractRepository extends JpaRepository<AhtContract, Long>{

	Page<AhtContract> findAll(Pageable pageable);
	
	@Query("select count(u) from AhtContract u")
	int tongSoHopDong();
}
