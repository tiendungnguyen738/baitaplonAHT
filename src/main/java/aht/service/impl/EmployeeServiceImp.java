package aht.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aht.dto.EmployeeDTO;
import aht.entity.AhtEmployee;
import aht.repository.EmployeeRepository;
import aht.service.EmployeeService;
import aht.util.Convert;

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
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		
		for (AhtEmployee ahtEmployee : listEm) {
			EmployeeDTO employeeDTO = Convert.fromAhtEmployeeToEmployeeDTO(ahtEmployee);
			employeeDTOs.add(employeeDTO);
		}
		return employeeDTOs;
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

	@Override
	public List<AhtEmployee> getEmployeeByDepartmentId(Long departmentId) {
		return employeeRepository.getEmployeeByDepartmentId(departmentId);
	}

}
