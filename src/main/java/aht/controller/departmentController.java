package aht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import aht.service.AhtDepartmentService;
import aht.service.AhtPartsService;

@Controller
public class departmentController {

	@Autowired
	private AhtDepartmentService ahtDepartmentServiceImpl;
	
	@Autowired
	private AhtPartsService ahtPartsServiceImpl;
	
	@GetMapping(path = {"/trang-user/quan-ly-pb","/trang-user/quan-ly-pb/{index}"})
	public ModelAndView trangQuanLy(@PathVariable(required = false, name="index") Integer index) {
		ModelAndView mav= new ModelAndView("quan-ly-phong-ban");
		
		mav.addObject("dsBoPhan", ahtPartsServiceImpl.layDanhSachBoPhan());
		mav.addObject("dsPhongBan",ahtDepartmentServiceImpl.dsPhongBanPhanTrang(index));
		mav.addObject("tongPhongBan",ahtDepartmentServiceImpl.soTrangPhongBan() );
		return mav;
	}
}
