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
import javax.persistence.Table;

@Entity
@Table(name="aht_training")
public class AhtTraining {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="training_name")
	private String TrainingName;
	
	@Column(name="training_code")
	private String TrainingCode;
	
	@Column(name="training_start_date")
	private String TrainingStartDate;
	
	@Column(name="training_end_date")
	private String TrainingEndDate;
	
	@Column(name="training_status")
	private int TrainingStatus;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="training_id",referencedColumnName = "id")
	private Set<AhtTraningEmp> ahtTraningEmp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrainingName() {
		return TrainingName;
	}

	public void setTrainingName(String trainingName) {
		TrainingName = trainingName;
	}

	public String getTrainingCode() {
		return TrainingCode;
	}

	public void setTrainingCode(String trainingCode) {
		TrainingCode = trainingCode;
	}

	public String getTrainingStartDate() {
		return TrainingStartDate;
	}

	public void setTrainingStartDate(String trainingStartDate) {
		TrainingStartDate = trainingStartDate;
	}

	public String getTrainingEndDate() {
		return TrainingEndDate;
	}

	public void setTrainingEndDate(String trainingEndDate) {
		TrainingEndDate = trainingEndDate;
	}

	public int getTrainingStatus() {
		return TrainingStatus;
	}

	public void setTrainingStatus(int trainingStatus) {
		TrainingStatus = trainingStatus;
	}

	public Set<AhtTraningEmp> getAhtTraningEmp() {
		return ahtTraningEmp;
	}

	public void setAhtTraningEmp(Set<AhtTraningEmp> ahtTraningEmp) {
		this.ahtTraningEmp = ahtTraningEmp;
	}
}
