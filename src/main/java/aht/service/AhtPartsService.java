package aht.service;

import java.util.List;

import aht.entity.AhtParts;

public interface AhtPartsService {

	void themMotBoPhan(AhtParts bophan);
	List<AhtParts> layDanhSachBoPhan();
	void xoaMotBoPhan(Long id);
	AhtParts layTTBoPhan(Long id);
	void capNhatTTBoPhan(AhtParts part);
}
