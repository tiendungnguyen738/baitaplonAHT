package aht.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import aht.dto.EmployeeDTO;
import aht.service.EmployeeService;
import aht.service.impl.ExcelEmployeeListRepost;
import aht.service.impl.PdfEmployeeListRepost;

@Controller
public class baoCaoNhanSuController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/trang-user/ds-nv-congty")
	public ModelAndView dsNhanVienCongTy(HttpServletRequest request,HttpServletResponse response) {
		
		String typeReport = request.getParameter("type");
		List<EmployeeDTO> employeeDTOs = employeeService.layDanhSachNhanVien();
		
		if(typeReport != null && typeReport.equals("xlsx")) {
			return new ModelAndView(new ExcelEmployeeListRepost(), "employeeList", employeeDTOs);
		} else if(typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfEmployeeListRepost() , "employeeList", employeeDTOs);
		}
		
		//default
		return new ModelAndView("ds-nhan-vien-cong-ty", "employeeList", employeeDTOs);
	}
}
