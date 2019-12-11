package aht.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aht.dto.RoleDTO;
import aht.entity.AhtRole;
import aht.repository.RoleRepository;
import aht.service.RoleService;
import aht.util.Convert;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<RoleDTO> getListRole() {
		List<AhtRole> ahtRoles = roleRepository.findAll();
		List<RoleDTO> roleDTOs = new ArrayList<RoleDTO>();
		
		for (AhtRole role : ahtRoles) {
			roleDTOs.add(Convert.fromAhtRoleToRoleDTO(role));
		}
		
		return roleDTOs;
	}

	@Override
	public RoleDTO getRoleDTO(Long id) {
		return Convert.fromAhtRoleToRoleDTO(roleRepository.findOne(id));
	}
	
	

}
