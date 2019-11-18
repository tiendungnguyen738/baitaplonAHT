package aht.dto;

import java.util.Set;

import aht.entity.AhtContractEmp;
import aht.entity.AhtDepartment;
import aht.entity.AhtTraningEmp;

public class EmployeeDTO {

	private Long id;
	private String empName;
	private String empDob;
	private int empSex;
	private String empNumberInsurance;
	private String empAddress;
	private String empPhone;
	private int empType;
	private AhtDepartment ahtDepartment;
	private Set<AhtTraningEmp> ahtTraningEmp;
	private Set<AhtContractEmp> ahtContractEmp;
	
	public String getEmpNumberInsurance() {
		return empNumberInsurance;
	}
	public void setEmpNumberInsurance(String empNumberInsurance) {
		this.empNumberInsurance = empNumberInsurance;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	public int getEmpType() {
		return empType;
	}
	public void setEmpType(int empType) {
		this.empType = empType;
	}
	public AhtDepartment getAhtDepartment() {
		return ahtDepartment;
	}
	public void setAhtDepartment(AhtDepartment ahtDepartment) {
		this.ahtDepartment = ahtDepartment;
	}
	public Set<AhtTraningEmp> getAhtTraningEmp() {
		return ahtTraningEmp;
	}
	public void setAhtTraningEmp(Set<AhtTraningEmp> ahtTraningEmp) {
		this.ahtTraningEmp = ahtTraningEmp;
	}
	public Set<AhtContractEmp> getAhtContractEmp() {
		return ahtContractEmp;
	}
	public void setAhtContractEmp(Set<AhtContractEmp> ahtContractEmp) {
		this.ahtContractEmp = ahtContractEmp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDob() {
		return empDob;
	}
	public void setEmpDob(String empDob) {
		this.empDob = empDob;
	}
	public int getEmpSex() {
		return empSex;
	}
	public void setEmpSex(int empSex) {
		this.empSex = empSex;
	}
	
	
}
