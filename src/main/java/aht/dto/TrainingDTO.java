package aht.dto;

import java.util.Set;

import aht.entity.AhtTraningEmp;

public class TrainingDTO {
	private Long id;
	private String TrainingName;
	private String TrainingCode;
	private String TrainingStartDate;
	private String TrainingEndDate;
	private int TrainingStatus;
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
