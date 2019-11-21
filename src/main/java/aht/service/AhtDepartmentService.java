package aht.service;

import java.util.List;

import aht.dto.DepartmentDTO;
import aht.entity.AhtDepartment;
import aht.entity.AhtParts;

public interface AhtDepartmentService {
	
	List<AhtDepartment> dsPhongBanPhanTrang(Integer index);
	int soTrangPhongBan();
	void xoaPhong(Long id);
	void themPhongBan(String tenphong,AhtParts boPhan);
	DepartmentDTO layPhongBanvsChuyenDoi(Long id);
	void suaPhongBan(String phongBanJson);
	AhtDepartment layPhongBan(Long id);
	List<AhtDepartment> dsPhongBan();
}
