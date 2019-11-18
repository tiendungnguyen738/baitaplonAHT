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
	private String TrainingEmpStartDate;
	
	@Column(name="training_emp_end_date")
	private String TrainingEmpEndDate;
	
	@Column(name="training_emp_status")
	private int TrainingEmpStatus;
	
	@Column(name="training_emp_result")
	private String TrainingEmpResult;

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
		return TrainingEmpStartDate;
	}

	public void setTrainingEmpStartDate(String trainingEmpStartDate) {
		TrainingEmpStartDate = trainingEmpStartDate;
	}

	public String getTrainingEmpEndDate() {
		return TrainingEmpEndDate;
	}

	public void setTrainingEmpEndDate(String trainingEmpEndDate) {
		TrainingEmpEndDate = trainingEmpEndDate;
	}

	public int getTrainingEmpStatus() {
		return TrainingEmpStatus;
	}

	public void setTrainingEmpStatus(int trainingEmpStatus) {
		TrainingEmpStatus = trainingEmpStatus;
	}

	public String getTrainingEmpResult() {
		return TrainingEmpResult;
	}

	public void setTrainingEmpResult(String trainingEmpResult) {
		TrainingEmpResult = trainingEmpResult;
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
