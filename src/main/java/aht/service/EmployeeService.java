package aht.service;

import java.util.List;

import aht.dto.EmployeeDTO;
import aht.entity.AhtEmployee;

public interface EmployeeService {

	AhtEmployee layMotNhanVien(Long id);
	List<EmployeeDTO> layDanhSachNhanVien();
	void themNhanVien(AhtEmployee employee);
	void suaNhanVien(AhtEmployee employee);
	void xoaNhanVien(Long id);
	List<AhtEmployee> getEmployeeByDepartmentId(Long departmentId);
}
