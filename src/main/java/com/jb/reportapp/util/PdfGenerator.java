package com.jb.reportapp.util;

import com.jb.reportapp.entity.CitizenPlan;
import jakarta.servlet.http.HttpServletResponse;
import org.openpdf.text.*;
import org.openpdf.text.Font;
import org.openpdf.text.pdf.PdfPCell;
import org.openpdf.text.pdf.PdfPTable;
import org.openpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;

@Component
public class PdfGenerator {

    public void generatePdf(HttpServletResponse response, List<CitizenPlan> plans) throws Exception {

        // Setting response headers
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=citizen_report.pdf");

        // Enabeling Landscape mode
        Document document = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);

        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        // Changing Title Font
        Font titleFont = new Font(Font.HELVETICA, 18, Font.BOLD);
        Paragraph title = new Paragraph("Citizen Report", titleFont);
        title.setAlignment(org.openpdf.text.Element.ALIGN_CENTER);
        title.setSpacingAfter(15);
        document.add(title);

        // Table (FIXED column count = 11)
        PdfPTable table = new PdfPTable(11);
        table.setWidthPercentage(100);

        // Optional: Set column widths
        table.setWidths(new float[]{2, 3, 3, 2, 2, 3, 3, 3, 4, 4, 3});

        // Header Style
        Font headerFont = new Font(Font.HELVETICA, 10, Font.BOLD, Color.WHITE);

        String[] headers = {
                "Citizen ID", "Name", "Plan Name", "Status", "Gender",
                "Start Date", "End Date", "Termination Date",
                "Termination Reason", "Denial Reason", "Benefit Amount"
        };

        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
            cell.setBackgroundColor(Color.DARK_GRAY);
            cell.setPadding(5);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }

        // ✅ Data Style
        Font bodyFont = new Font(Font.HELVETICA, 9, Font.NORMAL);

        List<CitizenPlan> records = plans;

        for (CitizenPlan record : records) {

            table.addCell(new PdfPCell(new Phrase(String.valueOf(record.getCitizenId()), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(record.getCitizenName(), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(record.getPlanName(), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(record.getPlanStatus(), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(record.getGender(), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(record.getPlanStartDate()), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(record.getPlanEndDate()), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(record.getTerminationDate()), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(record.getTerminationReason(), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(record.getDenialReason(), bodyFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(record.getBenefitAmount()), bodyFont)));
        }

        document.add(table);
        document.close();
    }
}
