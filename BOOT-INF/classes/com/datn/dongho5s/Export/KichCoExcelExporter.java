/*    */ package BOOT-INF.classes.com.datn.dongho5s.Export;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.KichCo;
/*    */ import com.datn.dongho5s.Export.AbstractExporter;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.util.Date;
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
/*    */ public class KichCoExcelExporter
/*    */   extends AbstractExporter {
/* 22 */   private XSSFWorkbook workbook = new XSSFWorkbook();
/*    */   private Sheet sheet;
/*    */   
/*    */   private void writeHeaderLine() {
/* 26 */     this.sheet = (Sheet)this.workbook.createSheet("Kích Cỡ");
/* 27 */     Row row = this.sheet.createRow(0);
/*    */     
/* 29 */     XSSFCellStyle xSSFCellStyle = this.workbook.createCellStyle();
/* 30 */     XSSFFont xSSFFont = this.workbook.createFont();
/* 31 */     xSSFFont.setBold(true);
/* 32 */     xSSFFont.setFontHeightInPoints((short)16);
/* 33 */     xSSFCellStyle.setFont((Font)xSSFFont);
/*    */     
/* 35 */     createCell(row, 0, "Size ID", (CellStyle)xSSFCellStyle);
/* 36 */     createCell(row, 1, "Name", (CellStyle)xSSFCellStyle);
/* 37 */     createCell(row, 2, "Description", (CellStyle)xSSFCellStyle);
/* 38 */     createCell(row, 3, "DateUpdated", (CellStyle)xSSFCellStyle);
/* 39 */     createCell(row, 4, "Enabled", (CellStyle)xSSFCellStyle);
/*    */   }
/*    */   
/*    */   private void createCell(Row row, int columnIndex, Object value, CellStyle style) {
/* 43 */     Cell cell = row.createCell(columnIndex);
/* 44 */     this.sheet.autoSizeColumn(columnIndex);
/*    */     
/* 46 */     if (value instanceof Integer) {
/* 47 */       cell.setCellValue(((Integer)value).intValue());
/* 48 */     } else if (value instanceof Boolean) {
/* 49 */       cell.setCellValue(((Boolean)value).booleanValue());
/*    */     }
/* 51 */     else if (value instanceof Date) {
/* 52 */       cell.setCellValue((Date)value);
/*    */     } else {
/*    */       
/* 55 */       cell.setCellValue(value.toString());
/*    */     } 
/*    */     
/* 58 */     if (style != null) {
/* 59 */       cell.setCellStyle(style);
/*    */     }
/*    */   }
/*    */   
/*    */   public void export(List<KichCo> listKichCo, HttpServletResponse response) throws IOException {
/* 64 */     setResponseHeader(response, "application/octet-stream", ".xlsx", "size_");
/*    */     
/* 66 */     writeHeaderLine();
/* 67 */     writeDataLines(listKichCo);
/*    */     
/* 69 */     ServletOutputStream outputStream = response.getOutputStream();
/* 70 */     this.workbook.write((OutputStream)outputStream);
/* 71 */     this.workbook.close();
/* 72 */     outputStream.close();
/*    */   }
/*    */   
/*    */   private void writeDataLines(List<KichCo> listKichCo) {
/* 76 */     int rowIndex = 1;
/*    */     
/* 78 */     XSSFCellStyle xSSFCellStyle = this.workbook.createCellStyle();
/* 79 */     XSSFFont xSSFFont = this.workbook.createFont();
/* 80 */     xSSFFont.setFontHeightInPoints((short)14);
/* 81 */     xSSFCellStyle.setFont((Font)xSSFFont);
/*    */     
/* 83 */     for (KichCo KichCo : listKichCo) {
/* 84 */       Row row = this.sheet.createRow(rowIndex++);
/* 85 */       int columnIndex = 0;
/* 86 */       createCell(row, columnIndex++, KichCo.getIdKichCo(), (CellStyle)xSSFCellStyle);
/* 87 */       createCell(row, columnIndex++, KichCo.getTenKichCo(), (CellStyle)xSSFCellStyle);
/* 88 */       createCell(row, columnIndex++, KichCo.getMoTaKichCo(), (CellStyle)xSSFCellStyle);
/* 89 */       createCell(row, columnIndex++, KichCo.getNgayTaoKichCo(), (CellStyle)xSSFCellStyle);
/* 90 */       createCell(row, columnIndex++, Boolean.valueOf(KichCo.isEnabled()), (CellStyle)xSSFCellStyle);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Export\KichCoExcelExporter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */