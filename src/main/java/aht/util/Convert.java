package aht.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import aht.dto.ContractDTO;
import aht.dto.ContractEmpDTO;
import aht.dto.DepartmentDTO;
import aht.dto.EmployeeDTO;
import aht.dto.TrainingDTO;
import aht.dto.TrainingEmpDTO;
import aht.entity.AhtContract;
import aht.entity.AhtContractEmp;
import aht.entity.AhtDepartment;
import aht.entity.AhtEmployee;
import aht.entity.AhtTraining;
import aht.entity.AhtTraningEmp;

@Component
public class Convert {

	public static TrainingEmpDTO fromTrainingEntityToTrainingDTO(AhtTraningEmp ahtTraningEmp) {
		ModelMapper modelMapper = new ModelMapper();
		TrainingEmpDTO trainingEmpDTO = modelMapper.map(ahtTraningEmp, TrainingEmpDTO.class);
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmpName(ahtTraningEmp.getAhtEmployee().getEmpName());
		employeeDTO.setId(ahtTraningEmp.getAhtEmployee().getId());
		DepartmentDTO departmentDTO = modelMapper.map(ahtTraningEmp.getAhtEmployee().getAhtDepartment(), DepartmentDTO.class);
		employeeDTO.setDepartment(departmentDTO);
		
		trainingEmpDTO.setEmployeeDTO(employeeDTO);

		TrainingDTO trainingDTO = new TrainingDTO();
		trainingDTO.setTrainingName(ahtTraningEmp.getAhtTraining().getTrainingName());
		trainingDTO.setId(ahtTraningEmp.getAhtTraining().getId());
		
		trainingEmpDTO.setTrainingDTO(trainingDTO);
		return trainingEmpDTO;
	}
	
	public static AhtTraningEmp fromTrainingDTOToTrainingEntity(TrainingEmpDTO trainingEmpDTO) {
		ModelMapper modelMapper = new ModelMapper();
		AhtTraningEmp ahtTraningEmp = modelMapper.map(trainingEmpDTO, AhtTraningEmp.class);
		
		AhtDepartment ahtDepartment = new AhtDepartment();
		ahtDepartment.setId(trainingEmpDTO.getEmployeeDTO().getDepartment().getId());
		
		AhtEmployee ahtEmployee = new AhtEmployee();
		ahtEmployee.setAhtDepartment(ahtDepartment);
		ahtEmployee.setId(trainingEmpDTO.getEmployeeDTO().getId());
		ahtTraningEmp.setAhtEmployee(ahtEmployee);
		
		AhtTraining ahtTraining = new AhtTraining();
		ahtTraining.setId(trainingEmpDTO.getTrainingDTO().getId());
		ahtTraningEmp.setAhtTraining(ahtTraining);
		
		return ahtTraningEmp;
	}
	
	public static ContractEmpDTO fromAhtContractEmpToContractEmpDTO(AhtContractEmp ahtContractEmp) {
		ModelMapper modelMapper = new ModelMapper();
		ContractEmpDTO contractEmpDTO = modelMapper.map(ahtContractEmp, ContractEmpDTO.class);
		
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setId(ahtContractEmp.getAhtEmployee().getAhtDepartment().getId());
		departmentDTO.setDepartmentName(ahtContractEmp.getAhtEmployee().getAhtDepartment().getDepartmentName());
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(ahtContractEmp.getAhtEmployee().getId());
		employeeDTO.setEmpName(ahtContractEmp.getAhtEmployee().getEmpName());
		employeeDTO.setDepartment(departmentDTO);
		contractEmpDTO.setEmployeeDTO(employeeDTO);
		
		ContractDTO contractDTO = new ContractDTO();
		contractDTO.setId(ahtContractEmp.getAhtContract().getId());
		contractDTO.setContractCode(ahtContractEmp.getAhtContract().getContractCode());
		contractDTO.setContractType(ahtContractEmp.getAhtContract().getContractType());
		contractEmpDTO.setContractDTO(contractDTO);
		
		return contractEmpDTO;
	}
	
	public static ContractDTO fromAhtContractToContractDTO(AhtContract ahtContract) {
		ModelMapper modelMapper = new ModelMapper();
		ContractDTO contractDTO = modelMapper.map(ahtContract, ContractDTO.class);
		return contractDTO;
	}
	
	public static AhtContractEmp fromContractEmpDTOToAhtContractEmp(ContractEmpDTO contractEmpDTO) {
		ModelMapper modelMapper = new ModelMapper();
		AhtContractEmp ahtContractEmp = modelMapper.map(contractEmpDTO, AhtContractEmp.class);
		
		AhtEmployee ahtEmployee = new AhtEmployee();
		ahtEmployee.setId(contractEmpDTO.getEmployeeDTO().getId());
		ahtContractEmp.setAhtEmployee(ahtEmployee);
		
		AhtContract ahtContract = new AhtContract();
		ahtContract.setId(contractEmpDTO.getContractDTO().getId());
		ahtContractEmp.setAhtContract(ahtContract);
		
		return ahtContractEmp;
	}
	
	public static EmployeeDTO fromAhtEmployeeToEmployeeDTO(AhtEmployee ahtEmployee){
		ModelMapper modelMapper = new ModelMapper();
		
		DepartmentDTO departDTO = new DepartmentDTO();
		departDTO.setId(ahtEmployee.getAhtDepartment().getId());
		departDTO.setDepartmentName(ahtEmployee.getAhtDepartment().getDepartmentName());
				
		EmployeeDTO em = modelMapper.map(ahtEmployee, EmployeeDTO.class);
		em.setDepartment(departDTO);
		return em;
	}
}
