package aht.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import aht.dto.EmployeeDTO;

public class ExcelEmployeeListRepost extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"nhan_vien_cong_ty.xlsx\"");
		
		@SuppressWarnings("unchecked")
		List<EmployeeDTO> employeeDTOs = (List<EmployeeDTO>) model.get("employeeList");
		Sheet sheet = workbook.createSheet("Nhân Viên");
		
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Mã Nhân Viên");
		header.createCell(1).setCellValue("Tên Nhân Viên");
		header.createCell(2).setCellValue("Ngày Sinh");
		header.createCell(3).setCellValue("Giới Tính");
		header.createCell(4).setCellValue("Số Bảo Hiểm");
		header.createCell(5).setCellValue("Địa Chỉ");
		header.createCell(6).setCellValue("Điện Thoại");
		header.createCell(7).setCellValue("Loại Nhân Viên");
		header.createCell(8).setCellValue("Phòng");
		
		int rowNum = 1;
		for (EmployeeDTO employee : employeeDTOs) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(employee.getId());
			row.createCell(1).setCellValue(employee.getEmpName());
			row.createCell(2).setCellValue(employee.getEmpDob());
			if(employee.getEmpSex() == 1) {
				row.createCell(3).setCellValue("nam");
			}else if(employee.getEmpSex() == 0) {
				row.createCell(3).setCellValue("nữ");
			}
			row.createCell(4).setCellValue(employee.getEmpNumberInsurance());
			row.createCell(5).setCellValue(employee.getEmpAddress());
			row.createCell(6).setCellValue(employee.getEmpPhone());
			row.createCell(7).setCellValue(employee.getEmpType());
			row.createCell(8).setCellValue(employee.getDepartment().getDepartmentName());
		}
	}

}
