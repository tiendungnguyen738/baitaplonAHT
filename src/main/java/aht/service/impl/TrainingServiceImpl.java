package aht.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aht.dto.TrainingDTO;
import aht.entity.AhtTraining;
import aht.repository.TrainingRepository;
import aht.service.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService{
	
	@Autowired
	private TrainingRepository trainningRepository;

	@Override
	public AhtTraining getTrainning(Long id) {
		return trainningRepository.findOne(id);
	}

	@Override
	public List<TrainingDTO> getAllTrainning() {
		List<AhtTraining> listTrain = trainningRepository.findAll();
		List<TrainingDTO> listTrainDTO = new ArrayList<TrainingDTO>();
		ModelMapper modelMapper = new ModelMapper();
		for (AhtTraining ahtTrainning : listTrain) {
			TrainingDTO trainning = modelMapper.map(ahtTrainning, TrainingDTO.class);
			listTrainDTO.add(trainning);
		}
		return listTrainDTO;
	}

	@Override
	public void addTrainning(AhtTraining trainning) {
		trainningRepository.save(trainning);
	}

	@Override
	public void editTrainning(AhtTraining trainning) {
		trainningRepository.save(trainning);
	}

	@Override
	public void deleteTrainning(Long id) {
		trainningRepository.delete(id);
	}
}
