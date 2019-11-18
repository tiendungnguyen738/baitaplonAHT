package aht.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import aht.entity.AhtDepartment;

public interface AhtDepartMentRepository extends JpaRepository<AhtDepartment, Long>{
	
	Page<AhtDepartment> findAll(Pageable pageable);
	
	@Query("select count(u) from AhtDepartment u")
	int tongSoPhongBan();
}
