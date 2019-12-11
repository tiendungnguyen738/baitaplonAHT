package aht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/quan-tri/trang-chu/sua-user/{id}",method=RequestMethod.GET)
	public ModelAndView trangSuaUser(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("sua-user");
		UserDTO userDTO = ahtUserService.findUserById(id);
		mav.addObject("userDTO", userDTO);
		return mav;
	}
	
	@RequestMapping(value="/quan-tri/trang-chu/sua-user",method=RequestMethod.POST)
	public String suaUser(@ModelAttribute("userDTO") UserDTO userDTO) {
		ahtUserService.UpdateUser(userDTO);
		return "redirect:/quan-tri/trang-chu/quan-ly-user";
	}
	
	@RequestMapping(value="/quan-tri/trang-chu/xoa-user/{id}",method=RequestMethod.GET)
	public String xoaUser(@PathVariable Long id,ModelMap modelMap) {
		ahtUserService.xoaUser(id);
		
		List<UserDTO> list = ahtUserService.getListUser();
		modelMap.addAttribute("listUser", list);
		return "quan-ly-user";
	}
	
}
