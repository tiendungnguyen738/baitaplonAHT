package aht.dto;

import java.util.Set;

public class UserDTO {

	private Long id;
	private String userName;
	private String userPass;
	private String userMail;
	private Set<UserRoleDTO> userRoleDTOs;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public Set<UserRoleDTO> getUserRoleDTOs() {
		return userRoleDTOs;
	}
	public void setUserRoleDTOs(Set<UserRoleDTO> userRoleDTOs) {
		this.userRoleDTOs = userRoleDTOs;
	}
}
