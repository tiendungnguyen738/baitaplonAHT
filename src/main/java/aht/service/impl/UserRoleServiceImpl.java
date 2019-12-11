package aht.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aht.dto.RoleDTO;
import aht.dto.UserDTO;
import aht.dto.UserRoleDTO;
import aht.entity.AhtRole;
import aht.entity.AhtUser;
import aht.entity.AhtUserRole;
import aht.repository.userRoleRepository;
import aht.service.AhtUserService;
import aht.service.RoleService;
import aht.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired
	private userRoleRepository userRoleRepository;  
	
	@Autowired
	private AhtUserService ahtUserService;
	
	@Autowired
	private RoleService roleService; 
	
	@Override
	public List<UserRoleDTO> getListUserRole() {
		List<AhtUserRole> ahtUserRoles = userRoleRepository.findAll();
		List<UserRoleDTO> userRoleDTOs = new ArrayList<UserRoleDTO>();
		
		for (AhtUserRole ahtUserRole : ahtUserRoles) {
			UserDTO userDTO = ahtUserService.findUserById(ahtUserRole.getAhtUser().getId());
			RoleDTO roleDTO = roleService.getRoleDTO(ahtUserRole.getAhtRole().getId());
			
			UserRoleDTO userRoleDTO = new UserRoleDTO();
			userRoleDTO.setRoleDTO(roleDTO);
			userRoleDTO.setUserDTO(userDTO);
			userRoleDTO.setId(ahtUserRole.getId());
			
			userRoleDTOs.add(userRoleDTO);
		}
		
		return userRoleDTOs;
	}

	@Override
	public List<UserDTO> getListUserDtoWithOutRole(List<UserDTO> userDTOs,List<UserRoleDTO> userRoleDTOs) {
		for (UserRoleDTO userRoleDTO : userRoleDTOs) {
			
			Iterator<UserDTO> userIterator = userDTOs.iterator();
			while(userIterator.hasNext()) {
				UserDTO userDTO = userIterator.next();
				if(userDTO.getId().equals(userRoleDTO.getUserDTO().getId())) {
					userIterator.remove();
				}
			}
		
		}
		
		return userDTOs;
	}

	@Override
	public void addUserRole(AhtUser ahtUser,AhtRole ahtRole) {
		AhtUserRole ahtUserRole = new AhtUserRole();
		ahtUserRole.setAhtRole(ahtRole);
		ahtUserRole.setAhtUser(ahtUser);
		
		userRoleRepository.save(ahtUserRole);
	}

	@Override
	public void updateUserRole(Long idUserRole, Long idUser, Long idRole) {
		AhtUserRole ahtUserRole = new AhtUserRole();
		ahtUserRole.setId(idUserRole);
		
		AhtUser ahtUser = new AhtUser();
		ahtUser.setId(idUser);
		
		AhtRole ahtRole = new AhtRole();
		ahtRole.setId(idRole);
		
		ahtUserRole.setAhtRole(ahtRole);
		ahtUserRole.setAhtUser(ahtUser);
		
		userRoleRepository.save(ahtUserRole);
	}

	@Override
	public void deleteUserRole(Long idUserRole) {
		userRoleRepository.delete(idUserRole);
	}

}
