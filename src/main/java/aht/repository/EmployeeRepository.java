package aht.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aht.entity.AhtEmployee;

public interface EmployeeRepository extends JpaRepository<AhtEmployee, Long>{
	@Query("select u from AhtEmployee u where u.ahtDepartment.id = :departmentId")
	List<AhtEmployee> getEmployeeByDepartmentId(@Param("departmentId") Long departmentId);
	
	Page<AhtEmployee> findAllByEmpType(int EmpType,Pageable pageable);
	
//	@Query("select * "
//			+ "from AhtEmployee u inner join AhtContractEmp c on u.id = c.ahtEmployee.id "
//			+ "where c.ContractEmpStatus = :ContractEmpStatus",[nativeQuery = true])
//	Page<AhtEmployee> findAllByContractEmpStatus(@Param("ContractEmpStatus") int ContractEmpStatus,Pageable pageable);
}
