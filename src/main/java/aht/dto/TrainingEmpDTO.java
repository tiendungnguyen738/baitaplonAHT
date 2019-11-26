package aht.dto;

public class TrainingEmpDTO {

	private Long id;
	private String TrainingEmpStartDate;
	private String TrainingEmpEndDate;
	private int TrainingEmpStatus;
	private String TrainingEmpResult;
	private EmployeeDTO employeeDTO;
	private TrainingDTO trainingDTO;
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
	public EmployeeDTO getEmployeeDTO() {
		return employeeDTO;
	}
	public void setEmployeeDTO(EmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
	}
	public TrainingDTO getTrainingDTO() {
		return trainingDTO;
	}
	public void setTrainingDTO(TrainingDTO trainingDTO) {
		this.trainingDTO = trainingDTO;
	}
}
