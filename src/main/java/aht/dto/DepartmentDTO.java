package aht.dto;

import java.util.Set;

public class DepartmentDTO {
	private Long id;
	private PartDTO partDTO;
	private Set<EmployeeDTO> employeeDTOs;
	private String departmentName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PartDTO getPartDTO() {
		return partDTO;
	}
	public void setPartDTO(PartDTO partDTO) {
		this.partDTO = partDTO;
	}
	public Set<EmployeeDTO> getEmployeeDTOs() {
		return employeeDTOs;
	}
	public void setEmployeeDTOs(Set<EmployeeDTO> employeeDTOs) {
		this.employeeDTOs = employeeDTOs;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
