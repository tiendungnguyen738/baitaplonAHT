package aht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import aht.entity.AhtParts;
import aht.service.AhtPartsService;

@Controller
public class partsController {

	@Autowired
	private AhtPartsService ahtPartsServiceImpl;
	
	@GetMapping("/trang-user/quan-ly-bo-phan")
	public ModelAndView danhMucBoPhan() {
		ModelAndView mav = new ModelAndView("quan-ly-bo-phan");
		List<AhtParts> danhSachBoPhan = ahtPartsServiceImpl.layDanhSachBoPhan();
		mav.addObject("danhSachBoPhan", danhSachBoPhan);
		return mav;
	}
}
