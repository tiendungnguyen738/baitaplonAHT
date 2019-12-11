package aht.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aht.entity.AhtUserRole;

public interface userRoleRepository extends JpaRepository<AhtUserRole, Long>{

}
