package aht.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aht.entity.AhtEmployee;

public interface EmployeeRepository extends JpaRepository<AhtEmployee, Long>{

}
