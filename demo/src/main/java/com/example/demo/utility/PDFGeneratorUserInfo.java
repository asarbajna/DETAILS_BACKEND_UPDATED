package com.example.demo.utility;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.entity.UserRegistration;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import lombok.Setter;

@Setter
public class PDFGeneratorUserInfo {
	
	private List<UserRegistration> userInfo;
	
	 
    public void setUserInfo(List<UserRegistration> userInfo) {
        this.userInfo = userInfo;
    }
	
	public void generate(HttpServletResponse response) throws DocumentException, IOException{
		
		// Create the Object of Document
		  Document document = new Document(PageSize.A4);
		  
		// get the document and write the response to output stream
		  PdfWriter.getInstance(document, response.getOutputStream());
		  document.open();
		  
		// Add Font
		  Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		  fontTiltle.setSize(20);
		  
		// Create Object of Paragraph
		  Paragraph paragraph = new Paragraph("User List", fontTiltle);
		  paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		  
		// Add to the document
		  document.add(paragraph);
		  
		  PdfPTable table = new PdfPTable(3);
		  table.setWidthPercentage(100f);
		  table.setWidths(new int[] { 1, 1, 5 });
		  table.setSpacingBefore(3);
		  
		// Create Table Header
		  PdfPCell cell = new PdfPCell();
		  cell.setBackgroundColor(Color.BLUE);
		  cell.setPadding(5);
		  
		// Add Font
		  Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		  font.setColor(Color.WHITE);
		  
		  cell.setPhrase(new Phrase("FIRST NAME", font));
		  table.addCell(cell);
		  
		  cell.setPhrase(new Phrase("LAST NAME", font));
		  table.addCell(cell);
		  cell.setPhrase(new Phrase("EMAIL ID", font));
		  table.addCell(cell);
		  
		  for (UserRegistration user : userInfo) {
		   //table.addCell(String.valueOf(user.getUserId()));
		   table.addCell(user.getFirstName());
		   table.addCell(user.getLastName());
		   table.addCell(user.getEmail());
		  
		  
		  }
		  document.add(table);
		  document.close();
	}
	
}
