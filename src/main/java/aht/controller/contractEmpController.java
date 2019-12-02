package aht.controller;

import java.io.IOException;
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

import aht.dto.ContractDTO;
import aht.dto.ContractEmpDTO;
import aht.dto.DepartmentDTO;
import aht.dto.TrainingEmpDTO;
import aht.entity.AhtContractEmp;
import aht.entity.AhtTraningEmp;
import aht.service.AhtDepartmentService;
import aht.service.ContractEmpService;
import aht.service.EmployeeService;
import aht.service.contractService;
import aht.util.Convert;

@Controller
public class contractEmpController {

	@Autowired 
	private ContractEmpService contractEmpService;
	
	@Autowired
	private AhtDepartmentService ahtDepartmentService;
	
	@Autowired
	private contractService contractService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/trang-user/quan-ly-hd-nv")
	public ModelAndView dsHopDongNv() {
		ModelAndView mav = new ModelAndView("quan-ly-hop-dong-nv");
		List<ContractEmpDTO> contractEmpDTOs = contractEmpService.dsContractEmp();
		mav.addObject("contractEmpDTOs", contractEmpDTOs);
		return mav;
	}
	
	//hiển thi trang thêm hơp đồng
	@GetMapping(value = "/trang-user/quan-ly-hd-nv/them-hop-dong")
	public ModelAndView trangThemHopDong() {
		ModelAndView mav = new ModelAndView("them-hop-dong-nv");
		List<DepartmentDTO> departmentDTOs = ahtDepartmentService.dsPhongBan();
		List<ContractDTO> contractDTOs = contractService.dsHopDongDTO();
		mav.addObject("departmentDTOs", departmentDTOs);
		mav.addObject("contractDTOs", contractDTOs);
		return mav;
	}
	
	//thêm hợp đồng
	@PostMapping(value= "/quan-ly-hd-nv/them")
	@ResponseBody
	public String themHopDong1(@RequestParam String contractEmpDTO) throws JsonParseException, JsonMappingException, IOException {
		ContractEmpDTO contractEmpDTO1 = new ObjectMapper().readValue(contractEmpDTO,ContractEmpDTO.class);
		ModelMapper modelMapper = new ModelMapper();
		AhtContractEmp ahtContractEmp = modelMapper.map(contractEmpDTO1, AhtContractEmp.class);
		ahtContractEmp.setAhtEmployee(employeeService.layMotNhanVien(contractEmpDTO1.getEmployeeDTO().getId()));
		ahtContractEmp.setAhtContract(contractService.layHopDong(contractEmpDTO1.getContractDTO().getId()));
		contractEmpService.themHopDongNV(ahtContractEmp);
		return "true";
	}
	
	//hiển thị trang sửa thông tin hợp đồng
	@GetMapping(value = "/trang-user/quan-ly-hd-nv/sua-thong-tin/{id}")
	public ModelAndView trangSuaThongTin(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("sua-hop-dong-nv");
		ContractEmpDTO contractEmpDTO =  contractEmpService.layMotHopDongNV(id);
		List<ContractDTO> contractDTOs = contractService.dsHopDongDTO();
		mav.addObject("contractEmpDTO", contractEmpDTO);
		mav.addObject("contractDTOs", contractDTOs);
		return mav;
	}

	//cập nhật khóa đào tạo
	@RequestMapping(value = "/trang-user/quan-ly-hd-nv/sua-thong-tin/cap-nhat",method=RequestMethod.POST)
	public String veTrangDanhSach(@ModelAttribute("contractEmpDTO") ContractEmpDTO contractEmpDTO) {
		AhtContractEmp ahtContractEmp = Convert.fromContractEmpDTOToAhtContractEmp(contractEmpDTO);
		contractEmpService.CapNhatHopDong(ahtContractEmp);
		return "redirect:/trang-user/quan-ly-hd-nv";
	}
	
	@RequestMapping(value="/quan-ly-hd-nv/xoa",method = RequestMethod.GET)
	public void xoaHopDong(@RequestParam("id") Long id) {
		contractEmpService.xoaHopDong(id);
	}
}
