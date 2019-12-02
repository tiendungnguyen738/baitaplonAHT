package aht.service;

import java.util.List;

import aht.dto.ContractEmpDTO;
import aht.entity.AhtContractEmp;

public interface ContractEmpService {
	List<ContractEmpDTO> dsContractEmp();
	void themHopDongNV(AhtContractEmp ahtContractEmp);
	ContractEmpDTO layMotHopDongNV(Long id);
	void CapNhatHopDong(AhtContractEmp ahtContractEmp);
	void xoaHopDong(Long id);
}
