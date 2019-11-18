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
@Table(name="aht_employee")
public class AhtEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_dob")
	private String empDob;
	
	@Column(name="emp_sex")
	private int empSex;
	
	@Column(name="emp_number_insurance")
	private String empNumberInsurance;
	
	@Column(name="emp_address")
	private String empAddress;
	
	@Column(name="emp_phone")
	private String empPhone;
	
	@Column(name="emp_type")
	private int empType;
	
	@OneToOne
	@JoinColumn(name="department_id",referencedColumnName ="id")
	private AhtDepartment ahtDepartment;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="emp_id",referencedColumnName ="id")
	private Set<AhtTraningEmp> ahtTraningEmp;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="emp_id",referencedColumnName ="id")
	private Set<AhtContractEmp> ahtContractEmp;

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
}
