package aht.service;

import aht.entity.AhtUser;

public interface AhtUserService {

	void SaveUser(AhtUser user);
	
	AhtUser findByUserName(String username);
}
