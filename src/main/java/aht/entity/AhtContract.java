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
@Table(name="aht_contract")
public class AhtContract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="contract_code")
	private String ContractCode;
	
	@Column(name="contract_type")
	private int ContractType;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="contract_id",referencedColumnName ="id")
	private Set<AhtContractEmp> ahtContractEmp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContractCode() {
		return ContractCode;
	}

	public void setContractCode(String contractCode) {
		ContractCode = contractCode;
	}

	public int getContractType() {
		return ContractType;
	}

	public void setContractType(int contractType) {
		ContractType = contractType;
	}

	public Set<AhtContractEmp> getAhtContractEmp() {
		return ahtContractEmp;
	}

	public void setAhtContractEmp(Set<AhtContractEmp> ahtContractEmp) {
		this.ahtContractEmp = ahtContractEmp;
	}
}
