package aht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aht.dto.DepartmentDTO;
import aht.entity.AhtParts;
import aht.service.AhtDepartmentService;
import aht.service.AhtPartsService;

@Controller
@RequestMapping("/api-department")
public class apiDepartmentController {

	  @Autowired 
	  private AhtDepartmentService ahtDepartmentServiceImpl;
	  
	  @Autowired
	  private AhtPartsService ahtPartsServiceImpl;
	  
	  @PostMapping("/xoa-phong-ban") 
	  @ResponseBody 
	  public String xoaBoPhan(@RequestParam Long id) {
		  ahtDepartmentServiceImpl.xoaPhong(id); 
		  return "true"; 
	  }
	  
	  @PostMapping("/them-phong-ban") 
	  @ResponseBody 
	  public String themBoPhan(@RequestParam String tenphong, @RequestParam Long idBoPhan) {
		  AhtParts boPhan = ahtPartsServiceImpl.layTTBoPhan(idBoPhan);
		  ahtDepartmentServiceImpl.themPhongBan(tenphong,boPhan);
		  return "true"; 
	  }

	  @GetMapping("/lay-thong-tin-phong-ban")
	  @ResponseBody
	  public DepartmentDTO layTTPhongBan(@RequestParam Long id) {
		return ahtDepartmentServiceImpl.layPhongBanvsChuyenDoi(id);
	  }
	  
	  @PostMapping("/cap-nhat-phong-ban")
	  @ResponseBody
	  public String capNhatPhongBan(@RequestParam String phongBanJson) {
		  ahtDepartmentServiceImpl.suaPhongBan(phongBanJson);
		  return "true";
	  }
	
}
