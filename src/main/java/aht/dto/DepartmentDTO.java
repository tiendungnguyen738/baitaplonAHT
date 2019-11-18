package aht.dto;

import java.util.Set;

import aht.entity.AhtEmployee;
import aht.entity.AhtParts;

public class DepartmentDTO {
	private Long id;
	private AhtParts ahtParts;
	private Set<AhtEmployee> ahtEmployee;
	private String departmentName;
	
	public DepartmentDTO() {
		super();
	}
	public DepartmentDTO(Long id, AhtParts ahtParts, Set<AhtEmployee> ahtEmployee, String departmentName) {
		super();
		this.id = id;
		this.ahtParts = ahtParts;
		this.ahtEmployee = ahtEmployee;
		this.departmentName = departmentName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AhtParts getAhtParts() {
		return ahtParts;
	}
	public void setAhtParts(AhtParts ahtParts) {
		this.ahtParts = ahtParts;
	}
	public Set<AhtEmployee> getAhtEmployee() {
		return ahtEmployee;
	}
	public void setAhtEmployee(Set<AhtEmployee> ahtEmployee) {
		this.ahtEmployee = ahtEmployee;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
