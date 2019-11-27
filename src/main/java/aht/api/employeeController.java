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

import aht.dto.DepartmentDTO;
import aht.dto.EmployeeDTO;
import aht.entity.AhtDepartment;
import aht.entity.AhtEmployee;
import aht.service.AhtDepartmentService;
import aht.service.EmployeeService;

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
		ModelMapper mapper = new ModelMapper();
		
		DepartmentDTO depart = new DepartmentDTO();
		depart.setId(em.getAhtDepartment().getId());;
		depart.setDepartmentName(em.getAhtDepartment().getDepartmentName());
		
		EmployeeDTO empl = mapper.map(em, EmployeeDTO.class);
		empl.setDepartment(depart);
		
		return empl;
	}
	@PostMapping("/api/employee")
	public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employee) {
		ModelMapper modelMapper = new ModelMapper();
		AhtDepartment depart = ahtDepartmentServiceImpl.layPhongBan(employee.getDepartment().getId());
		AhtEmployee emp = modelMapper.map(employee, AhtEmployee.class);
		emp.setAhtDepartment(depart);
		
		employeeServiceImpl.themNhanVien(emp);
		
		EmployeeDTO eDTO = modelMapper.map(emp, EmployeeDTO.class);
		DepartmentDTO pb  = new DepartmentDTO();
		pb.setId(depart.getId());
		pb.setDepartmentName(depart.getDepartmentName());
		eDTO.setDepartment(pb);
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
