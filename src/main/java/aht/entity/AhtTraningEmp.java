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
@Table(name="aht_training_emp")
public class AhtTraningEmp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="training_emp_start_date")
	private String trainingEmpStartDate;
	
	@Column(name="training_emp_end_date")
	private String trainingEmpEndDate;
	
	@Column(name="training_emp_status")
	private int trainingEmpStatus;
	
	@Column(name="training_emp_result")
	private String trainingEmpResult;

	@OneToOne
	@JoinColumn(name="emp_id",referencedColumnName = "id")
	private AhtEmployee ahtEmployee;
	
	@OneToOne
	@JoinColumn(name="training_id",referencedColumnName = "id")
	private AhtTraining ahtTraining;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrainingEmpStartDate() {
		return trainingEmpStartDate;
	}

	public void setTrainingEmpStartDate(String trainingEmpStartDate) {
		this.trainingEmpStartDate = trainingEmpStartDate;
	}

	public String getTrainingEmpEndDate() {
		return trainingEmpEndDate;
	}

	public void setTrainingEmpEndDate(String trainingEmpEndDate) {
		this.trainingEmpEndDate = trainingEmpEndDate;
	}

	public int getTrainingEmpStatus() {
		return trainingEmpStatus;
	}

	public void setTrainingEmpStatus(int trainingEmpStatus) {
		this.trainingEmpStatus = trainingEmpStatus;
	}

	public String getTrainingEmpResult() {
		return trainingEmpResult;
	}

	public void setTrainingEmpResult(String trainingEmpResult) {
		this.trainingEmpResult = trainingEmpResult;
	}

	public AhtEmployee getAhtEmployee() {
		return ahtEmployee;
	}

	public void setAhtEmployee(AhtEmployee ahtEmployee) {
		this.ahtEmployee = ahtEmployee;
	}

	public AhtTraining getAhtTraining() {
		return ahtTraining;
	}

	public void setAhtTraining(AhtTraining ahtTraining) {
		this.ahtTraining = ahtTraining;
	}
}
