package aht.service;

import java.util.List;

import aht.dto.TrainingEmpDTO;
import aht.entity.AhtTraningEmp;

public interface TrainingEmpService {
	List<TrainingEmpDTO> dsTrainingEmp();
	void themKhoaDaoTao(AhtTraningEmp ahtTrainingEmp);
}
