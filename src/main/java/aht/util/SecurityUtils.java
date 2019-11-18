package aht.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import aht.security.MyUser;

public class SecurityUtils {

	public static MyUser getPrincical() {
		MyUser myUser =  (MyUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
		return myUser;
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() {
		List<String> listRole =  new ArrayList<String>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			listRole.add(grantedAuthority.getAuthority());
		}
		return listRole;
	}
}
