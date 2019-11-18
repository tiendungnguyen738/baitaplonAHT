package aht.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="aht_user_role")
public class AhtUserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="user_id",referencedColumnName = "id")
	private AhtUser ahtUser;
	
	@OneToOne
	@JoinColumn(name="role_id",referencedColumnName = "id")
	private AhtRole ahtRole;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AhtUser getAhtUser() {
		return ahtUser;
	}

	public void setAhtUser(AhtUser ahtUser) {
		this.ahtUser = ahtUser;
	}

	public AhtRole getAhtRole() {
		return ahtRole;
	}

	public void setAhtRole(AhtRole ahtRole) {
		this.ahtRole = ahtRole;
	}

}
