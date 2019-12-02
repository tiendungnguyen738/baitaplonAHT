package aht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import aht.dto.EmployeeDTO;
import aht.service.EmployeeService;

@Controller
public class baoCaoNhanSuController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/trang-user/ds-nv-congty")
	public ModelAndView dsNhanVienCongTy() {
		ModelAndView mav = new ModelAndView("ds-nhan-vien-cong-ty");
		List<EmployeeDTO> employeeDTOs = employeeService.layDanhSachNhanVien();
		mav.addObject("employeeDTOs", employeeDTOs);
		return mav;
	}
}
