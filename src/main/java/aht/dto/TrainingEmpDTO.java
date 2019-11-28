package aht.dto;

public class TrainingEmpDTO {

	private Long id;
	private String trainingEmpStartDate;
	private String trainingEmpEndDate;
	private int trainingEmpStatus;
	private String trainingEmpResult;
	private EmployeeDTO employeeDTO;
	private TrainingDTO trainingDTO;
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
