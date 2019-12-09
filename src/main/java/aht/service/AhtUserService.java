package aht.service;

import java.util.List;

import aht.dto.UserDTO;
import aht.entity.AhtUser;

public interface AhtUserService {

	void SaveUser(UserDTO userDTO);
	
	AhtUser findByUserName(String username);
	
	List<UserDTO> getListUser();
}
