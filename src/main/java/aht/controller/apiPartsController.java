package aht.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aht.dto.PartDTO;
import aht.entity.AhtParts;
import aht.service.AhtPartsService;

@Controller
@RequestMapping("/api-parts")
public class apiPartsController {

	@Autowired
	private AhtPartsService ahtPartsServiceImpl;
	
	@PostMapping("/xoa-bo-phan")
	@ResponseBody
	public String xoaBoPhan(@RequestParam Long id) {
		ahtPartsServiceImpl.xoaMotBoPhan(id);
		return "true";
	}
	
	@PostMapping("/them-bo-phan")
	@ResponseBody
	public String themBoPhan(@RequestParam String tenbophan) {
		
		AhtParts part = new AhtParts();
		part.setPartsName(tenbophan);

		ahtPartsServiceImpl.themMotBoPhan(part);
		return "true";
	}
	
	@PostMapping("/lay-thong-tin-bo-phan")
	@ResponseBody
	public PartDTO layTTBoPhan(@RequestParam Long id) {
		AhtParts part = ahtPartsServiceImpl.layTTBoPhan(id);
		
		PartDTO partDto = new PartDTO();
		partDto.setId(part.getId());
		partDto.setPartsName(part.getPartsName());
		
		return partDto;
	}
	
	@PostMapping("/cap-nhat-bo-phan")
	@ResponseBody
	public PartDTO capNhatBoPhan(@RequestParam String tenbophan,@RequestParam Long id) {
		AhtParts part = new AhtParts();
		part.setId(id);
		part.setPartsName(tenbophan);
		
		ahtPartsServiceImpl.capNhatTTBoPhan(part);
		
		PartDTO partDto = new PartDTO();
		BeanUtils.copyProperties(part, partDto);
		return partDto;
	}
}
