package aht.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aht.dto.ContractDTO;
import aht.entity.AhtContract;
import aht.service.contractService;

@Controller
@RequestMapping("/api-contract")
public class apiContractController {

	@Autowired
	private contractService contractServiceImpl;
	
	@PostMapping("/xoa-hop-dong")
	@ResponseBody
	public String xoaBoPhan(@RequestParam Long id) {
		contractServiceImpl.xoaHopDong(id);;
		return "true";
	}
	
	@PostMapping("/them-hop-dong")
	@ResponseBody
	public String themHopDong(@RequestParam String mahopdong,@RequestParam int loaihopdong) {
		
		AhtContract conTract = new AhtContract();
		conTract.setContractCode(mahopdong);
		conTract.setContractType(loaihopdong);

		contractServiceImpl.themHopDong(conTract);
		return "true";
	}
	
	@PostMapping("/lay-thong-tin-hop-dong")
	@ResponseBody
	public ContractDTO layTTHopDong(@RequestParam Long id) {
		AhtContract hopDong = contractServiceImpl.layHopDong(id);
		ContractDTO contractDto = new ContractDTO();
		BeanUtils.copyProperties(hopDong, contractDto);
		return contractDto;
	}
	
	@PostMapping("/cap-nhat-hop-dong")
	@ResponseBody
	public String capNhatHopDong(@RequestParam String mahopdong,@RequestParam Long id,@RequestParam int loaihopdong) {
		AhtContract hopDong = new AhtContract();
		hopDong.setId(id);
		hopDong.setContractCode(mahopdong);
		hopDong.setContractType(loaihopdong);
		
		contractServiceImpl.suaHopDong(hopDong);
		return "true";
	}
}
