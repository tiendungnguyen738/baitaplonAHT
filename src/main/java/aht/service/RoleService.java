package aht.service;

import java.util.List;

import aht.dto.RoleDTO;

public interface RoleService {

	List<RoleDTO> getListRole();
	
	RoleDTO getRoleDTO(Long id);
	
}
