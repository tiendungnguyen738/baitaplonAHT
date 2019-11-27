package aht.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import aht.dto.DepartmentDTO;
import aht.dto.EmployeeDTO;
import aht.dto.TrainingDTO;
import aht.dto.TrainingEmpDTO;
import aht.entity.AhtEmployee;
import aht.entity.AhtTraningEmp;
import aht.service.AhtDepartmentService;
import aht.service.EmployeeService;
import aht.service.TrainingEmpService;
import aht.service.TrainingService;

@Controller
public class trainingEmpController {

	@Autowired
	private TrainingEmpService trainingEmpServiceImpl;
	
	@Autowired
	private TrainingService trainingServiceImpl;
	
	@Autowired
	private AhtDepartmentService ahtDepartmentServiceImpl;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(path= {"/trang-user/quan-ly-training-emp"})
	public ModelAndView trangTrainingEmp() {
		List<TrainingEmpDTO> trainingEmpDTOs = trainingEmpServiceImpl.dsTrainingEmp();
		ModelAndView mav = new ModelAndView("quan-ly-khoa-dao-tao");
		mav.addObject("listTraining", trainingEmpDTOs);
		return mav;
	}
	@GetMapping("/trang-user/quan-ly-training-emp/them-khoa-dao-tao")
	public ModelAndView trangThemKhoaDaoTao() {
		ModelAndView mav = new ModelAndView("them-khoa-dao-tao");
		List<TrainingDTO> trainingDTOs = trainingServiceImpl.getAllTrainning();
		List<DepartmentDTO> departmentDTOs = ahtDepartmentServiceImpl.dsPhongBan();
		mav.addObject("trainingDTOs", trainingDTOs);
		mav.addObject("departmentDTOs", departmentDTOs);
		return mav;
	}
	@GetMapping("/trang-user/quan-ly-training-emp/danh-sach-nhan-vien")
	@ResponseBody
	public List<EmployeeDTO> getEmployeeByDepartmentId(@RequestParam("id") Long departmentId) {
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		List<AhtEmployee> ahtEmployees = employeeService.getEmployeeByDepartmentId((long) departmentId);
		
		for (AhtEmployee ahtEmployee : ahtEmployees) {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setEmpName(ahtEmployee.getEmpName());
			dto.setId(ahtEmployee.getId());
			
			employeeDTOs.add(dto);
		}
		return employeeDTOs;
	}
	@PostMapping("/quan-ly-training-emp/them")
	@ResponseBody
	public TrainingEmpDTO themKhoaDaoTao(@RequestBody TrainingEmpDTO trainingEmpDTO) {
//		ModelMapper modelMapper = new ModelMapper();
//		AhtTraningEmp ahtTrainingEmp = modelMapper.map(trainingEmpDTO, AhtTraningEmp.class);
//		System.out.println(trainingEmpDTO.getTrainingEmpStatus());
		return trainingEmpDTO;
	}
}
