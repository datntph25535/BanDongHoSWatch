/*    */ package BOOT-INF.classes.com.datn.dongho5s.Export;
/*    */ import com.datn.dongho5s.Entity.ThuongHieu;
/*    */ import com.datn.dongho5s.Export.AbstractExporter;
/*    */ import java.io.IOException;
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
/*    */ public class ThuongHieuExcelExporter extends AbstractExporter {
/* 19 */   private XSSFWorkbook workbook = new XSSFWorkbook();
/*    */   private Sheet sheet;
/*    */   
/*    */   private void writeHeaderLine() {
/* 23 */     this.sheet = (Sheet)this.workbook.createSheet("Thương Hiệu");
/* 24 */     Row row = this.sheet.createRow(0);
/*    */     
/* 26 */     XSSFCellStyle xSSFCellStyle = this.workbook.createCellStyle();
/* 27 */     XSSFFont xSSFFont = this.workbook.createFont();
/* 28 */     xSSFFont.setBold(true);
/* 29 */     xSSFFont.setFontHeightInPoints((short)16);
/* 30 */     xSSFCellStyle.setFont((Font)xSSFFont);
/*    */     
/* 32 */     createCell(row, 0, "Brands ID", (CellStyle)xSSFCellStyle);
/* 33 */     createCell(row, 1, "Name", (CellStyle)xSSFCellStyle);
/* 34 */     createCell(row, 2, "Description", (CellStyle)xSSFCellStyle);
/* 35 */     createCell(row, 3, "Enabled", (CellStyle)xSSFCellStyle);
/*    */   }
/*    */   
/*    */   private void createCell(Row row, int columnIndex, Object value, CellStyle style) {
/* 39 */     Cell cell = row.createCell(columnIndex);
/* 40 */     this.sheet.autoSizeColumn(columnIndex);
/*    */     
/* 42 */     if (value instanceof Integer) {
/* 43 */       cell.setCellValue(((Integer)value).intValue());
/* 44 */     } else if (value instanceof Boolean) {
/* 45 */       cell.setCellValue(((Boolean)value).booleanValue());
/*    */     } else {
/* 47 */       cell.setCellValue(value.toString());
/*    */     } 
/*    */     
/* 50 */     if (style != null) {
/* 51 */       cell.setCellStyle(style);
/*    */     }
/*    */   }
/*    */   
/*    */   public void export(List<ThuongHieu> listThuongHieu, HttpServletResponse response) throws IOException {
/* 56 */     setResponseHeader(response, "application/octet-stream", ".xlsx", "brands_");
/*    */     
/* 58 */     writeHeaderLine();
/* 59 */     writeDataLines(listThuongHieu);
/*    */     
/* 61 */     ServletOutputStream outputStream = response.getOutputStream();
/* 62 */     this.workbook.write((OutputStream)outputStream);
/* 63 */     this.workbook.close();
/* 64 */     outputStream.close();
/*    */   }
/*    */   
/*    */   private void writeDataLines(List<ThuongHieu> listThuongHieu) {
/* 68 */     int rowIndex = 1;
/*    */     
/* 70 */     XSSFCellStyle xSSFCellStyle = this.workbook.createCellStyle();
/* 71 */     XSSFFont xSSFFont = this.workbook.createFont();
/* 72 */     xSSFFont.setFontHeightInPoints((short)14);
/* 73 */     xSSFCellStyle.setFont((Font)xSSFFont);
/*    */     
/* 75 */     for (ThuongHieu thuongHieu : listThuongHieu) {
/* 76 */       Row row = this.sheet.createRow(rowIndex++);
/* 77 */       int columnIndex = 0;
/* 78 */       createCell(row, columnIndex++, thuongHieu.getIdThuongHieu(), (CellStyle)xSSFCellStyle);
/* 79 */       createCell(row, columnIndex++, thuongHieu.getTenThuongHieu(), (CellStyle)xSSFCellStyle);
/* 80 */       createCell(row, columnIndex++, thuongHieu.getMoTaThuongHieu(), (CellStyle)xSSFCellStyle);
/* 81 */       createCell(row, columnIndex++, Boolean.valueOf(thuongHieu.isEnabled()), (CellStyle)xSSFCellStyle);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Export\ThuongHieuExcelExporter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */