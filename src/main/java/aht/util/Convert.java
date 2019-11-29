package aht.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import aht.dto.DepartmentDTO;
import aht.dto.EmployeeDTO;
import aht.dto.TrainingDTO;
import aht.dto.TrainingEmpDTO;
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
}
