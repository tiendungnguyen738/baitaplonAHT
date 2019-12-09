package aht.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aht.entity.AhtRole;

public interface RoleRepository extends JpaRepository<AhtRole, Long>{

}
