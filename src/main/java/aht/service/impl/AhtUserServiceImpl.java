package aht.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import aht.entity.AhtUser;
import aht.repository.AhtUserRepository;
import aht.service.AhtUserService;

@Service
public class AhtUserServiceImpl implements AhtUserService{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	@Autowired
	private AhtUserRepository ahtUserRepository;
	
	@Override
	public void SaveUser(AhtUser user) {
		user.setUserPass(bCryptPasswordEncoder.encode(user.getUserPass()));
		ahtUserRepository.save(user);
	}

	@Override
	public AhtUser findByUserName(String username) {
		return ahtUserRepository.findByUserName(username);
	}
}
