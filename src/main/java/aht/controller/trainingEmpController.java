package aht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import aht.dto.TrainingEmpDTO;
import aht.service.impl.TrainingEmpServiceImpl;

@Controller
public class trainingEmpController {

	@Autowired
	private TrainingEmpServiceImpl trainingEmpServiceImpl;
	
	@GetMapping(path= {"/trang-user/quan-ly-training-emp"})
	public ModelAndView trangTrainingEmp() {
		List<TrainingEmpDTO> trainingEmpDTOs = trainingEmpServiceImpl.dsTrainingEmp();
		ModelAndView mav = new ModelAndView("quan-ly-khoa-dao-tao");
		mav.addObject("listTraining", trainingEmpDTOs);
		return mav;
	}
}
