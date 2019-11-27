package aht.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import aht.dto.DepartmentDTO;
import aht.service.AhtDepartmentService;

@RestController
@CrossOrigin(origins="http://localhost:4200",maxAge=3600)
public class departmentApiController {

	@Autowired
	private AhtDepartmentService ahtDepartmentServiceImpl;
	
	@GetMapping("/api/departments")
	public List<DepartmentDTO> listDepartMent() {
		List<DepartmentDTO> departmentDTOs = ahtDepartmentServiceImpl.dsPhongBan();
		return departmentDTOs;
	}
}
