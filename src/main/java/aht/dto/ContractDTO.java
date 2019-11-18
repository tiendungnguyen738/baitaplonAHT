package aht.dto;

import java.util.Set;

import aht.entity.AhtContractEmp;

public class ContractDTO {
	private Long id;
	private String ContractCode;
	private int ContractType;
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
	public ContractDTO() {
		super();
	}
}
