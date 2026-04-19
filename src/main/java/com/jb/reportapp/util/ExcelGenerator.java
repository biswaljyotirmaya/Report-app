package com.jb.reportapp.util;

import com.jb.reportapp.entity.CitizenPlan;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

@Component
public class ExcelGenerator {

    @Autowired
    private EmailUtils emailUtils ;

    public void generateExcel(HttpServletResponse response,
                              List<CitizenPlan> records,
                              File file) throws Exception {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Plans Report");

        // ===== HEADER STYLE =====
        CellStyle headerStyle = workbook.createCellStyle();
        org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);

        headerStyle.setFont(headerFont);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);

        // ===== DATA STYLE =====
        CellStyle dataStyle = workbook.createCellStyle();
        dataStyle.setBorderTop(BorderStyle.THIN);
        dataStyle.setBorderBottom(BorderStyle.THIN);
        dataStyle.setBorderLeft(BorderStyle.THIN);
        dataStyle.setBorderRight(BorderStyle.THIN);

        // ===== DATE STYLE =====
        CellStyle dateStyle = workbook.createCellStyle();
        CreationHelper helper = workbook.getCreationHelper();
        dateStyle.setDataFormat(helper.createDataFormat().getFormat("dd-MM-yyyy"));
        dateStyle.cloneStyleFrom(dataStyle);

        // ===== HEADER ROW =====
        Row header = sheet.createRow(0);
        String[] columns = {
                "Citizen Id","Name","Plan Name","Status","Gender",
                "Start Date","End Date","Termination Date",
                "Termination Reason","Denial Reason","Benefit Amount"
        };

        for (int i = 0; i < columns.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerStyle);
        }

        // ===== DATA =====
        int rowNum = 1;
        for (CitizenPlan record : records) {
            Row row = sheet.createRow(rowNum++);

            setCell(row, 0, record.getCitizenId(), dataStyle);
            setCell(row, 1, record.getCitizenName(), dataStyle);
            setCell(row, 2, record.getPlanName(), dataStyle);
            setCell(row, 3, record.getPlanStatus(), dataStyle);
            setCell(row, 4, record.getGender(), dataStyle);

            setDateCell(row, 5, record.getPlanStartDate(), dateStyle);
            setDateCell(row, 6, record.getPlanEndDate(), dateStyle);
            setDateCell(row, 7, record.getTerminationDate(), dateStyle);

            setCell(row, 8, record.getTerminationReason(), dataStyle);
            setCell(row, 9, record.getDenialReason(), dataStyle);
            setCell(row, 10, record.getBenefitAmount(), dataStyle);
        }

        // ===== AUTO SIZE =====
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // ==============================
        // 1. WRITE TO FILE
        // ==============================
        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        }

        // ==============================
        // 2. WRITE TO RESPONSE (ONCE)
        // ==============================
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=report.xlsx");

        try (ServletOutputStream os = response.getOutputStream()) {
            workbook.write(os);
            os.flush();
        }

        // ==============================
        // 3. CLOSE WORKBOOK (LAST)
        // ==============================
        workbook.close();

        // ==============================
        // 4. SEND EMAIL
        // ==============================
        String subject = "This is a test mail";
        String body = "This mail is sent for the <b>trial</b> purpose<br>"
                + "<h3>This mail is sent from the report generation application.</h3>";
        String to = "davidbiswal06@gmail.com";

        emailUtils.sendEmail(to, subject, body, file);

        // ==============================
        //5. DELETE TEMP FILE
        // ==============================
        file.delete();
    }
    private void setCell(Row row, int col, Object value, CellStyle style) {
        Cell cell = row.createCell(col);

        if (value == null) {
            cell.setCellValue("N/A");
        } else if (value instanceof Number) {
            cell.setCellValue(((Number) value).doubleValue());
        } else {
            cell.setCellValue(value.toString());
        }

        cell.setCellStyle(style);
    }

    private void setDateCell(Row row, int col, LocalDate date, CellStyle style) {
        Cell cell = row.createCell(col);

        if (date == null) {
            cell.setCellValue("N/A");
        } else {
            cell.setCellValue(java.sql.Date.valueOf(date));
            cell.setCellStyle(style);
        }
    }
}