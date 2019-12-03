package aht.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import aht.dto.EmployeeDTO;

public class PdfEmployeeListRepost extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment; filename=\"nhan_vien_cong_ty.pdf\"");
		
		@SuppressWarnings("unchecked")
		List<EmployeeDTO> employeeDTOs = (List<EmployeeDTO>) model.get("employeeList");
		
		Table table = new Table(9);
		table.addCell("Mã Nhân Viên");
		table.addCell("Tên Nhân Viên");
		table.addCell("Ngày Sinh");
		table.addCell("Giới Tính");
		table.addCell("Số Bảo Hiểm");
		table.addCell("Địa Chỉ");
		table.addCell("Điện Thoại");
		table.addCell("Loại Nhân Viên");
		table.addCell("Phòng");
		
		for (EmployeeDTO employeeDTO : employeeDTOs) {
			table.addCell(String.valueOf(employeeDTO.getId()));
			table.addCell(employeeDTO.getEmpName());
			table.addCell(employeeDTO.getEmpDob());
			if(employeeDTO.getEmpSex() == 1) {
				table.addCell("name");
			}else if(employeeDTO.getEmpSex() == 0) {
				table.addCell("nữ");
			}
			table.addCell(employeeDTO.getEmpNumberInsurance());
			table.addCell(employeeDTO.getEmpAddress());
			table.addCell(employeeDTO.getEmpPhone());
			table.addCell(String.valueOf(employeeDTO.getEmpType()));
			table.addCell(employeeDTO.getDepartment().getDepartmentName());
		}	
		document.add(table);
	}
}
