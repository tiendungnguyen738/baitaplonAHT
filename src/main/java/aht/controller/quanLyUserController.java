package aht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import aht.dto.RoleDTO;
import aht.dto.UserDTO;
import aht.service.AhtUserService;
import aht.service.RoleService;

@Controller
public class quanLyUserController {
	
	@Autowired
	private AhtUserService ahtUserService;
	
	@Autowired
	private RoleService roleService;

	@RequestMapping(value="/quan-tri/trang-chu/quan-ly-user")
	public ModelAndView trangQuanLyUser() {
		ModelAndView mav = new ModelAndView("quan-ly-user");
		
		List<UserDTO> list = ahtUserService.getListUser();
		mav.addObject("listUser",list);
		
		return mav;
	}
	
	@RequestMapping(value="/quan-tri/trang-chu/them-user")
	public ModelAndView trangThemUser() {
		ModelAndView mav= new ModelAndView("them-user");
		List<RoleDTO> dtos = roleService.getListRole();
		
		mav.addObject("listRoles", dtos);
		mav.addObject("userDTO", new UserDTO());
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/trang-chu/them-user/them",method=RequestMethod.POST)
	public String themUser(@ModelAttribute("userDTO") UserDTO userDTO) {
		ahtUserService.SaveUser(userDTO);
		return "redirect:/quan-tri/trang-chu/quan-ly-user";
	}
	
}
