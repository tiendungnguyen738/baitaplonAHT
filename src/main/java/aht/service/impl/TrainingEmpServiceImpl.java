package aht.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aht.dto.EmployeeDTO;
import aht.dto.TrainingDTO;
import aht.dto.TrainingEmpDTO;
import aht.entity.AhtTraningEmp;
import aht.repository.TrainingEmpRepository;
import aht.service.TrainingEmpService;

@Service
public class TrainingEmpServiceImpl implements TrainingEmpService{

	@Autowired
	private TrainingEmpRepository trainingEmpRepository;
	
	@Override
	public List<TrainingEmpDTO> dsTrainingEmp() {
		List<AhtTraningEmp> ahtTraningEmps = trainingEmpRepository.findAll();
		ModelMapper modelMapper = new ModelMapper();
		List<TrainingEmpDTO> trainingEmpDTOs = new ArrayList<TrainingEmpDTO>();
		
		for (AhtTraningEmp ahtTraningEmp : ahtTraningEmps) {
			TrainingEmpDTO dto = modelMapper.map(ahtTraningEmp, TrainingEmpDTO.class);
			
			EmployeeDTO employeeDTO = modelMapper.map(ahtTraningEmp.getAhtEmployee(), EmployeeDTO.class);
			TrainingDTO trainingDTO = modelMapper.map(ahtTraningEmp.getAhtTraining(), TrainingDTO.class);
//			EmployeeDTO employeeDTO = new EmployeeDTO();
//			employeeDTO.setId(ahtTraningEmp.getAhtEmployee().getId());
//			employeeDTO.setEmpName(ahtTraningEmp.getAhtEmployee().getEmpName());
//
//			TrainingDTO trainingDTO = new TrainingDTO();
//			trainingDTO.setId(ahtTraningEmp.getAhtTraining().getId());
//			trainingDTO.setTrainingName(ahtTraningEmp.getAhtTraining().getTrainingName());

			dto.setEmployeeDTO(employeeDTO);
			dto.setTrainingDTO(trainingDTO);
			
			trainingEmpDTOs.add(dto);
		}
		return trainingEmpDTOs;
	}

}
