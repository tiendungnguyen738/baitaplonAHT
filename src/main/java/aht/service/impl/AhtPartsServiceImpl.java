package aht.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aht.entity.AhtParts;
import aht.repository.AhtPartsRepository;
import aht.service.AhtPartsService;

@Service
public class AhtPartsServiceImpl implements AhtPartsService{

	@Autowired
	private AhtPartsRepository ahtPartsRepository;  
	
	@Override
	public List<AhtParts> layDanhSachBoPhan() {
		return ahtPartsRepository.findAll();
	}

	@Override
	public void xoaMotBoPhan(Long id) {
		ahtPartsRepository.delete(id);
	}

	@Override
	public void themMotBoPhan(AhtParts bophan) {
		 ahtPartsRepository.save(bophan);
	}

	@Override
	public AhtParts layTTBoPhan(Long id) {
		return ahtPartsRepository.findOne(id);
	}

	@Override
	public void capNhatTTBoPhan(AhtParts part) {
		ahtPartsRepository.save(part);
	}

}
