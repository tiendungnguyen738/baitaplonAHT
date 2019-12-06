package aht.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import aht.dto.EmployeeDTO;
import aht.dto.TrainingDTO;
import aht.dto.TrainingEmpDTO;
import aht.entity.AhtTraningEmp;
import aht.repository.TrainingEmpRepository;
import aht.service.TrainingEmpService;
import aht.util.Convert;

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

			dto.setEmployeeDTO(employeeDTO);
			dto.setTrainingDTO(trainingDTO);
			
			trainingEmpDTOs.add(dto);
		}
		return trainingEmpDTOs;
	}

	@Override
	public void themKhoaDaoTao(AhtTraningEmp ahtTrainingEmp) {
		trainingEmpRepository.save(ahtTrainingEmp);
	}

	@Override
	public AhtTraningEmp layMotKhoaDaoTao(Long id) {
		return trainingEmpRepository.findOne(id);
	}

	@Override
	public void capNhatKhoaDaoTao(AhtTraningEmp ahtTraningEmp) {
		trainingEmpRepository.save(ahtTraningEmp);
	}

	@Override
	public void xoaKhoaDaoTao(Long id) {
		trainingEmpRepository.delete(id);
	}

	@Override
	public List<TrainingEmpDTO> dsNVKhoaDaoTaoPhanTrang(Pageable pageable) {
		Page<AhtTraningEmp> page = trainingEmpRepository.findAll(pageable);
		List<TrainingEmpDTO> empDTOs = new ArrayList<TrainingEmpDTO>();
		
		for (AhtTraningEmp ahtTraningEmp : page) {
			TrainingEmpDTO dto = Convert.fromTrainingEntityToTrainingDTO(ahtTraningEmp);
			empDTOs.add(dto);
		}
		return empDTOs;
	}

}
