package aht.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="aht_contract_emp")
public class AhtContractEmp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="contract_emp_start_date")
	private String ContractEmpStartDate;
	
	@Column(name="contract_emp_end_date")
	private String ContractEmpEndDate;
	
	@Column(name="contract_emp_status")
	private int ContractEmpStatus;
	
	@OneToOne
	@JoinColumn(name="emp_id",referencedColumnName ="id")
	private AhtEmployee ahtEmployee;
	
	@OneToOne
	@JoinColumn(name="contract_id",referencedColumnName ="id")
	private AhtContract ahtContract;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContractEmpStartDate() {
		return ContractEmpStartDate;
	}

	public void setContractEmpStartDate(String contractEmpStartDate) {
		ContractEmpStartDate = contractEmpStartDate;
	}

	public String getContractEmpEndDate() {
		return ContractEmpEndDate;
	}

	public void setContractEmpEndDate(String contractEmpEndDate) {
		ContractEmpEndDate = contractEmpEndDate;
	}

	public int getContractEmpStatus() {
		return ContractEmpStatus;
	}

	public void setContractEmpStatus(int contractEmpStatus) {
		ContractEmpStatus = contractEmpStatus;
	}

	public AhtEmployee getAhtEmployee() {
		return ahtEmployee;
	}

	public void setAhtEmployee(AhtEmployee ahtEmployee) {
		this.ahtEmployee = ahtEmployee;
	}

	public AhtContract getAhtContract() {
		return ahtContract;
	}

	public void setAhtContract(AhtContract ahtContract) {
		this.ahtContract = ahtContract;
	}
}
