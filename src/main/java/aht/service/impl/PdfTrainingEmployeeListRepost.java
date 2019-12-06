package aht.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import aht.dto.TrainingEmpDTO;

public class PdfTrainingEmployeeListRepost extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"nhan_vien_khoa_dao_tao.pdf\"");
		
		@SuppressWarnings("unchecked")
		List<TrainingEmpDTO> empDTOs  = (List<TrainingEmpDTO>) model.get("employeeList");
		
		Table table = new Table(7);
		table.addCell("Mã Khóa Đào Tạo");
		table.addCell("Tên Nhân Viên");
		table.addCell("Khóa Đào Tạo");
		table.addCell("Ngày Bắt Đầu");
		table.addCell("Ngày Kết Thúc");
		table.addCell("Trạng Thái");
		table.addCell("Kết Quả");
		
		for (TrainingEmpDTO trainingEmpDTO : empDTOs) {
			table.addCell(String.valueOf(trainingEmpDTO.getId()));
			table.addCell(trainingEmpDTO.getEmployeeDTO().getEmpName());
			table.addCell(trainingEmpDTO.getTrainingDTO().getTrainingName());
			table.addCell(trainingEmpDTO.getTrainingEmpStartDate());
			table.addCell(trainingEmpDTO.getTrainingEmpEndDate());
			if(trainingEmpDTO.getTrainingEmpStatus() == 1) {
				table.addCell("Còn Hoạt Động");
			}
			else if(trainingEmpDTO.getTrainingEmpStatus() == 0) {
				table.addCell("Không Hoạt Động");
			}
			table.addCell(trainingEmpDTO.getTrainingEmpResult());
		}
		document.add(table);
		
		
	}

}
