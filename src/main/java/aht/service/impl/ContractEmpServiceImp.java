package aht.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aht.dto.ContractEmpDTO;
import aht.entity.AhtContractEmp;
import aht.repository.ContractEmpRepository;
import aht.service.ContractEmpService;
import aht.util.Convert;

@Service
public class ContractEmpServiceImp implements ContractEmpService{

	@Autowired
	private ContractEmpRepository contractEmpRepository;
	@Override
	public List<ContractEmpDTO> dsContractEmp() {
		List<AhtContractEmp> ahtContractEmps = contractEmpRepository.findAll();
		List<ContractEmpDTO> contractEmpDTOs = new ArrayList<ContractEmpDTO>();
		
		for (AhtContractEmp ahtContractEmp : ahtContractEmps) {
			ContractEmpDTO contractEmpDTO = Convert.fromAhtContractEmpToContractEmpDTO(ahtContractEmp);
			contractEmpDTOs.add(contractEmpDTO);
		}
		return contractEmpDTOs;
	}
	@Override
	public void themHopDongNV(AhtContractEmp ahtContractEmp) {
		contractEmpRepository.save(ahtContractEmp);
	}
	@Override
	public ContractEmpDTO layMotHopDongNV(Long id) {
		AhtContractEmp ahtContractEmp = contractEmpRepository.findOne(id);
		ContractEmpDTO contractEmpDTO = Convert.fromAhtContractEmpToContractEmpDTO(ahtContractEmp);
		return contractEmpDTO;
	}
	@Override
	public void CapNhatHopDong(AhtContractEmp ahtContractEmp) {
		contractEmpRepository.save(ahtContractEmp);
	}
	@Override
	public void xoaHopDong(Long id) {
		contractEmpRepository.delete(id);
	}

	
}
