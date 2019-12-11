package aht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import aht.dto.UserDTO;
import aht.entity.AhtRole;
import aht.entity.AhtUser;
import aht.service.AhtUserService;
import aht.service.RoleService;
import aht.service.UserRoleService;
import aht.util.Convert;

@Controller
public class userRoleController {

	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private AhtUserService ahtUserService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/quan-tri/trang-chu/user-role")
	public ModelAndView trangUserRole() {
		ModelAndView mav = new ModelAndView("phan-quyen-user");
		mav.addObject("listUserRole", userRoleService.getListUserRole());
		mav.addObject("roleList", roleService.getListRole());
		return mav;
	}
	
	@RequestMapping(value="/quan-tri/trang-chu/user-role/them-user-role")
	public ModelAndView trangPhanQuyen() {
		ModelAndView mav = new ModelAndView("them-user-role");
		
		List<UserDTO> userDTOs = userRoleService.getListUserDtoWithOutRole(ahtUserService.getListUser(), userRoleService.getListUserRole());

		mav.addObject("listUser", userDTOs);
		mav.addObject("roleList", roleService.getListRole());
		return mav;
	}
	
	@GetMapping(value="/quan-tri/trang-chu/user-role/them-user-role/them")
	@ResponseBody
	public String addUserRole(@RequestParam(value="idUser") Long idUser,@RequestParam(value="idRole") Long idRole) {
		AhtUser ahtUser = Convert.fromUserDTOToAhtUser(ahtUserService.findUserById(idUser));
		AhtRole ahtRole = Convert.fromRoleDTOToAhtRole(roleService.getRoleDTO(idRole));
		
		userRoleService.addUserRole(ahtUser, ahtRole);
		return "success";
	}
	
	@PostMapping(value="/quan-tri/trang-chu/user-role/them-user-role/sua")
	@ResponseBody
	public String updateUserRole(@RequestParam(value="idUserRole") Long idUserRole,
								 @RequestParam(value="idUser") Long idUser,
								 @RequestParam(value="idRole") Long idRole) {
		userRoleService.updateUserRole(idUserRole, idUser, idRole);
		return "true";
	}
	
	@RequestMapping(value="/quan-tri/trang-chu/user-role/them-user-role/xoa/{id}",method=RequestMethod.GET)
	public String deleteUserRole(@PathVariable(value="id") Long idUserRole,ModelMap modelMap) {
		userRoleService.deleteUserRole(idUserRole);
		modelMap.addAttribute("listUserRole", userRoleService.getListUserRole());
		return "phan-quyen-user";
	}
}
