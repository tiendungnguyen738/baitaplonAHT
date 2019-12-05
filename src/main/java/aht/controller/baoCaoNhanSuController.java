package aht.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import aht.dto.EmployeeDTO;
import aht.service.EmployeeService;
import aht.service.impl.ExcelEmployeeListRepost;
import aht.service.impl.PdfEmployeeListRepost;
import aht.util.Convert;

@Controller
public class baoCaoNhanSuController {

	@Autowired
	private EmployeeService employeeService;
	
	//hiển thị danh sách nhân viên trong công ty
	@RequestMapping(value = {"/trang-user/ds-nv-congty/{index}","/trang-user/ds-nv-congty"})
	public ModelAndView dsNhanVienCongTy(@PathVariable(required = false,name="index") Integer index, 
			HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("ds-nhan-vien-cong-ty");
		String typeReport = request.getParameter("type");
		
		List<EmployeeDTO> employeeDTOs = employeeService.layDanhSachNhanVien();
		List<EmployeeDTO> employeeDTOs2 = new ArrayList<EmployeeDTO>();
	
		int soTrang = (employeeDTOs.size()/5 +1);

		mav.addObject("trangSau", Convert.layIndexNext(index, soTrang));
		mav.addObject("trangTruoc", Convert.layIndexPrevious(index, soTrang));
		
		employeeDTOs2 = employeeService.dsNVPhanTrang(Convert.layPageable(index));
		mav.addObject("employeeList", employeeDTOs2);
		
		mav.addObject("soTrang", soTrang);

		if(typeReport != null && typeReport.equals("xlsx")) {
			return new ModelAndView(new ExcelEmployeeListRepost(), "employeeList", employeeDTOs2);
		} else if(typeReport != null && typeReport.equals("pdf")) {
			return new ModelAndView(new PdfEmployeeListRepost() , "employeeList", employeeDTOs2);
		}
		
		return mav;
	}
	
	//danh sách nhân viên thử việc
	@RequestMapping(value= {"/trang-user/ds-nv-thuviec/{index}","/trang-user/ds-nv-thuviec"})
	public ModelAndView dsNhanVienThuViec(@PathVariable(required = false,name="index") Integer index,
			HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("ds-nhan-vien-thu-viec");
		String type = request.getParameter("type");
		
		List<EmployeeDTO> employeeDTOs = employeeService.layDanhSachNhanVien();
		List<EmployeeDTO> employeeDTOs2 = new ArrayList<EmployeeDTO>();
		
		int soTrang = (employeeDTOs.size()/5+1);
		
		mav.addObject("trangSau", Convert.layIndexNext(index, soTrang));
		mav.addObject("trangTruoc", Convert.layIndexPrevious(index, soTrang));
		
		employeeDTOs2 = employeeService.dsNVThuViec(Convert.layPageable(index));
		mav.addObject("employeeList", employeeDTOs2);
		
		if(type != null && type.equals("xlsx")) {
			return new ModelAndView(new ExcelEmployeeListRepost(),"employeeList",employeeDTOs2);
		}else if(type != null && type.equals("pdf")) {
			return new ModelAndView(new PdfEmployeeListRepost(),"employeeList",employeeDTOs2);
		}
		
		mav.addObject("soTrang", soTrang);
		return mav;
	}
	
	//danh sách nhân viên hết hợp đồng
	@RequestMapping(value = {"/trang-user/ds-nhan-vien-het-hop-dong","/trang-user/ds-nhan-vien-het-hop-dong/{index}"})
	public ModelAndView dsNhanVienHetHopDong(@PathVariable(required = false,name="index") int index,
			HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("ds-nhan-vien-het-hop-dong");
		String typeRequest = request.getParameter("type");
		
		List<EmployeeDTO> employeeDTOs = employeeService.layDanhSachNhanVien();
		List<EmployeeDTO> employeeDTOs2 = new ArrayList<EmployeeDTO>();
		
		int soTrang = (employeeDTOs.size()/5+1);
		
		mav.addObject("trangSau", Convert.layIndexNext(index, soTrang));
		mav.addObject("trangTruoc", Convert.layIndexPrevious(index, soTrang));
		
		employeeDTOs2 = employeeService.dsNVHetHopDong(Convert.layPageable(index));
		mav.addObject("employeeList", employeeDTOs2);
		
		if(typeRequest != null && typeRequest.equals("xlsx")) {
			return new ModelAndView(new ExcelEmployeeListRepost(),"employeeList",employeeDTOs2);
		}else if(typeRequest != null && typeRequest.equals("pdf")) {
			return new ModelAndView(new PdfEmployeeListRepost(),"employeeList",employeeDTOs2);
		}
		
		mav.addObject("soTrang", soTrang);
		return mav;
	}
}
