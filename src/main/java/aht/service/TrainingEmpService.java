package aht.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import aht.dto.TrainingEmpDTO;
import aht.entity.AhtTraningEmp;

public interface TrainingEmpService {
	List<TrainingEmpDTO> dsTrainingEmp();
	void themKhoaDaoTao(AhtTraningEmp ahtTrainingEmp);
	AhtTraningEmp layMotKhoaDaoTao(Long id);
	void capNhatKhoaDaoTao(AhtTraningEmp ahtTraningEmp);
	void xoaKhoaDaoTao(Long id);
	
	List<TrainingEmpDTO> dsNVKhoaDaoTaoPhanTrang(Pageable pageable);
}
