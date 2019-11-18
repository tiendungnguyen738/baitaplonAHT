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
@Table(name="aht_parts")
public class AhtParts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="parts_name")
	private String partsName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="parts_id",referencedColumnName = "id")
	private Set<AhtDepartment> ahtDepartment;

	public Set<AhtDepartment> getAhtDepartment() {
		return ahtDepartment;
	}

	public void setAhtDepartment(Set<AhtDepartment> ahtDepartment) {
		this.ahtDepartment = ahtDepartment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPartsName() {
		return partsName;
	}

	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}
}
