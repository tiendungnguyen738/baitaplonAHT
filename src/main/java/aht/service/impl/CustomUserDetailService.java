package aht.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import aht.entity.AhtUser;
import aht.entity.AhtUserRole;
import aht.security.MyUser;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private AhtUserServiceImpl ahtUserServiceImpl; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AhtUser ahtUser = ahtUserServiceImpl.findByUserName(username);
		if(ahtUser == null) {
			throw new UsernameNotFoundException("không tìm thấy user !!!");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (AhtUserRole role : ahtUser.getAhtUserRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getAhtRole().getRoleName()));
		}
		
		MyUser myUser = new MyUser(ahtUser.getUserName(),ahtUser.getUserPass(),authorities);
		return myUser;
	}

	
}
