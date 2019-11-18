package aht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class adminController {

	@GetMapping("/quan-tri/trang-chu")
	public ModelAndView trangQuanTri() {
		ModelAndView mav = new ModelAndView("admin");
		return mav;
	}
}
