package aht.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aht.dto.EmployeeDTO;
import aht.entity.AhtDepartment;
import aht.entity.AhtEmployee;
import aht.repository.EmployeeRepository;
import aht.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public AhtEmployee layMotNhanVien(Long id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public List<EmployeeDTO> layDanhSachNhanVien() {
		List<AhtEmployee> listEm = employeeRepository.findAll();
		List<EmployeeDTO> listEmp = new ArrayList<EmployeeDTO>();
		ModelMapper modelMapper = new ModelMapper();
		for (AhtEmployee ahtEmployee : listEm) {
				
				AhtDepartment depart = new AhtDepartment();
				depart.setId(ahtEmployee.getAhtDepartment().getId());
				depart.setDepartmentName(ahtEmployee.getAhtDepartment().getDepartmentName());
				ahtEmployee.setAhtDepartment(depart);
				
				EmployeeDTO em = modelMapper.map(ahtEmployee, EmployeeDTO.class);
				listEmp.add(em);
		}
		return listEmp;
	}

	@Override
	public void themNhanVien(AhtEmployee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void suaNhanVien(AhtEmployee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void xoaNhanVien(Long id) {
		employeeRepository.delete(id);
	}

}
