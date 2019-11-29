package aht.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import aht.dto.DepartmentDTO;
import aht.dto.EmployeeDTO;
import aht.dto.TrainingDTO;
import aht.dto.TrainingEmpDTO;
import aht.entity.AhtEmployee;
import aht.entity.AhtTraining;
import aht.entity.AhtTraningEmp;
import aht.service.AhtDepartmentService;
import aht.service.EmployeeService;
import aht.service.TrainingEmpService;
import aht.service.TrainingService;
import aht.util.Convert;

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
	
	//hiển thị danh sách các khóa đào tạo
	@GetMapping(path= {"/trang-user/quan-ly-training-emp"})
	public ModelAndView trangTrainingEmp() {
		List<TrainingEmpDTO> trainingEmpDTOs = trainingEmpServiceImpl.dsTrainingEmp();
		ModelAndView mav = new ModelAndView("quan-ly-khoa-dao-tao");
		mav.addObject("listTraining", trainingEmpDTOs);
		return mav;
	}
	
	//hiển thị trang thêm khóa đào tạo
	@GetMapping(value = "/trang-user/quan-ly-training-emp/them-khoa-dao-tao")
	public ModelAndView trangThemKhoaDaoTao() {
		ModelAndView mav = new ModelAndView("them-khoa-dao-tao");
		List<TrainingDTO> trainingDTOs = trainingServiceImpl.getAllTrainning();
		List<DepartmentDTO> departmentDTOs = ahtDepartmentServiceImpl.dsPhongBan();
		mav.addObject("trainingDTOs", trainingDTOs);
		mav.addObject("departmentDTOs", departmentDTOs);
		return mav;
	}
	
	//hiển thị danh sách nhân viên trong 1 phòng. Cho trang thêm khóa đào tạo
	@GetMapping(value = "/trang-user/quan-ly-training-emp/danh-sach-nhan-vien")
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

	//thêm thông tin khóa đào tạo
	@PostMapping(value= "/quan-ly-training-emp/them")
	@ResponseBody
	public String themKhoaDaoTao1(@RequestParam String trainingEmp) throws JsonParseException, JsonMappingException, IOException {
		TrainingEmpDTO trainingEmpDTO = new ObjectMapper().readValue(trainingEmp,TrainingEmpDTO.class);
		ModelMapper modelMapper = new ModelMapper();
		AhtTraningEmp ahtTraningEmp = modelMapper.map(trainingEmpDTO, AhtTraningEmp.class);
		ahtTraningEmp.setAhtEmployee(employeeService.layMotNhanVien(trainingEmpDTO.getEmployeeDTO().getId()));
		ahtTraningEmp.setAhtTraining(trainingServiceImpl.getTrainning(trainingEmpDTO.getTrainingDTO().getId()));
		trainingEmpServiceImpl.themKhoaDaoTao(ahtTraningEmp);
		return "true";
	}
	
	//hiển thị trang sửa thông tin khóa đào tạo
	@GetMapping(value = "/trang-user/quan-ly-training-emp/sua-thong-tin/{id}")
	public ModelAndView trangSuaThongTin(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("sua-khoa-dao-tao");
		AhtTraningEmp ahtTraningEmp = trainingEmpServiceImpl.layMotKhoaDaoTao(id);
		
		TrainingEmpDTO trainingEmpDTO = Convert.fromTrainingEntityToTrainingDTO(ahtTraningEmp);
		
		List<TrainingDTO> trainingDTOs = trainingServiceImpl.getAllTrainning();
		
		mav.addObject("trainingEmpDTO", trainingEmpDTO);
		mav.addObject("trainingDTOs", trainingDTOs);
		return mav;
	}
							 				
	//cập nhật khóa đào tạo
	@RequestMapping(value = "/trang-user/quan-ly-training-emp/sua-thong-tin/cap-nhat",method=RequestMethod.POST)
	public String veTrangDanhSach(@ModelAttribute("trainingEmpDTO") TrainingEmpDTO trainingEmpDTO) {
		AhtTraningEmp ahtTraningEmp = Convert.fromTrainingDTOToTrainingEntity(trainingEmpDTO);
		System.out.println("id::::::::::::::::::"+ ahtTraningEmp.getId()+
		" idNhanvien:::::::::::::::"+ahtTraningEmp.getAhtEmployee().getId()+
		" idPhong::::::::::::::::::"+ahtTraningEmp.getAhtEmployee().getAhtDepartment().getId()+
		" idKhoa:::::::::::::::::::"+ahtTraningEmp.getAhtTraining().getId());
		//trainingEmpServiceImpl.capNhatKhoaDaoTao(ahtTraningEmp);
		return "redirect:/trang-user/quan-ly-training-emp";
	}
}
