package aht.api;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aht.dto.EmployeeDTO;
import aht.entity.AhtEmployee;
import aht.service.impl.EmployeeServiceImp;


@RestController
public class employeeController {

	@Autowired
	private EmployeeServiceImp employeeServiceImpl;

	@GetMapping("/api/employee")
	public List<EmployeeDTO> listEmployeeDTO(){
		List<EmployeeDTO> listEmp = employeeServiceImpl.layDanhSachNhanVien();
		return listEmp;
	}
	
	@PostMapping("/api/employee")
	public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employee) {
		ModelMapper modelMapper = new ModelMapper();
		AhtEmployee emp = modelMapper.map(employee, AhtEmployee.class);
		employeeServiceImpl.themNhanVien(emp);
		return employee;
	}
	
	@PutMapping("/api/employee")
	public void editEmployee(@RequestBody EmployeeDTO employee) {
		ModelMapper modelMapper = new ModelMapper();
		AhtEmployee em = modelMapper.map(employee, AhtEmployee.class);
		employeeServiceImpl.suaNhanVien(em);
	}
	
	@DeleteMapping("/api/employee")
	public void deleteEmployee(@RequestParam Long id) {
		employeeServiceImpl.xoaNhanVien(id);
	}
}