package aht.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import aht.dto.DepartmentDTO;
import aht.entity.AhtDepartment;
import aht.service.impl.AhtDepartmentServiceImpl;

@RestController
@CrossOrigin(origins="http://localhost:4200",maxAge=3600)
public class departmentApiController {

	@Autowired
	private AhtDepartmentServiceImpl ahtDepartmentServiceImpl;
	
	@GetMapping("/api/departments")
	public List<DepartmentDTO> listDepartMent() {
		List<AhtDepartment> departments = ahtDepartmentServiceImpl.dsPhongBan();
		List<DepartmentDTO> departmentDTOs = new ArrayList<DepartmentDTO>();
		
		for (AhtDepartment ahtDepartment : departments) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setId(ahtDepartment.getId());
			departmentDTO.setDepartmentName(ahtDepartment.getDepartmentName());
			departmentDTOs.add(departmentDTO);
		}
		return departmentDTOs;
	}
}
