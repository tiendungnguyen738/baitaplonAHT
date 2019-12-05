package aht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import aht.service.contractService;

@Controller
public class contractController {

	@Autowired
	private contractService contractServiceImpl;
	
	@GetMapping(path = {"/trang-user/quan-ly-hop-dong","/trang-user/quan-ly-hop-dong/{index}"})
	public ModelAndView trangQuanLy(@PathVariable(required = false, name="index") Integer index) {
		ModelAndView mav= new ModelAndView("quan-ly-hop-dong");
		mav.addObject("dsHopDong",contractServiceImpl.dsHopDong(index));
		mav.addObject("tongHopDong",contractServiceImpl.soTrangHopDong());
		return mav;
	}
}
