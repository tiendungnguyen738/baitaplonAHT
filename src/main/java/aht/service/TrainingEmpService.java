package aht.service;

import java.util.List;

import aht.dto.TrainingEmpDTO;
import aht.entity.AhtTraningEmp;

public interface TrainingEmpService {
	List<TrainingEmpDTO> dsTrainingEmp();
	void themKhoaDaoTao(AhtTraningEmp ahtTrainingEmp);
	AhtTraningEmp layMotKhoaDaoTao(Long id);
	void capNhatKhoaDaoTao(AhtTraningEmp ahtTraningEmp);
	void xoaKhoaDaoTao(Long id);
}
