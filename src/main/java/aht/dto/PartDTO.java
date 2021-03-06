package aht.dto;

import java.util.Set;

public class PartDTO {

	private Long id;
	private String partsName;
	private Set<DepartmentDTO> ahtDepartment;
	public PartDTO(Long id, String partsName, Set<DepartmentDTO> ahtDepartment) {
		super();
		this.id = id;
		this.partsName = partsName;
		this.ahtDepartment = ahtDepartment;
	}
	public PartDTO() {
		super();
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
	public Set<DepartmentDTO> getAhtDepartment() {
		return ahtDepartment;
	}
	public void setAhtDepartment(Set<DepartmentDTO> ahtDepartment) {
		this.ahtDepartment = ahtDepartment;
	}
}
