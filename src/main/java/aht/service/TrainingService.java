package aht.service;

import java.util.List;

import aht.dto.TrainingDTO;
import aht.entity.AhtTraining;

public interface TrainingService {

	AhtTraining getTrainning(Long id);
	List<TrainingDTO> getAllTrainning();
	void addTrainning(AhtTraining trainning);
	void editTrainning(AhtTraining trainning);
	void deleteTrainning(Long id);
}
