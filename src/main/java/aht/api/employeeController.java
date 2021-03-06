package aht.api;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aht.dto.EmployeeDTO;
import aht.entity.AhtDepartment;
import aht.entity.AhtEmployee;
import aht.service.AhtDepartmentService;
import aht.service.EmployeeService;
import aht.util.Convert;

@CrossOrigin(origins="http://localhost:4200",maxAge=3600)
@RestController
public class employeeController {

	@Autowired
	private EmployeeService employeeServiceImpl;
	
	@Autowired
	private AhtDepartmentService ahtDepartmentServiceImpl;

	@GetMapping("/api/employee")
	public List<EmployeeDTO> listEmployeeDTO(){
		List<EmployeeDTO> listEmp = employeeServiceImpl.layDanhSachNhanVien();
		return listEmp;
	}
	
	@GetMapping("/api/employee/{id}")
	public EmployeeDTO getEmployee(@PathVariable Long id) {
		AhtEmployee em = employeeServiceImpl.layMotNhanVien(id);
		EmployeeDTO employeeDTO = Convert.fromAhtEmployeeToEmployeeDTO(em);
		return employeeDTO;
	}
	@PostMapping("/api/employee")
	public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employee) {
		AhtDepartment depart = Convert.fromDepartmentDTOToAhtDepartment(employee.getDepartment());
		AhtEmployee emp = Convert.fromEmployeeDTOToAhtEmployee(employee);
		emp.setAhtDepartment(depart);
		employeeServiceImpl.themNhanVien(emp);
		
		EmployeeDTO eDTO = Convert.fromAhtEmployeeToEmployeeDTO(emp);
		return eDTO;
	}
	
	@PutMapping("/api/employee")
	public EmployeeDTO editEmployee(@RequestBody EmployeeDTO employee) {
		ModelMapper modelMapper = new ModelMapper();
		AhtDepartment depart = ahtDepartmentServiceImpl.layPhongBan(employee.getDepartment().getId());
		AhtEmployee em = modelMapper.map(employee, AhtEmployee.class);
		em.setAhtDepartment(depart);
		employeeServiceImpl.suaNhanVien(em);
		return employee;
	}
	
	@DeleteMapping("/api/employee/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeServiceImpl.xoaNhanVien(id);
	}
	
	
}
