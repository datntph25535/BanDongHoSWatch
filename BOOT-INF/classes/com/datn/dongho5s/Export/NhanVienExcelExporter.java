/*    */ package BOOT-INF.classes.com.datn.dongho5s.Export;
/*    */ import com.datn.dongho5s.Entity.NhanVien;
/*    */ import com.datn.dongho5s.Export.AbstractExporter;
/*    */ import java.io.OutputStream;
/*    */ import java.util.List;
/*    */ import javax.servlet.ServletOutputStream;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.poi.ss.usermodel.Cell;
/*    */ import org.apache.poi.ss.usermodel.CellStyle;
/*    */ import org.apache.poi.ss.usermodel.Font;
/*    */ import org.apache.poi.ss.usermodel.Row;
/*    */ import org.apache.poi.ss.usermodel.Sheet;
/*    */ import org.apache.poi.xssf.usermodel.XSSFCellStyle;
/*    */ import org.apache.poi.xssf.usermodel.XSSFFont;
/*    */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*    */ 
/*    */ public class NhanVienExcelExporter extends AbstractExporter {
/* 18 */   private XSSFWorkbook workbook = new XSSFWorkbook();
/*    */   private Sheet sheet;
/*    */   
/*    */   private void writeHeaderLine() {
/* 22 */     this.sheet = (Sheet)this.workbook.createSheet("NhanVien");
/* 23 */     Row row = this.sheet.createRow(0);
/*    */     
/* 25 */     XSSFCellStyle xSSFCellStyle = this.workbook.createCellStyle();
/* 26 */     XSSFFont xSSFFont = this.workbook.createFont();
/* 27 */     xSSFFont.setBold(true);
/* 28 */     xSSFFont.setFontHeightInPoints((short)16);
/* 29 */     xSSFCellStyle.setFont((Font)xSSFFont);
/*    */     
/* 31 */     createCell(row, 0, "User ID", (CellStyle)xSSFCellStyle);
/* 32 */     createCell(row, 1, "Address", (CellStyle)xSSFCellStyle);
/* 33 */     createCell(row, 2, "E-mail", (CellStyle)xSSFCellStyle);
/* 34 */     createCell(row, 3, "LastName", (CellStyle)xSSFCellStyle);
/* 35 */     createCell(row, 4, "FirstName", (CellStyle)xSSFCellStyle);
/* 36 */     createCell(row, 5, "Phone", (CellStyle)xSSFCellStyle);
/* 37 */     createCell(row, 6, "Roles", (CellStyle)xSSFCellStyle);
/* 38 */     createCell(row, 7, "Enabled", (CellStyle)xSSFCellStyle);
/*    */   }
/*    */   
/*    */   private void createCell(Row row, int columnIndex, Object value, CellStyle style) {
/* 42 */     Cell cell = row.createCell(columnIndex);
/* 43 */     this.sheet.autoSizeColumn(columnIndex);
/*    */     
/* 45 */     if (value instanceof Integer) {
/* 46 */       cell.setCellValue(((Integer)value).intValue());
/* 47 */     } else if (value instanceof Boolean) {
/* 48 */       cell.setCellValue(((Boolean)value).booleanValue());
/*    */     } else {
/* 50 */       cell.setCellValue(value.toString());
/*    */     } 
/*    */     
/* 53 */     if (style != null) {
/* 54 */       cell.setCellStyle(style);
/*    */     }
/*    */   }
/*    */   
/*    */   public void export(List<NhanVien> listNhanVien, HttpServletResponse response) throws IOException {
/* 59 */     setResponseHeader(response, "application/octet-stream", ".xlsx", "users_");
/*    */     
/* 61 */     writeHeaderLine();
/* 62 */     writeDataLines(listNhanVien);
/*    */     
/* 64 */     ServletOutputStream outputStream = response.getOutputStream();
/* 65 */     this.workbook.write((OutputStream)outputStream);
/* 66 */     this.workbook.close();
/* 67 */     outputStream.close();
/*    */   }
/*    */   
/*    */   private void writeDataLines(List<NhanVien> listNhanVien) {
/* 71 */     int rowIndex = 1;
/*    */     
/* 73 */     XSSFCellStyle xSSFCellStyle = this.workbook.createCellStyle();
/* 74 */     XSSFFont xSSFFont = this.workbook.createFont();
/* 75 */     xSSFFont.setFontHeightInPoints((short)14);
/* 76 */     xSSFCellStyle.setFont((Font)xSSFFont);
/*    */     
/* 78 */     for (NhanVien nhanVien : listNhanVien) {
/* 79 */       Row row = this.sheet.createRow(rowIndex++);
/* 80 */       int columnIndex = 0;
/* 81 */       createCell(row, columnIndex++, nhanVien.getId(), (CellStyle)xSSFCellStyle);
/* 82 */       createCell(row, columnIndex++, nhanVien.getDiaChi(), (CellStyle)xSSFCellStyle);
/* 83 */       createCell(row, columnIndex++, nhanVien.getEmail(), (CellStyle)xSSFCellStyle);
/* 84 */       createCell(row, columnIndex++, nhanVien.getHo(), (CellStyle)xSSFCellStyle);
/* 85 */       createCell(row, columnIndex++, nhanVien.getTen(), (CellStyle)xSSFCellStyle);
/* 86 */       createCell(row, columnIndex++, nhanVien.getSoDienThoai(), (CellStyle)xSSFCellStyle);
/*    */       
/* 88 */       createCell(row, columnIndex++, Boolean.valueOf(nhanVien.isEnabled()), (CellStyle)xSSFCellStyle);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Export\NhanVienExcelExporter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */