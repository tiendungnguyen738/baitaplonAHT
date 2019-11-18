package aht.service;

import java.util.List;

import aht.entity.AhtContract;

public interface contractService {

	List<AhtContract> dsHopDong(Integer index);
	int soTrangHopDong();
	void xoaHopDong(Long id);
	void themHopDong(AhtContract hopDong);
	AhtContract layHopDong(Long id);
	void suaHopDong(AhtContract hopDong);
}
