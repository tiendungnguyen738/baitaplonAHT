package aht.dto;

public class ContractEmpDTO {

	private Long id;
	private String ContractEmpStartDate;
	private String ContractEmpEndDate;
	private int ContractEmpStatus;
	private EmployeeDTO employeeDTO;
	private ContractDTO contractDTO;
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
	public EmployeeDTO getEmployeeDTO() {
		return employeeDTO;
	}
	public void setEmployeeDTO(EmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
	}
	public ContractDTO getContractDTO() {
		return contractDTO;
	}
	public void setContractDTO(ContractDTO contractDTO) {
		this.contractDTO = contractDTO;
	}
}
