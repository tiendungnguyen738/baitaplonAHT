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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="aht_department")
public class AhtDepartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="department_name")
	private String departmentName;
	
	@OneToOne
	@JoinColumn(name="parts_id",referencedColumnName = "id")
	private AhtParts ahtParts;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="department_id",referencedColumnName = "id")
	private Set<AhtEmployee> ahtEmployee;
	
	public Set<AhtEmployee> getAhtEmployee() {
		return ahtEmployee;
	}

	public void setAhtEmployee(Set<AhtEmployee> ahtEmployee) {
		this.ahtEmployee = ahtEmployee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public AhtParts getAhtParts() {
		return ahtParts;
	}

	public void setAhtParts(AhtParts ahtParts) {
		this.ahtParts = ahtParts;
	}
}
