/*    */ package BOOT-INF.classes.com.datn.dongho5s.Export;
/*    */ import com.datn.dongho5s.Entity.NhanVien;
/*    */ import com.lowagie.text.Document;
/*    */ import com.lowagie.text.Element;
/*    */ import com.lowagie.text.Font;
/*    */ import com.lowagie.text.Paragraph;
/*    */ import com.lowagie.text.Phrase;
/*    */ import com.lowagie.text.pdf.PdfPCell;
/*    */ import com.lowagie.text.pdf.PdfPTable;
/*    */ import java.awt.Color;
/*    */ import java.io.OutputStream;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class NhanVienPdfExporter extends AbstractExporter {
/*    */   public void export(List<NhanVien> listNhanVien, HttpServletResponse response) throws IOException {
/* 17 */     setResponseHeader(response, "application/pdf", ".pdf", "users_");
/* 18 */     Document document = new Document(PageSize.A4);
/* 19 */     PdfWriter.getInstance(document, (OutputStream)response.getOutputStream());
/*    */     
/* 21 */     document.open();
/* 22 */     Font font = new Font(1, 18.0F, 2);
/* 23 */     Paragraph paragraph = new Paragraph("Danh Sach Nhan Vien", font);
/* 24 */     paragraph.setAlignment(1);
/*    */     
/* 26 */     document.add((Element)paragraph);
/* 27 */     PdfPTable table = new PdfPTable(8);
/* 28 */     table.setWidthPercentage(100.0F);
/* 29 */     table.setSpacingBefore(10.0F);
/* 30 */     table.setWidths(new float[] { 1.2F, 3.5F, 3.0F, 3.0F, 1.7F, 1.5F, 2.0F, 1.5F });
/*    */     
/* 32 */     writeTableHeader(table);
/* 33 */     writeTableData(table, listNhanVien);
/*    */     
/* 35 */     document.add((Element)table);
/* 36 */     document.close();
/*    */   }
/*    */   
/*    */   private void writeTableData(PdfPTable table, List<NhanVien> listNhanVien) {
/* 40 */     for (NhanVien nhanVien : listNhanVien) {
/* 41 */       table.addCell(String.valueOf(nhanVien.getId()));
/* 42 */       table.addCell(nhanVien.getDiaChi());
/* 43 */       table.addCell(nhanVien.getEmail());
/* 44 */       table.addCell(nhanVien.getHo());
/* 45 */       table.addCell(nhanVien.getTen());
/* 46 */       table.addCell(String.valueOf(nhanVien.getSoDienThoai()));
/*    */       
/* 48 */       table.addCell(String.valueOf(nhanVien.isEnabled()));
/*    */     } 
/*    */   }
/*    */   
/*    */   private void writeTableHeader(PdfPTable table) {
/* 53 */     PdfPCell cell = new PdfPCell();
/* 54 */     cell.setBackgroundColor(Color.BLUE);
/* 55 */     cell.setPadding(5.0F);
/*    */     
/* 57 */     Font font = new Font(1, 10.0F, 2);
/* 58 */     cell.setPhrase(new Phrase("ID", font));
/* 59 */     table.addCell(cell);
/* 60 */     cell.setPhrase(new Phrase("Address", font));
/* 61 */     table.addCell(cell);
/* 62 */     cell.setPhrase(new Phrase("E-mail", font));
/* 63 */     table.addCell(cell);
/* 64 */     cell.setPhrase(new Phrase("LastName", font));
/* 65 */     table.addCell(cell);
/* 66 */     cell.setPhrase(new Phrase("FirstName", font));
/* 67 */     table.addCell(cell);
/* 68 */     cell.setPhrase(new Phrase("Phone", font));
/* 69 */     table.addCell(cell);
/* 70 */     cell.setPhrase(new Phrase("Roles", font));
/* 71 */     table.addCell(cell);
/* 72 */     cell.setPhrase(new Phrase("Enabled", font));
/* 73 */     table.addCell(cell);
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Export\NhanVienPdfExporter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */