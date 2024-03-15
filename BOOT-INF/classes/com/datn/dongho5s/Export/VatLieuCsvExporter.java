/*    */ package BOOT-INF.classes.com.datn.dongho5s.Export;
/*    */ 
/*    */ import com.datn.dongho5s.Entity.VatLieu;
/*    */ import com.datn.dongho5s.Export.AbstractExporter;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.supercsv.io.CsvBeanWriter;
/*    */ import org.supercsv.prefs.CsvPreference;
/*    */ 
/*    */ public class VatLieuCsvExporter
/*    */   extends AbstractExporter
/*    */ {
/*    */   public void export(List<VatLieu> listVatLieu, HttpServletResponse response) throws IOException {
/* 15 */     setResponseHeader(response, "text/csv", ".csv", "material_");
/*    */     
/* 17 */     CsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
/*    */     
/* 19 */     String[] csvHeader = { "ID", "Name", "Description", "Enabled" };
/* 20 */     String[] filedMapping = { "idVatLieu", "tenVatLieu", "moTaVatLieu", "enabled" };
/*    */     
/* 22 */     csvBeanWriter.writeHeader(csvHeader);
/* 23 */     for (VatLieu vatLieu : listVatLieu) {
/* 24 */       csvBeanWriter.write(vatLieu, filedMapping);
/*    */     }
/* 26 */     csvBeanWriter.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\Huy PC\Downloads\WebBanHang-20230821T142944Z-001\WebBanHang\app\app.jar!\BOOT-INF\classes\com\datn\dongho5s\Export\VatLieuCsvExporter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */