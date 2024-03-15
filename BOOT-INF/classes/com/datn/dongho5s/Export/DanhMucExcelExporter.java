/*    */ package BOOT-INF.classes.com.datn.dongho5s.Export;
/*    */ import com.datn.dongho5s.Entity.DanhMuc;
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
/*    */ public class DanhMucExcelExporter extends AbstractExporter {
/* 18 */   private XSSFWorkbook workbook = new XSSFWorkbook();
/*    */   private Sheet sheet;
/*    */   
/*    */   private void writeHeaderLine() {
/* 22 */     this.sheet = (Sheet)this.workbook.createSheet("Danh Mục");
/* 23 */     Row row = this.sheet.createRow(0);
/*    */     
/* 25 */     XSSFCellStyle xSSFCellStyle = this.workbook.createCellStyle();
/* 26 */     XSSFFont xSSFFont = this.workbook.createFont();
/* 27 */     xSSFFont.setBold(true);
/* 28 */     xSSFFont.setFontHeightInPoints((short)16);
/* 29 */     xSSFCellStyle.setFont((Font)xSSFFont);
/*    */     
/* 31 */     createCell(row, 0, "Categories ID", (CellStyle)xSSFCellStyle);
/* 32 */     createCell(row, 1, "Name", (CellStyle)xSSFCellStyle);
/* 33 */     createCell(row, 2, "Enabled", (CellStyle)xSSFCellStyle);
/*    */   }
/*    */   
/*    */   private void createCell(Row row, int columnIndex, Object value, CellStyle style) {
/* 37 */     Cell cell = row.createCell(columnIndex);
/* 38 */     this.sheet.autoSizeColumn(columnIndex);
/*    */     
/* 40 */     if (value instanceof Integer) {
/* 41 */       cell.setCellValue(((Integer)value).intValue());
/* 42 */     } else if (value instanceof Boolean) {
/* 43 */       cell.setCellValue(((Boolean)value).booleanValue());
/*    */     } else {
/* 45 */       cell.setCellValue(value.toString());
/*    */     } 
/*    */     
/* 48 */     if (style != null) {
/* 49 */       cell.setCellStyle(style);
/*    */     }
/*    */   }
/*    */   
/*    */   public void export(List<DanhMuc> listDanhMuc, HttpServletResponse response) throws IOException {
/* 54 */     setResponseHeader(response, "application/octet-stream", ".xlsx", "categories_");
/*    */     
/* 56 */     writeHeaderLine();
/* 57 */     writeDataLines(listDanhMuc);
/*    */     
/* 59 */     ServletOutputStream outputStream = response.getOutputStream();
/* 60 */     this.workbook.write((OutputStream)outputStream);
/* 61 */     this.workbook.close();
/* 62 */     outputStream.close();
/*    */   }
/*    */   
/*    */   private void writeDataLines(List<DanhMuc> listDanhMuc) {
/* 66 */     int rowIndex = 1;
/*    */     
/* 68 */     XSSFCellStyle xSSFCellStyle = this.workbook.createCellStyle();
/* 69 */     XSSFFont xSSFFont = this.workbook.createFont();
/* 70 */     xSSFFont.setFontHeightInPoints((short)14);
/* 71 */     xSSFCellStyle.setFont((Font)xSSFFont);
/*    */     
/* 73 */     for (DanhMuc danhMuc : listDanhMuc) {
/* 74 */       Row row = this.sheet.createRow(rowIndex++);
/* 75 */       int columnIndex = 0;
/* 76 */       createCell(row, columnIndex++, danhMuc.getId(), (CellStyle)xSSFCellStyle);
/* 77 */       createCell(row, columnIndex++, danhMuc.getTen(), (CellStyle)xSSFCellStyle);
/* 78 */       createCell(row, columnIndex++, Boolean.valueOf(danhMuc.isEnabled()), (CellStyle)xSSFCellStyle);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Export\DanhMucExcelExporter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */