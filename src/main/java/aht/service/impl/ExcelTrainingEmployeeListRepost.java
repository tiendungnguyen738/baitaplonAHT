package aht.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import aht.dto.TrainingEmpDTO;

public class ExcelTrainingEmployeeListRepost extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"nhan_vien_cong_ty.xlsx\"");
		
		@SuppressWarnings("unchecked")
		List<TrainingEmpDTO> trainingEmpList = (List<TrainingEmpDTO>) model.get("employeeList");
		
		Sheet sheet = workbook.createSheet("Nhân Viên");
		
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Mã Khóa Đào Tạo");
		header.createCell(1).setCellValue("Tên Nhân Viên");
		header.createCell(2).setCellValue("Khóa Đào Tạo");
		header.createCell(3).setCellValue("Ngày Bắt Đầu");
		header.createCell(4).setCellValue("Ngày Kết Thúc");
		header.createCell(5).setCellValue("Trạng Thái");
		header.createCell(6).setCellValue("Kết Quả");
		
		int rowNum = 1;
		for (TrainingEmpDTO emp : trainingEmpList) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(emp.getId());
			row.createCell(1).setCellValue(emp.getEmployeeDTO().getEmpName());
			row.createCell(2).setCellValue(emp.getTrainingDTO().getTrainingName());
			row.createCell(3).setCellValue(emp.getTrainingEmpStartDate());
			row.createCell(4).setCellValue(emp.getTrainingEmpEndDate());
			if(emp.getTrainingEmpStatus() == 1) {
				row.createCell(5).setCellValue("Còn Hoạt Động");
			}
			else if(emp.getTrainingEmpStatus() == 0) {
				row.createCell(5).setCellValue("Không Hoạt Động");
			}
			row.createCell(6).setCellValue(emp.getTrainingEmpResult());
		}
		
	}

}
