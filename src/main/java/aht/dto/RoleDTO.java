package aht.dto;

import java.util.Set;

public class RoleDTO {

	private Long id;
	private String roleName;
	private Set<UserRoleDTO> userRoleDTOs;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<UserRoleDTO> getUserRoleDTOs() {
		return userRoleDTOs;
	}
	public void setUserRoleDTOs(Set<UserRoleDTO> userRoleDTOs) {
		this.userRoleDTOs = userRoleDTOs;
	}
}
