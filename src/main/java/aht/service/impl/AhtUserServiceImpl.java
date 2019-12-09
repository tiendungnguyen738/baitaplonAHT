package aht.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import aht.dto.UserDTO;
import aht.entity.AhtUser;
import aht.repository.AhtUserRepository;
import aht.service.AhtUserService;
import aht.util.Convert;

@Service
public class AhtUserServiceImpl implements AhtUserService{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	@Autowired
	private AhtUserRepository ahtUserRepository;
	
	@Override
	public void SaveUser(UserDTO userDTO) {
		ModelMapper modelMapper = new ModelMapper();
		AhtUser user = modelMapper.map(userDTO, AhtUser.class);
		user.setUserPass(bCryptPasswordEncoder.encode(userDTO.getUserPass()));
		ahtUserRepository.save(user);
	}

	@Override
	public AhtUser findByUserName(String username) {
		return ahtUserRepository.findByUserName(username);
	}

	@Override
	public List<UserDTO> getListUser() {
		List<UserDTO> userDTOs = Convert.fromAhtUserListToUserDTOList(ahtUserRepository.findAll());
		return userDTOs;
	}
}
