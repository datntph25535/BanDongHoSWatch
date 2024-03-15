/*    */ package BOOT-INF.classes.com.datn.dongho5s.Export;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.VatLieu;
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
/*    */ public class VatLieuExcelExporter
/*    */   extends AbstractExporter
/*    */ {
/* 22 */   private XSSFWorkbook workbook = new XSSFWorkbook();
/*    */   private Sheet sheet;
/*    */   
/*    */   private void writeHeaderLine() {
/* 26 */     this.sheet = (Sheet)this.workbook.createSheet("Vật Liệu");
/* 27 */     Row row = this.sheet.createRow(0);
/*    */     
/* 29 */     XSSFCellStyle xSSFCellStyle = this.workbook.createCellStyle();
/* 30 */     XSSFFont xSSFFont = this.workbook.createFont();
/* 31 */     xSSFFont.setBold(true);
/* 32 */     xSSFFont.setFontHeightInPoints((short)16);
/* 33 */     xSSFCellStyle.setFont((Font)xSSFFont);
/*    */     
/* 35 */     createCell(row, 0, "Material ID", (CellStyle)xSSFCellStyle);
/* 36 */     createCell(row, 1, "Name", (CellStyle)xSSFCellStyle);
/* 37 */     createCell(row, 2, "Description", (CellStyle)xSSFCellStyle);
/* 38 */     createCell(row, 3, "Enabled", (CellStyle)xSSFCellStyle);
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
/*    */   public void export(List<VatLieu> listVatLieu, HttpServletResponse response) throws IOException {
/* 59 */     setResponseHeader(response, "application/octet-stream", ".xlsx", "material_");
/*    */     
/* 61 */     writeHeaderLine();
/* 62 */     writeDataLines(listVatLieu);
/*    */     
/* 64 */     ServletOutputStream outputStream = response.getOutputStream();
/* 65 */     this.workbook.write((OutputStream)outputStream);
/* 66 */     this.workbook.close();
/* 67 */     outputStream.close();
/*    */   }
/*    */   
/*    */   private void writeDataLines(List<VatLieu> listVatLieu) {
/* 71 */     int rowIndex = 1;
/*    */     
/* 73 */     XSSFCellStyle xSSFCellStyle = this.workbook.createCellStyle();
/* 74 */     XSSFFont xSSFFont = this.workbook.createFont();
/* 75 */     xSSFFont.setFontHeightInPoints((short)14);
/* 76 */     xSSFCellStyle.setFont((Font)xSSFFont);
/*    */     
/* 78 */     for (VatLieu vatLieu : listVatLieu) {
/* 79 */       Row row = this.sheet.createRow(rowIndex++);
/* 80 */       int columnIndex = 0;
/* 81 */       createCell(row, columnIndex++, vatLieu.getIdVatLieu(), (CellStyle)xSSFCellStyle);
/* 82 */       createCell(row, columnIndex++, vatLieu.getTenVatLieu(), (CellStyle)xSSFCellStyle);
/* 83 */       createCell(row, columnIndex++, vatLieu.getMoTaVatLieu(), (CellStyle)xSSFCellStyle);
/* 84 */       createCell(row, columnIndex++, Boolean.valueOf(vatLieu.isEnabled()), (CellStyle)xSSFCellStyle);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Export\VatLieuExcelExporter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */