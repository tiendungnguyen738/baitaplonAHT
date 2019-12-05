package aht.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import aht.dto.DepartmentDTO;
import aht.dto.PartDTO;
import aht.entity.AhtDepartment;
import aht.entity.AhtParts;
import aht.repository.AhtDepartMentRepository;
import aht.service.AhtDepartmentService;
import aht.util.Convert;

@Service
public class AhtDepartmentServiceImpl implements AhtDepartmentService{

	@Autowired
	private AhtDepartMentRepository ahtDepartMentRepository;
	
	@Override
	public List<AhtDepartment> dsPhongBanPhanTrang(Integer index) {
		Pageable pageable = new PageRequest(0,4);
		if(index == null) {
			pageable = new PageRequest(0, 4);
		}
		else {
			pageable = new PageRequest((index-1), 4);
		}
		Page<AhtDepartment> dsPhongBan =  ahtDepartMentRepository.findAll(pageable);
		List<AhtDepartment> dsPhongBan1 = new ArrayList<AhtDepartment>();
		
		for (AhtDepartment phongban : dsPhongBan) {
			dsPhongBan1.add(phongban);
		}
		
		return dsPhongBan1;
	}

	@Override
	public int soTrangPhongBan() {
		int tongPhongBan = ahtDepartMentRepository.tongSoPhongBan();
		int soTrangPhongBan;
		if(tongPhongBan % 4 == 0){
			soTrangPhongBan = tongPhongBan % 4;
		}
		else {
			soTrangPhongBan = (tongPhongBan/4)+1;
		}
		
		return soTrangPhongBan;
	}

	@Override
	public void xoaPhong(Long id) {
		ahtDepartMentRepository.delete(id);
	}

	@Override
	public void themPhongBan(String tenphong,AhtParts boPhan) {
		  AhtDepartment phongBan = new AhtDepartment();
		  phongBan.setDepartmentName(tenphong);
		  phongBan.setAhtParts(boPhan);
		  ahtDepartMentRepository.save(phongBan);
	}

	@Override
	public DepartmentDTO layPhongBanvsChuyenDoi(Long id) {
			AhtDepartment phong =  ahtDepartMentRepository.findOne(id);
			
			DepartmentDTO phongBan = Convert.fromAhtDepartmentToDepartmentDTO(phong);
			PartDTO partDTO = Convert.fromAhtPartToPartDTO(phong.getAhtParts());
			phongBan.setPartDTO(partDTO);
			return phongBan;
	}

	@Override
	public void suaPhongBan(String phongBanJson) {
		 ObjectMapper mapper = new ObjectMapper();
		 AhtDepartment phongBan = new AhtDepartment();
		  
		try {
			JsonNode JsonphongBan = mapper.readTree(phongBanJson);
		
			AhtParts boPhan = new AhtParts();
			boPhan.setId(JsonphongBan.get("ahtParts").asLong());
			
			phongBan.setId(JsonphongBan.get("id").asLong());
			phongBan.setDepartmentName(JsonphongBan.get("departmentName").asText());
			phongBan.setAhtParts(boPhan);
			
			ahtDepartMentRepository.save(phongBan);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public AhtDepartment layPhongBan(Long id) {
		return ahtDepartMentRepository.findOne(id);
	}

	@Override
	public List<DepartmentDTO> dsPhongBan() {
		List<DepartmentDTO> departmentDTOs = new ArrayList<DepartmentDTO>();
		List<AhtDepartment> ahtDepartments = ahtDepartMentRepository.findAll();
		for (AhtDepartment ahtDepartment : ahtDepartments) {
			
			DepartmentDTO departmentDTO  = Convert.fromAhtDepartmentToDepartmentDTO(ahtDepartment);
			departmentDTOs.add(departmentDTO);
		}
		return departmentDTOs;
	}

}
