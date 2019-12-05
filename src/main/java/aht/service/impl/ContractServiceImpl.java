package aht.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import aht.dto.ContractDTO;
import aht.entity.AhtContract;
import aht.repository.ContractRepository;
import aht.service.contractService;
import aht.util.Convert;

@Service
public class ContractServiceImpl implements contractService{

	@Autowired
	private ContractRepository contractRepository;
	
	@Override
	public List<AhtContract> dsHopDong(Integer index) {
		Pageable pageable = new PageRequest(0,4);
		if(index == null) {
			pageable = new PageRequest(0, 4);
		}
		else {
			pageable = new PageRequest((index-1), 4);
		}
		Page<AhtContract> dsHopDong =  contractRepository.findAll(pageable);
		List<AhtContract> dsHopDong1 = new ArrayList<AhtContract>();
		
		for (AhtContract hopdong : dsHopDong) {
			dsHopDong1.add(hopdong);
		}
		
		return dsHopDong1;
	}

	@Override
	public int soTrangHopDong() {
		int tongHopDong = contractRepository.tongSoHopDong();
		int soTrangHopDong;
		if(tongHopDong % 4 == 0){
			soTrangHopDong = tongHopDong % 4;
		}
		else {
			soTrangHopDong = (tongHopDong/4)+1;
		}
		
		return soTrangHopDong;
	}

	@Override
	public void xoaHopDong(Long id) {
		contractRepository.delete(id);
	}

	@Override
	public void themHopDong(AhtContract hopDong) {
		 contractRepository.save(hopDong);
	}

	@Override
	public AhtContract layHopDong(Long id) {
		return contractRepository.findOne(id);
	}

	@Override
	public void suaHopDong(AhtContract hopDong) {
		contractRepository.save(hopDong);
	}

	@Override
	public List<ContractDTO> dsHopDongDTO() {
		ModelMapper modelMapper = new ModelMapper();
		List<AhtContract> ahtContracts = contractRepository.findAll();
		List<ContractDTO> contractDTOs = new ArrayList<ContractDTO>();
		
		for (AhtContract ahtContract : ahtContracts) {
			
			ContractDTO contractDTO = new ContractDTO();
			contractDTO.setId(ahtContract.getId());
			contractDTO.setContractCode(ahtContract.getContractCode());
			contractDTO.setContractType(ahtContract.getContractType());
			contractDTOs.add(contractDTO);
		}
		return contractDTOs;
	}

}
