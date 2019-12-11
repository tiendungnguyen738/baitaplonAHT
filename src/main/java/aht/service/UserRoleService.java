package aht.service;

import java.util.List;

import aht.dto.UserDTO;
import aht.dto.UserRoleDTO;
import aht.entity.AhtRole;
import aht.entity.AhtUser;

public interface UserRoleService {

	List<UserRoleDTO> getListUserRole();
	List<UserDTO> getListUserDtoWithOutRole(List<UserDTO> userDTOs,List<UserRoleDTO> userRoleDTOs);
	void addUserRole(AhtUser ahtUser,AhtRole ahtRole);
	void updateUserRole(Long idUserRole,Long idUser,Long idRole);
	void deleteUserRole(Long idUserRole);
}
