package aht.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		ModelMapper modelMapper = new ModelMapper();
		List<AhtEmployee> listEm = employeeRepository.findAll();
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		
		for (AhtEmployee ahtEmployee : listEm) {				
			EmployeeDTO em = modelMapper.map(ahtEmployee, EmployeeDTO.class);
			employeeDTOs.add(em);
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

	@Override
	public List<EmployeeDTO> dsNVPhanTrang(Pageable pageable) {
		
		Page<AhtEmployee> page = employeeRepository.findAll(pageable);
		List<EmployeeDTO> employeeDTOs2 = new ArrayList<EmployeeDTO>();
		
		for (AhtEmployee employee : page) {
			EmployeeDTO employeeDTO = Convert.fromAhtEmployeeToEmployeeDTO(employee);
			employeeDTOs2.add(employeeDTO);
		}
		return employeeDTOs2;
	}

	@Override
	public List<EmployeeDTO> dsNVThuViec(Pageable pageable) {
	
		Page<AhtEmployee> ahtEmployees = employeeRepository.findAllByEmpType(0,pageable);
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		for (AhtEmployee employee : ahtEmployees) {
			EmployeeDTO employeeDTO = Convert.fromAhtEmployeeToEmployeeDTO(employee);
			employeeDTOs.add(employeeDTO);
		}
		return employeeDTOs;
	}

	@Override
	public List<EmployeeDTO> dsNVHetHopDong(Pageable pageable) {
	//	Page<AhtEmployee> ahtEmployees = employeeRepository.findAllByContractEmpStatus(0, pageable);
	//	List<EmployeeDTO> employeeDTOs = Convert.fromAhtEmployeeListToEmployeeDTOList(ahtEmployees);
		return null;
	}

}
