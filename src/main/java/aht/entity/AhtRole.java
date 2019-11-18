package aht.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="aht_role")
public class AhtRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="role_name")
	private String roleName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="role_id",referencedColumnName = "id")
	private Set<AhtUserRole> ahtUserRole;

	public Set<AhtUserRole> getAhtUserRole() {
		return ahtUserRole;
	}

	public void setAhtUserRole(Set<AhtUserRole> ahtUserRole) {
		this.ahtUserRole = ahtUserRole;
	}

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
	
}
