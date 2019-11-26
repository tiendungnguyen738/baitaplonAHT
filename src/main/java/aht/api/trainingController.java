package aht.api;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aht.dto.TrainingDTO;
import aht.entity.AhtTraining;
import aht.service.impl.TrainingServiceImpl;

@CrossOrigin(origins="http://localhost:4200",maxAge=3600)
@RestController
public class trainingController {

	@Autowired
	private TrainingServiceImpl trainingServiceImpl;
	
	@GetMapping("/api/training")
	public List<TrainingDTO> listTrainingDTO(){
		List<TrainingDTO> listTrain = trainingServiceImpl.getAllTrainning();
		return listTrain;
	}
	
	@GetMapping("/api/training/{id}")
	public TrainingDTO getTraining(@PathVariable Long id) {
		AhtTraining training = trainingServiceImpl.getTrainning(id);
		ModelMapper modelMapper = new ModelMapper();
		
		TrainingDTO train = modelMapper.map(training, TrainingDTO.class);
		return train;
	}
	@PostMapping("/api/training")
	public TrainingDTO addTraining(@RequestBody TrainingDTO training) {
		ModelMapper modelMapper = new ModelMapper();
		AhtTraining tra = modelMapper.map(training, AhtTraining.class);
		trainingServiceImpl.addTrainning(tra);
		return training;
	}
	
	@PutMapping("/api/training")
	public void editTraining(@RequestBody TrainingDTO trainingDTO) {
		ModelMapper modelMapper = new ModelMapper();
		AhtTraining train = modelMapper.map(trainingDTO, AhtTraining.class);
		trainingServiceImpl.editTrainning(train);
	}
	
	@DeleteMapping("/api/training/{id}")
	public void deleteTraining(@PathVariable Long id) {
		trainingServiceImpl.deleteTrainning(id);
	}
}
